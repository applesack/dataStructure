package demo.util.IdiomSolitaire;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月26日 12:40
 */
@Data
public class Idiom implements Serializable {

    // 该成语在数据库中的id
    private int id;

    // 成语
    private String word;

    // 成语的拼音
    private LinkedList<String> pinYin;

    // 典故
    private String allusion;

    // 出处
    private String provenance;

    // 全拼
    private String spellFirst;
}
