package awt.bufferedImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;

import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;
import sun.awt.image.BufferedImageGraphicsConfig;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月17日 9:33
 */
public class PicUtil {

    private static final int MAX_WIDTH  = 320;             // 默认图片宽度
    private static final int MAX_HEIGHT = 320;             // 默认图片高度
    private static final double DEFAULT_ACCURACY = 0.9;    // 默认图片精度
    private static final int DEFAULT_FILE_SIZE   = 200;    // 默认图片大小

    public static String compressPicForScale(String srcPath, String desPath) {
        File srcFile = new File(srcPath);
        File desFile = new File(desPath);

        if (!srcFile.exists())
            return "";
        if (!desFile.getParentFile().exists()) {
            desFile.getParentFile().mkdirs();
        }
        return compressPicForScale(srcFile, desFile,
                DEFAULT_FILE_SIZE, DEFAULT_ACCURACY,
                MAX_WIDTH, MAX_HEIGHT);
    }

    public static String compressPicForScale(File srcFile, File desFile) {
        if (!srcFile.exists())
            return "";
        if (!desFile.getParentFile().exists())
            desFile.getParentFile().mkdirs();

        return compressPicForScale(srcFile, desFile,
                    DEFAULT_FILE_SIZE, DEFAULT_ACCURACY,
                    MAX_WIDTH, MAX_HEIGHT);
    }

    /**
     * 根据指定大小和指定精度压缩图片
     *
     * @param srcFile 源图片地址
     * @param desFile 目标图片地址
     * @param desFileSize 指定图片大小，单位kb
     * @param accuracy 精度，递归压缩的比率，建议小于0.9
     * @param desMaxWidth 目标最大宽度
     * @param desMaxHeight 目标最大高度
     * @return 目标文件路径
     */
    public static String compressPicForScale(File srcFile, File desFile,
                                              long desFileSize, double accuracy,int desMaxWidth,int desMaxHeight) {
        try {
            long srcFileSize = srcFile.length();
            System.out.println("源图片：" + srcFile + "，大小：" + srcFileSize / 1024
                    + "kb");
            //获取图片信息
            BufferedImage bim = ImageIO.read(srcFile);
            int srcWidth = bim.getWidth();
            int srcHeight = bim.getHeight();

            //先转换成jpg
            Thumbnails.Builder builder = Thumbnails.of(srcFile).outputFormat("png");

            // 指定大小（宽或高超出会才会被缩放）
            if(srcWidth > desMaxWidth || srcHeight > desMaxHeight) {
                builder.size(desMaxWidth, desMaxHeight);
            }else{
                //宽高均小，指定原大小
                builder.size(srcWidth,srcHeight);
            }

            // 写入到内存
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); //字节输出流（写入到内存）
            builder.toOutputStream(baos);

            // 递归压缩，直到目标文件大小小于desFileSize
            byte[] bytes = compressPicCycle(baos.toByteArray(), desFileSize, accuracy);

            // 输出到文件
            FileOutputStream fos = new FileOutputStream(desFile);
            fos.write(bytes);
            fos.close();

            System.out.println("目标图片：" + desFile + "，大小" + desFile.length() / 1024 + "kb");
            System.out.println("图片压缩完成！");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return desFile.getAbsolutePath();
    }

    private static byte[] compressPicCycle(byte[] bytes, long desFileSize, double accuracy) throws IOException {
        // File srcFileJPG = new File(desPath);
        long srcFileSizeJPG = bytes.length;
        // 2、判断大小，如果小于500kb，不压缩；如果大于等于500kb，压缩
        if (srcFileSizeJPG <= desFileSize * 1024) {
            return bytes;
        }
        // 计算宽高
        BufferedImage bim = ImageIO.read(new ByteArrayInputStream(bytes));
        int srcWidth = bim.getWidth();
        int srcHeight = bim.getHeight();
        int desWidth = new BigDecimal(srcWidth)
                .multiply(new BigDecimal(accuracy)).intValue();
        int desHeight = new BigDecimal(srcHeight)
                .multiply(new BigDecimal(accuracy)).intValue();

        //字节输出流（写入到内存）
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Thumbnails.of(new ByteArrayInputStream(bytes))
                .size(desWidth, desHeight)
                .outputQuality(accuracy)
                .toOutputStream(baos);
        return compressPicCycle(baos.toByteArray(), desFileSize, accuracy);
    }

    private static final int GAP = 25;
    public static void mergeImage(File destFile, int start, File ... files) throws IOException {
        start -= 1; // 九宫格起始位置从0开始算
        if (start < 0 || files == null || files.length == 0)
            return;

        BufferedImage destImage;
        // 假如目的文件不存在，则新创建一个BufferedImage，否则用该目的文件生成
        if (!destFile.getParentFile().exists()) {
            destFile.getParentFile().mkdirs();
            destImage = new BufferedImage((MAX_WIDTH + GAP) * 3 + GAP,
                    (MAX_HEIGHT + GAP) * 3 + GAP, BufferedImage.TYPE_INT_ARGB);
        } else {
            destImage = ImageIO.read(destFile);
        }

        int size = 9 - start;
        int len = Math.min(files.length, size);
        BufferedImage[] images = new BufferedImage[len];
        for (int i = 0; i<len; i++) {
            images[i] = ImageIO.read(files[i]);
        }

        int x, y, row, column;
        for (int i = start; i<(start + len); i++) {
            row    = i / 3;
            column = i % 3;

            x = (column * (MAX_WIDTH  + GAP)) + GAP;
            y = (row    * (MAX_HEIGHT + GAP)) + GAP;

            BufferedImage tmpImg = images[i - start];
            int imgSize = tmpImg.getWidth() * tmpImg.getHeight();
            int[] imgRGB = new int[imgSize];
            tmpImg.getRGB(0,0, tmpImg.getWidth(), tmpImg.getWidth(), imgRGB, 0, tmpImg.getWidth());

            destImage.setRGB(x, y, tmpImg.getWidth(), tmpImg.getHeight(), imgRGB, 0, tmpImg.getWidth());
        }

        ImageIO.write(destImage, "png", destFile);
    }
}
