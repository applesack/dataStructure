package test.xml;

import demo.util.Shell;
import demo.util.wordbook.WordbookSimpleShell;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月22日 12:53
 */
public class ReadDemo {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File f = Paths.get("src", "main", "java", "test", "xml", "files", "demo.xml").toFile();

        if (!f.exists()) {
            System.err.println(f.getAbsolutePath() + " 路径不存在");
            return;
        }

        Document doc = builder.parse(f);
        Element root = doc.getDocumentElement();
        NodeList children = root.getChildNodes();
        for (int i = 0; i<children.getLength(); i++) {
            Node child = children.item(i);
            System.out.println(child.getNodeName());
            if (child instanceof Element) {
                Element childElement = (Element) child;
                Text textNode = (Text) childElement.getFirstChild();
                String text = textNode.getData().trim();
                if (childElement.getTagName().equals("name")) {
                    var name = text;
                } else if (childElement.getTagName().equals("size")) {
                    var size = Integer.parseInt(text);
                }
            }
        }
    }

}
