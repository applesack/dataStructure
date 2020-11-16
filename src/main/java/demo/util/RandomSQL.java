package demo.util;

import demo.component.ConsoleColor;
import demo.component.Location;
import demo.component.Type;
import org.junit.Test;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 生成随机的SQL插入语句
 *
 * @author : flutterdash@qq.com
 * @since : 2020年10月29日 10:25
 */
public class RandomSQL {

    private static final String INSERT_PREFIX = "INSERT INTO";
    private static final String VALUES_STR    = "VALUES";
    private static final char END_SIGN        = ';';

    private static final StringBuilder tmp = new StringBuilder();
    private static final StringBuilder sb = new StringBuilder();
    private static final Random random = new Random();

    private static final File DESKTOP_DIR = FileSystemView.getFileSystemView().getHomeDirectory();

    private static final Class<RandomSQL> clazz = RandomSQL.class;

    @Test
    public void test() {
        /**
         * 使用示例
         */

        // 使用自定义的生成器
        Generator generator = (column, sb, rand) -> {
            int num = rand.nextInt();
            sb.append(num % 2 == 0 ? '男' : '女');
        };

        // 输入表名(必填)
        new RandomSQL.Builder("student_info")
                // 插入主键，选择属性值
                .addColumn("id", Type.DEFAULT, 4, 0, false, true, null)
                .addColumn("sid", Type.INTEGER, 4)
                .addColumn("name", Type.STRING, 3)
                // 这个字段使用自定义的生成器来生成随机数值
                .addColumn("sex", Type.STRING, generator)
                .addColumn("birthday", Type.DATE)
                // 选择要生成多少条记录
                .size(12)
                // 选择输出结果的方式，参数可以是一个代表文件位置的字符串，选择在桌面生成或者在控制台输出可以不用参数(null)
                .write(Location.CONSOLE, null)
                // 得到结果
                .run();
    }

