package leetcodes.nums.p100_200;

public class P168 {
    
    private static final P168 solution = new P168();

    public static void main(String[] args) {
        System.out.println(solution.convertToTitle(701));
    }

    public String convertToTitle(int n) {
        
        char[] words = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuffer sb = new StringBuffer();

        while (n > 0) {
            n--;
            sb.insert(0, words[n % 26]);
            n /= 26;
        }

        return sb.toString();
    }

}
