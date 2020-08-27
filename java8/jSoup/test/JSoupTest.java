package jSoup.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月27日 8:42
 */
public class JSoupTest {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://www.baidu.com").get();
        System.out.println(doc);
    }
}
