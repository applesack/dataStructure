package leetcodes.nums.p201_400;

public class P383 {
    
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] container = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            container[magazine.charAt(i) - 'a'] += 1;
        }
        
        int curIdx;
        for (int i = 0; i<ransomNote.length(); i++) {
            curIdx = ransomNote.charAt(i) - 'a';
            if (container[curIdx] > 0) {
                container[curIdx] -= 1;
            } else {
                return false;
            }
        }

        return true;
    }

}
