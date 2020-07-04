package test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年06月30日 17:04
 */
public class Go {

    private static final boolean FLAG = true;

    public void func1() {
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
    }

    public boolean func2() {
        System.out.println("a");
        if (FLAG) return false;
        System.out.println("b");
        System.out.println("c");
        return true;
    }


}
