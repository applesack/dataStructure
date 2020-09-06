package java8.awt.bufferedImage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月17日 9:22
 */
public class BufferedImageTest {

    public static void main(String[] args) {
//        processGroup();
        try {
            sudoku();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processGroup() {
        Path sourcePath = Paths.get("java8", "awt", "tmp", "mlp.png");
        Path desPath;
        for (int i = 0; i<9; i++) {
            desPath = Paths.get( "java8", "awt", "tmp", "group", "mlp"+i+".png");
            PicUtil.compressPicForScale(sourcePath.toFile(), desPath.toFile());
        }
    }

    public static void sudoku() throws IOException {
        Path sourcePath = Paths.get("java8", "awt", "tmp", "group", "mlp0.png");
        Path targetPath = Paths.get("java8", "awt", "tmp", "group", "res_1.png");
        File sourceFile = sourcePath.toFile();
        File[] files = sourceFile.listFiles();
        PicUtil.mergeImage(targetPath.toFile(), 1, sourceFile);
    }
}
