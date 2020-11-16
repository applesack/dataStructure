package demo.util.wordbook.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月16日 15:26
 */
public class Lesson {

    // 课程编号
    private Integer lessonId;

    // 包含的单词
    private final List<Word> words;

    // 备注列表
    private final List<String> comments;

    public Lesson() {
        words = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public Lesson(Integer lessonNumber, List<Word> words, List<String> comments) {
        lessonId = lessonNumber;
        this.words = words;
        this.comments = comments;
    }

    public void addCommand(String comment) {
        this.comments.add(comment);
    }

    public void addWord(Word word) {
        this.words.add(word);
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

}
