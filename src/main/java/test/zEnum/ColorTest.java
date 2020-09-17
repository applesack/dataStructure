package test.zEnum;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月17日 11:03
 */
public class ColorTest {

    public static void main(String[] args) {
        testFunc(Color.BLANK);
    }

    // 用于switch
    private static void testFunc(Color color) {
        switch (color) {
            case RED:
                System.out.println("红");
                break;
            case BLANK:
                System.out.println("空");
                break;
            case GREEN:
                System.out.println("绿");
                break;
            case YELLOW:
                System.out.println("黄");
        }
    }

}
