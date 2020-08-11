package zleetcodes.util;

import org.junit.Test;

import java.util.*;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年06月14日 19:30
 */
public class 随机生成sql语句 {

    private static StringBuffer sb = new StringBuffer();
    private static HashMap<Integer, Integer> ID_LIST = new HashMap<>();
    private static Integer INSTANCE = new Integer(0);

    public static void main(String[] args) {
        /**
         * # : id
         * @ : name
         * % : sex
         * + : date
         * * : num
         */
        String student_info_sql = "INSERT INTO student_info(sid,name,sex,birthday) VALUES('#','@','%','+');";
        String student_grade_sql = "INSERT INTO student_grade(sid,language,math,english,ideology,science,sport,art,music) VALUES('#',*,*,*,*,*,*,*,*);";

        List<String> info_list = new ArrayList<>();
        List<String> grade_list = new ArrayList<>();

        int size = 300;
        // 填充数据
        for (int i = 0; i<size; i++) {
            info_list.add(student_info_sql);
            grade_list.add(student_grade_sql);
        }

        // 替换其中的值
        String info_tmp;
        String grade_tmp;
        String id;
        for (int i = 0; i<size; i++) {
            info_tmp = info_list.get(i);
            grade_tmp = grade_list.get(i);

            id = randId();
            info_tmp = replaceScoreMark(info_tmp, id);
            grade_tmp = replaceScoreMark(grade_tmp, id);

            // 替换
            info_list.set(i, info_tmp);
            grade_list.set(i, grade_tmp);
        }

        // 输出

        Iterator<String> iterator =  info_list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        iterator = grade_list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // 产生随机的id
    private static String randId() {
        StringBuffer sb = new StringBuffer();

        int year;
        int grade;
        int classes;
        int id;
        String var;
        do {
            sb.setLength(0);
            grade = (int) (Math.random()*(6-1)+1);
            classes = (int) (Math.random()*(4-1)+1);
            id = (int) (Math.random()*60);
            year = 20 - grade;

            var = String.valueOf(year);
            sb.append(var.length() == 1 ? "0"+var : var);

            var = String.valueOf(grade);
            sb.append("0" + var);

            var = String.valueOf(classes);
            sb.append("0" + var);

            var = String.valueOf(id);
            sb.append(var.length() == 1 ? "0"+var : var);
        } while (!isNoRepetition(Integer.valueOf(sb.toString())));

        return sb.toString();
    }
    // 判断一个id是否重复
    private static boolean isNoRepetition(int value) {
        Integer v = ID_LIST.get(value);
        if (v == null) {
            ID_LIST.put(value, INSTANCE);
            return true;
        }
        return false;
    }

    // 产生随机性别
    private static String randSex() {
        String[] sexs = {"男", "女"};
        int index = (int) (Math.random()*2);
        return sexs[index];
    }

    // 产生随机日期
    public static String randDate() {
        StringBuffer sb = new StringBuffer();
        sb.append((int) (Math.random()*(2014-2008)+2008));
        sb.append("-");
        String month = String.valueOf((int) (Math.random()*12));
        sb.append(month.length() == 1 ? "0"+month : month);
        sb.append("-");
        String day = String.valueOf((int) (Math.random()*31));
        sb.append(day.length() == 1 ? "0"+day : day);
        return sb.toString();
    }

    // 产生随机成绩
    public static String randScore() {
        return String.valueOf((int) (Math.random()*(100-50)+50));
    }

    // 将成绩标志替换成随机数值
    public static String replaceScoreMark(String score, String id) {
        StringBuffer sb = new StringBuffer();
        char mark;
        for (int i = 0; i<score.length(); i++) {
            mark = score.charAt(i);
            if (mark == '*') {
                sb.append(randScore());
            } else if (mark == '#') {
                sb.append(id);
            } else if (mark == '@') {
                sb.append((int) (Math.random()*(100-20)+20));
            } else if (mark == '%') {
                sb.append(randSex());
            } else if (mark == '+') {
                sb.append(randDate());
            } else {
                sb.append(mark);
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
//        for (int i = 0; i<10; i++) {
//            System.out.println(randDate());
//        }

//        String student_info_sql = "INSERT INTO student_info(sid,name,sex,birthday) VALUES(#,'@','%','+');";
//        System.out.println(replaceScoreMark(student_info_sql, "12"));

//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("INSERT INTO student_info(sid,name,sex,birthday) VALUES('");
//        System.out.println(stringBuffer); // 输出
//        stringBuffer.append(randDate());
//        System.out.println(stringBuffer); // 输出

        ID_LIST.put(new Integer(12), INSTANCE);
        System.out.println(isNoRepetition(13));
        System.out.println(isNoRepetition(13));
    }
}
