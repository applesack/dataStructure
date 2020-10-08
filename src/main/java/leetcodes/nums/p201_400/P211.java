package leetcodes.nums.p201_400;

import org.junit.Test;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月08日 12:29
 */
public class P211 {

    @Test
    public void testFunc() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));

    }

    static class WordDictionary {

        HashMap<Integer, Set<String>> dict;

        /** Initialize your data structure here. */
        public WordDictionary() {
            dict = new HashMap<>();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Set<String> set = dict.computeIfAbsent(word.length(), key -> new HashSet<>());
            set.add(word);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            int size = word.length();
            Set<String> set = dict.get(size);
            if (set == null || set.isEmpty())
                return false;


            for (String item : set) {
                if (match(word, item, size))
                    return true;
            }

            return false;
        }

        private boolean match(String template, String word, int size) {
            for (int i = 0; i<size; i++) {
                char curChar = template.charAt(i);
                if (curChar == '.')
                    continue;
                if (curChar != word.charAt(i))
                    return false;
            }

            return true;
        }
    }

}
