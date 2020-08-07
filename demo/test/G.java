package test;

import org.junit.Test;

import java.util.Objects;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月05日 18:57
 */
public class G {

    @Test
    public void testFunc() {
        printType(new Clazz());
        printType(new String());
        printType(new Integer(3));
        printType(new int[12]);
        printType(new char[12]);
    }

    private <T> void printType(T type) {
        System.out.println(type.getClass().getName());
    }

    @Test
    public void testClazz() {
        员工 员工对象 = new 员工(4200, 25);
        员工对象.显示一个员工的信息();

        int a = (int) 1.9;
        System.out.println(a);
    }

    private class 员工 {
        private int 工资;
        private int 年龄;
        public 员工(int 工资, int 年龄) {
            this.工资 = 工资;
            this.年龄 = 年龄;
        }
        public void 显示一个员工的信息() {
            System.out.println("年龄:"+年龄+", 工资:"+工资);
        }
    }
}
