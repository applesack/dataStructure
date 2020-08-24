package util;

import 排序算法.快速排序.QuickSort;

import java.util.Calendar;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月11日 0:04
 */
class UtilTest {

    private class Student {
        public Student() {}

        public Student(int arg1, int arg2) { this.age = arg1;}

        public Student(String name, int age) {this.age = age; this.name = name;}

        int age;
        String name;

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}


