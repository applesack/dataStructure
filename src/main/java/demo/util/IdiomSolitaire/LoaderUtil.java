package demo.util.IdiomSolitaire;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月26日 11:58
 */
public class LoaderUtil {

    /**
     * 资源文件的路径
     * FILE_NAME的路径是相对于当前文件的
     * FULL_FILE_PATH是资源文件对应的File对象
     */
    private static final String FILE_NAME = "data/data.dat";
    private static final File FULL_FILE_PATH;
    private static WordMap WORD_MAP;

    /**
     * 数据库信息：
     * 当目标文件不存在，则使用这些数据访问数据库
     */
    private static final String DB_NAME = "grade";       // 可修改
    private static final String TABLE_NAME = "phrases";  // 可修改
    private static final String DB_USER = "root";        // 可修改
    private static final String DB_PASSWD = "admin";     // 可修改
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";

    // 字符串缓存
    private static final StringBuilder sb = new StringBuilder();
    // 存储音节的map，在需要的时候初始化 | key: 各种加音标的音节;  value: 音节的原型
    private static Map<Character, Character> syllableMap;

    static {
        // 获取当前文件的路径
        FULL_FILE_PATH = new File(getInstance().getClass()
                .getResource("")
                .getPath() + File.separator + FILE_NAME);

        // 后续可能需要数据库操作，所以这里将JDBC加载入内存
        try {
            Class.forName("com.mysql.jdbc.Driver");
            initialization(FULL_FILE_PATH.exists());
        } catch (Exception e) {
            // 加载文件报错，则直接退出
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * 假如资源文件不存在，则执行这个方法
     * 使用数据库的文件，加载数据，生成目标文件
     * @param isExists obj.exists()
     */
    private static void initialization(boolean isExists) throws SQLException {
        // 假如存在，则从这个文件加载对象
        if (isExists) {
            try (FileInputStream fileInputStream = new FileInputStream(FULL_FILE_PATH);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                WORD_MAP = (WordMap) objectInputStream.readObject();

            } catch (IOException | ClassNotFoundException exception) {
                exception.printStackTrace();
                System.exit(0);
            }
            return;
        }

        // 初始化音节map
        initSyllableMap();

        // 获取数据库连接
        sb.setLength(0);
        sb.append(JDBC_URL).append(DB_NAME);
        String sql = "SELECT * FROM " + TABLE_NAME + " LIMIT 100";
        try (Connection conn = DriverManager.getConnection(sb.toString(), DB_USER, DB_PASSWD);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            // 查询数据表, 查询所有数据
            List<Idiom> wordList = new ArrayList<>();
            while (resultSet.next()) {
                Idiom idiom = new Idiom();
                idiom.setId(resultSet.getInt(1));
                idiom.setWord(resultSet.getString(2));

                // 将字符串用空格分隔后以链表格式存储
                idiom.setPinYin(Stream.of(resultSet.getString(3).split(" "))
                    .filter(w -> !w.isBlank()).collect(toCollection(LinkedList::new)));

                idiom.setAllusion(resultSet.getString(4));
                idiom.setProvenance(resultSet.getString(5));
                idiom.setSpellFirst(resultSet.getString(7));

                wordList.add(idiom);
            }

            WORD_MAP = mapToWordMap(wordList);

            // 将生成好的对象序列化到文件中
            try (FileOutputStream fileOutputStream = new FileOutputStream(FULL_FILE_PATH);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

                objectOutputStream.writeObject(WORD_MAP);

            } catch (IOException ioException) {

            }
        }
    }

    // 将list转为map, 转换的同时对于音标进行处理
    private static WordMap mapToWordMap(List<Idiom> list) {

        WordMap wordMap = new WordMap();
        for (Idiom idiom : list) {
            for (String str : idiom.getPinYin()) {
                char[] pinYin = str.toCharArray();
                for (int i = 0; i < pinYin.length; i++) {
                    char curChar = pinYin[i];
                    if (syllableMap.containsKey(curChar)) {
                        pinYin[i] = syllableMap.get(curChar);
                    }
                }
            }
            wordMap.put(idiom.getPinYin(), idiom);
        }

        return wordMap;
    }

    private static void initSyllableMap() {
        syllableMap = new HashMap<>();

        Character[] syllables = {'a', 'e', 'i', 'o', 'u'};
        Character[][] syllableList = {
                {'ā', 'á', 'ǎ', 'à'},
                {'ē', 'é', 'ě', 'è'},
                {'ī', 'í', 'ǐ', 'ì'},
                {'ō', 'ó', 'ǒ', 'ò'},
                {'ū', 'ú', 'ü', 'ǚ', 'ù'},
        };

        for (int i = 0; i<syllables.length; i++) {
            Character value = syllables[i];
            for (int j = 0; j<syllableList[i].length; j++) {
                syllableMap.put(syllableList[i][j], value);
            }
        }
    }

    public static WordMap getWordMap() {
        return WORD_MAP;
    }

    public static LoaderUtil getInstance() {
        return SingleTon.INSTANCE;
    }

    private static class SingleTon {
        public static final LoaderUtil INSTANCE = new LoaderUtil();
    }

    private LoaderUtil() {
    }
}
