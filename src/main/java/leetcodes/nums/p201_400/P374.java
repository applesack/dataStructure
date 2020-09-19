package leetcodes.nums.p201_400;

public class P374 {
    
    private static int TARGET_NUM = 
    1702766719;
    public static void main(String[] args) {
        int input = 
                // 1;
                // 10;
                // 1000;
                2126753390;
        // System.out.println(Math.max(TARGET_NUM, input));
        System.out.println(guessNumber(input));
    }

    public static int guessNumber(int n) {
        if (guess(n) == 0)
            return n;

        int left = 0, right = n + 1, mid, res;
        while (left < right) {
            mid = left + (right - left) / 2;
            System.out.println(mid);
            res = guess(mid);
            if (res < 0) {        // 所选的数字偏大，向左边查找
                right = mid;
            } else if (res > 0) { // 所选的数字偏小，向右边查找
                left = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static int guess(int num) {
        if (num == TARGET_NUM)
            return 0;
        if (num > TARGET_NUM) {
            return -1;
        } else 
            return 1;
    }

}
