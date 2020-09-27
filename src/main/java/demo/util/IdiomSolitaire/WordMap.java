package demo.util.IdiomSolitaire;

import java.io.Serializable;
import java.util.*;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月26日 12:26
 */
public class WordMap extends HashMap<LinkedList<String>, Idiom> implements Serializable {

    private final int MAX_SIZE = 256;
    private final int CANDIDATE_SIZE = 5;

    private StringBuilder sb = new StringBuilder();

    private Deque<String> history = new LinkedList<>();

    /**
     * 输出候选项信息
     * @param size 候选项长度
     */
    public void getNext(String word, int size) {
        List<Idiom> res = new ArrayList<>();
        int max_size = size == -1 ? size() : size;

        for (Entry<LinkedList<String>, Idiom> entry : entrySet()) {
            if (res.size() > max_size)
                break;

            if (entry.getKey().getFirst().equals(word)) {
                res.add(entry.getValue());
            }
        }

        for (int i = 0; i<res.size(); i++) {
            printIdiom(i, res.get(i));
        }
    }

    private void printIdiom(int num, Idiom idiom) {
        sb.setLength(0);
        sb.append("    ")
                .append(num).append(": ")
                .append(idiom.getWord())
                .append(" 注音")
                .append(idiom.getPinYin());
        System.out.println(sb);
    }

    public void getNext(String word) {
        getNext(word, CANDIDATE_SIZE);
    }

}
