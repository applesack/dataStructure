package demo.util.wordbook;

import demo.component.ConsoleColor;
import demo.component.ErrorCommandException;
import demo.util.wordbook.beans.Lesson;
import demo.util.wordbook.beans.Word;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月16日 9:13
 */
public class WordbookContext {

    private final WordbookSimpleShell shell;
    private final ClassLoader clazzLoader;

    // 输入模式
    private InputMode inputMode = InputMode.STANDARD;

    // 提示符
    private final String DEFAULT_PROMPT = "wordbook> ";
    private final String INPUT_WORD = "input_word> ";
    private final String SILENT_WRITING = "silent_writing> ";

    // 一些文件的默认路径
    private final String CONFIG_FILE_PATH = "wordbooks/config.txt";
    private String WORDBOOK_PATH = "wordbooks/new_concept_english_1.txt";

    // 用于字符串拼接
    private final StringBuilder tmp = new StringBuilder();

    // 文件是否被更改过
    private boolean isChanged = false;

    public WordbookContext(WordbookSimpleShell simpleShell) {
        this.shell = simpleShell;
        clazzLoader  = Thread.currentThread().getContextClassLoader();
        changePrompt(this.DEFAULT_PROMPT);
    }

    public void changeInputMode(InputMode newMode) {
        this.inputMode = newMode;
        switch (this.inputMode) {
            case SILENT_WRITING:
                changePrompt(this.SILENT_WRITING); break;
            case INPUT_WORD:
                changePrompt(this.INPUT_WORD); break;
            case STANDARD:
                changePrompt(this.DEFAULT_PROMPT);
        }
    }

    // 返回分隔符
    public String getDelimiter() {
        return "&";
    }

    public InputMode getInputMode() {
        return this.inputMode;
    }

    public void changeWordbookPath(String nWordbookPath) {
        this.WORDBOOK_PATH = nWordbookPath;
    }

    // 通过类加载器加载配置
    public void loadConfig() throws ErrorCommandException {
        loadConfig(CONFIG_FILE_PATH);
    }

    public void loadConfig(String customize_config) throws ErrorCommandException {
        List<String> configs = loadConfig0(customize_config);
        for (String config : configs) {
            shell.interpret(config);
        }
    }

    // 尝试加载指定位置的配置文件
    private List<String> loadConfig0(String customize_config) {
        List<String> configLines = new ArrayList<>();
        File file = new File(Objects.requireNonNull(clazzLoader.getResource(customize_config)).getFile());

        if (!file.exists()) {
            System.out.println(ConsoleColor.GRAY + "默认配置文件不存在");
            return configLines;
        }

        readTextFile(file, (line) -> {
            line = line.trim();
            if (!line.startsWith("#"))
                configLines.add(line);
        });

        return configLines;
    }

    // 修改输入提示符
    private void changePrompt(String prompt) {
        shell.changePrompt(prompt);
    }

    // 加载单词本
    public List<Lesson> loadWordbook(Set<Integer> lessons) {
        boolean loadAll = lessons == null || lessons.isEmpty();
        List<Lesson> lessonList = new ArrayList<>();
        File wordbookFile = new File(Objects.requireNonNull(clazzLoader.getResource(WORDBOOK_PATH)).getFile());

        final Lesson[] currentLesson = {null};
        readTextFile(wordbookFile, (line) -> {
            line = line.trim();
            if (line.length() == 0)
                return;
            if (line.startsWith("@")) {
                if (currentLesson[0] != null)
                    lessonList.add(currentLesson[0]);
                currentLesson[0] = new Lesson();
                int lessonId = Integer.parseInt(line.substring(1).trim());
                if (lessonId == 0)
                    return;
                currentLesson[0].setLessonId(lessonId);
            } else {
                if (line.startsWith("#")) {
                    currentLesson[0].addCommand(line);
                } else {
                    if (loadAll) {
                        currentLesson[0].addWord(strToWord(line));
                    } else {
                        int lessonId = currentLesson[0].getLessonId();
                        if (lessons.contains(lessonId)) {
                            currentLesson[0].addWord(strToWord(line));
                        }
                    }
                }
            }
        });

        return lessonList;
    }

    // 将一行文本格式的单词信息还原成文本对象
    public static Word strToWord(String line) {
        String[] items = line.split(",");
        for (int i = 0; i<items.length; i++) {
            if (items[i].equals("[null]"))
                items[i] = "[]";
        }

        Word word = new Word();
        word.setType(Word.getType(items[0].substring(1, items[0].length() - 1)));
        word.setWord(items[1].substring(1, items[1].length() - 1));
        word.setParaphrase(items[2].substring(1, items[2].length() - 1));
        word.setSoundMark(items[3].substring(1, items[3].length() - 1));
        word.setMark(Integer.parseInt(items[4].substring(1, items[4].length() - 1)));
        word.setComment(items[5].substring(1, items[5].length() - 1));
        return word;
    }

    public static void readTextFile(File file, Consumer<String> lambda) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lambda.accept(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
