package demo.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/**
 * 获取这个项目的所有文件的创建信息
 * 具体的创建信息由javaDOC为准
 * jdk-11
 *
 * @author : flutterdash@qq.com
 * @since : 2020年10月10日 20:55
 */
public class ProjectCreateInfo {

    public static void main(String[] args) throws IOException {
        projectInfo.start();
    }

    private static final ProjectCreateInfo projectInfo = new ProjectCreateInfo();

    // 默认的包名
    private static final String DEFAULT_PACK = "";
    // 要提取的信息
    private static final Set<String> COMMENT_SET = new HashSet<>();

    static {
        COMMENT_SET.add("@since");
        COMMENT_SET.add("@date");
    }

    private ProjectCreateInfo() {
    }

    public void start() throws IOException {
        final File rootDir = Paths.get("src", "main", "java").toFile();
        File[] javaFiles = rootDir.listFiles((tFile) -> tFile.getName().endsWith("java"));
        Stream<String> javaTextFile;
        assert javaFiles != null : "文件为空";
        for (File textFile : javaFiles) {
            javaTextFile = Files.lines(textFile.toPath(), StandardCharsets.UTF_8);
        }
    }

    public void findCommentAndGetCreateInfo(List<File> fileList) {

    }

    private static class CreateInfo {

        Date date;
        String filename;
        String author;

    }

}
