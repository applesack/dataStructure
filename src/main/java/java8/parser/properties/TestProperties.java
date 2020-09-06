package java8.parser.properties;

import org.junit.Test;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月27日 15:04
 */
public class TestProperties {

    @Test
    public void case_1() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = Object.class.getResourceAsStream("/items.properties");
        properties.load(inputStream);

        System.out.println(properties.getProperty("myFavoriteArtist"));
    }

    @Test
    public void case_2() throws IOException {
        Properties properties;
        properties = PropertiesLoaderUtils.loadAllProperties("/item.properties");

        System.out.println(properties.getProperty("myFavoriteArtist"));
    }
}
