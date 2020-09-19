package leetcodes.nums.p100_200;

import java.util.ArrayList;
import java.util.List;

public class P68 {

    private static final P68 solution = new P68();

    public static void main(String[] args) {
        String[] words = new String[] {"This", "is", "an", "example", "of", "text", "justifcation."};
        System.out.println(solution.fullJustify(words, 16));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int idx = 0, oIdx, len = words.length;
        int countCharsInLine;
        StringBuffer sb = new StringBuffer();

        while (idx < words.length) {
            countCharsInLine = 0;
            oIdx = idx;

            while (idx < len && (countCharsInLine + words[idx].length()) <= maxWidth) {
                countCharsInLine += words[idx].length() + 1;
                idx++;
            }

            fillLine(words, oIdx, idx, maxWidth, sb);
        }

        return res;
    }
    
    private String fillLine(String[] words, int left, int right,
                        int maxWidth, StringBuffer sb) {
        sb.setLength(0);
        int charsCountOfWords = 0;
        for (int i = left; i < right; i++) {
            charsCountOfWords += words[i].length();
        }
        
        int gap = maxWidth - charsCountOfWords;
        int[] spaceList = new int[right - left - 1];
        int idx = 0;
        while (gap > 0) {
            spaceList[idx % spaceList.length]++;
            gap--;
        }

        for (int i = left; i<right - 1; i++) {
            sb.append(words[left]);
            for (int j = 0; j < spaceList[i - left]; j++) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }
}