    /**
     * 启动
     * @param builder 构造者
     */
    private static void run(Builder builder) {
        List<String> sqlLines = new LinkedList<>();

        // 生成头部
        sqlLines.add(generateHeader(builder));

        // 生成随机插入数值
        Set<String> primaryKeySet = new HashSet<>();
        for (int i = 0; i<builder.size; i++) {
            try {
                sqlLines.add(generateValueBody(builder, primaryKeySet));
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // 处理最后插入的一条记录，将逗号替换成分号
        char[] lastRecordChars = sqlLines.get(sqlLines.size() - 1).toCharArray();
        lastRecordChars[lastRecordChars.length - 2] = END_SIGN;
        sqlLines.set(sqlLines.size() - 1, String.valueOf(lastRecordChars));

        // 输出
        builder.writeable.write(sqlLines);
    }

    /**
     * 根据构建者的信息生成插入语句头部，
     *      例： <code>INSERT INTO table_name (`column1`, `column2`, `column3` ... ) VALUES\n</code>
     * @param builder 构建者，带有字段的信息
     * @return 生成好的插入语句头部
     */
    private static String generateHeader(Builder builder) {
        tmp.setLength(0);
        tmp.append(INSERT_PREFIX).append(' ')
                .append(builder.tableName)
                .append(' ').append('(');
        tmp.append(builder.record.stream()
                .map(column -> '`' + column.name + '`')
                .collect(Collectors.joining(", ")));
        tmp.append(')')
                .append(' ' + VALUES_STR + '\n');
        return tmp.toString();
    }

    /**
     *
     * @param builder 构造者
     * @param primaryKeySet 主键集
     * @return 要插入的数值
     * @throws NoSuchMethodException igor
     * @throws InvocationTargetException igor
     * @throws IllegalAccessException igor
     */
    private static String generateValueBody(Builder builder, Set<String> primaryKeySet)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        tmp.setLength(0);
        tmp.append('(');

        List<Column> record = builder.record;
        String[] columns = new String[record.size()];
        for (int i = 0; i<columns.length; i++) {
            Column column = record.get(i);
            // ranXxx
            String methodName = "rand" + captureName(column.type.name());
            Method method = clazz.getMethod(methodName, Column.class);

            // 当前字段是主键，做为id处理
            if (column.isPrimaryKey) {
                if (column.type == Type.DEFAULT) {
                    columns[i] = (String) method.invoke(null, column);
                } else {
                    String id = (String) method.invoke(null, column);
                    while (primaryKeySet.contains(id)) {
                        id = (String) method.invoke(null, column);
                    }
                    primaryKeySet.add(id);
                    columns[i] = id;
                }
            }
            // 普通字段
            else {
                columns[i] = (String) method.invoke(null, column);
            }
        }

        tmp.append(String.join(", ", columns))
                .append("),\n");
        return tmp.toString();
    }

    public static String captureName(String str) {
        char[] cs = str.toLowerCase().toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    /********************************************生成随机数据*************************************************/

    // 生成随机数字
    public static String randInteger(Column column) {
        sb.setLength(0);
        if (column.generator != null) {
            column.generator.genRandomValue(column, sb, random);
        } else {
            for (int i = 0; i<column.size; i++) {
                sb.append(random.nextInt(10));
            }
        }
        return sb.toString();
    }

    // 生成随机字符串
    public static String randString(Column column) {
        sb.setLength(0);
        if (column.generator != null) {
            column.generator.genRandomValue(column, sb, random);
        } else {
            for (int i = 0; i<column.size; i++) {
                char cur = (char) ('a' + random.nextInt(26));
                sb.append(cur);
            }
        }
        sb.insert(0, "\"");
        sb.append("\"");
        return sb.toString();
    }

    // 生成随机单精度浮点
    public static String randFloat(Column column) {
        return randDouble(column);
    }

    // 生成随机双精度浮点
    public static String randDouble(Column column) {
        sb.setLength(0);
        if (column.generator != null) {
            column.generator.genRandomValue(column, sb, random);
        } else {
            int dLen = column.decimal;
            int iLen = column.size - (dLen == 0 ? 0 : dLen +  1);
            for (int i = 0; i<iLen; i++) {
                sb.append(1 + random.nextInt(8));
            }
            if (dLen != 0)
                sb.append('.');
            for (int i = 0; i<dLen; i++) {
                sb.append(random.nextInt(9));
            }
        }
        return sb.toString();
    }

    // 生成随机日期
    public static String randDate(Column column) {
        sb.setLength(0);
        if (column.generator != null) {
            column.generator.genRandomValue(column, sb, random);
            return sb.toString();
        } else {
            String year, month, day;
            year = String.valueOf(1985 + random.nextInt(40));
            month = String.valueOf(1 + random.nextInt(12));
            day = String.valueOf(1 + random.nextInt(30));
            return String.join("-", year, month, day);
        }
    }

    public static String randDefault(Column column) {
        sb.setLength(0);
        if (column.generator != null) {
            column.generator.genRandomValue(column, sb, random);
            return sb.toString();
        }
        return "DEFAULT";
    }

    /******************************************************************************************************/

    /********************************************输出sql方式*************************************************/

    // 将生成好的sql语句以文件的形式生成到桌面
    private static Writeable writeToDesktop(String tableName) {
        return (sqlLines) -> {
            String filename = tableName + "_insert_sql.txt";
            String fullFilename = DESKTOP_DIR.getAbsolutePath() + File.separator + filename;
            File destFile = new File(fullFilename);

            writer(destFile, sqlLines);
        };
    }

    // 将生成好的sql语句以文件的形式生成到目标目录
    private static Writeable writeToSpecifyDir(File file) {
        return (sqlLines) -> writer(file, sqlLines);
    }

    // 直接输出在控制台
    private static Writeable writeToConsole() {
        return (sqlLines) -> {
            for (String line : sqlLines) {
                System.out.print(ConsoleColor.GRAY + line);
            }
        };
    }

    private static void writer(File file, List<String> lines) {
        try (Writer writer = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8)) {
            for (String line : lines) {
                writer.write(line);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /******************************************************************************************************/

    public static class Builder {
        private final List<Column> record;
        private final String tableName;
        private boolean hasPrimaryKey;
        private int size;
        private Writeable writeable;

        public Builder(String tableName) {
            this.tableName = tableName;
            writeable = writeToConsole();
            hasPrimaryKey = false;
            size = 8;
            record = new ArrayList<>(4);
        }

        // 使用自定义的生成器来生成数值
        public Builder addColumn(String columnName, Type columnType, Generator generator) {
            return addColumn(columnName, columnType, 0, 0, false, false, generator);
        }

        public Builder addColumn(String columnName, Type columnType) {
            return addColumn(columnName, columnType, 6, 0, false, false, null);
        }

        public Builder addColumn(String columnName, Type columnType, int size) {
            return addColumn(columnName, columnType, size, 0, false, false, null);
        }

        public Builder addColumn(String columnName, Type columnType,
                                 int size, int decimal,
                                 boolean nullable, boolean primaryKey,
                                 Generator generator) {
            if (primaryKey) {
                if (hasPrimaryKey) {
                    System.out.println(ConsoleColor.RED + "该表已经存在主键, 应用在字段{`" + columnName + "`}的主键将不被生效.");
                    primaryKey = false;
                } else
                    hasPrimaryKey = true;
            }

            record.add(new Column(columnName, columnType, size, decimal, nullable, primaryKey, generator));

            return this;
        }

        public Builder size(int size) {
            this.size = size;
            return this;
        }

        public Builder write(Location location, String parameter) {
            switch (location) {
                case CONSOLE:
                    this.writeable = writeToConsole();
                    break;
                case DESKTOP:
                    this.writeable = writeToDesktop(tableName);
                    break;
                case CUSTOMIZE:
                    this.writeable = writeToSpecifyDir(new File(parameter));
                    break;
            }
            return this;
        }

        public void run() {
            RandomSQL.run(this);
        }

    }

    /**
     * 存放一个字段的信息
     * 一个数据表包含多个字段
     */
    private static class Column {

        public final String name;           // 字段名
        public final Type type;             // 字段类型
        public final int size;              // 长度
        public final int decimal;           // 小数点位数
        public final boolean nullable;      // 是否可以为空
        public final boolean isPrimaryKey;  // 是否是主键
        public final Generator generator;   // 是否使用用自定义的生成器来生成数值

        public Column(String name, Type type, int size, int decimal, boolean nullable, boolean isPrimaryKey, Generator gen) {
            this.name = name;
            this.type = type;
            this.size = size;
            this.decimal = decimal;
            this.nullable = nullable;
            this.isPrimaryKey = isPrimaryKey;
            this.generator = gen;
        }
    }

    @FunctionalInterface
    public interface Writeable {

        /**
         * 输出sql语句的方式
         * 参数sqlLine是一个完整的sql插入语句，但是为了保证可读性，一行只包含一条记录
         * @param sqlLines ig
         */
        void write(List<String> sqlLines);

    }

    @FunctionalInterface
    public interface Generator {

        /**
         * 这个方法不需要返回任何数据，只需要把产生的随机数值以字符串的形式存放在StringBuilder中即可，
         * 系统会在某个节点将StringBuilder和Random对象注入，可供使用。
         * 在调用方法之后系统会读取StringBuilder中的数据。
         * @param column 字段信息
         * @param sb 缓存字符串, 一般情况下，调用此方法之前，缓存都已清空，所以可以不用sb.setLength(0)操作。
         * @param random 随机对象
         */
        void genRandomValue(Column column, StringBuilder sb, Random random);

    }
}
