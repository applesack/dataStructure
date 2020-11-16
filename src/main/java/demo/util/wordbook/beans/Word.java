package demo.util.wordbook.beans;

import lombok.Data;

import java.lang.reflect.Type;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月16日 15:08
 */
@Data
public class Word {

    enum Type { word, phrase }

    private Type type;

    // 单词
    private String word;

    // 释义
    private String paraphrase;

    // 音标
    private String soundMark;

    // 预留标记
    private int mark;

    // 注释
    private String comment;

    public Word() {
    }

    public Word(String word, String paraphrase, String soundMark, int mark, String comment) {
        this.word = word;
        this.paraphrase = paraphrase;
        this.soundMark = soundMark;
        this.mark = mark;
        this.comment = comment;
    }

    public static Type getType(String typeStr) {
        if ("phrase".equals(typeStr)) {
            return Type.phrase;
        }
        return Type.word;
    }

    public String toString() {
        return
                "[" + type.name() + "]" +
                "[" + word + "]," +
                "[" + paraphrase + "]," +
                "[" + soundMark + "]," +
                "[" + mark + "]," +
                "[" + comment + "],";
    }
}
