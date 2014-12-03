package shdev.oukongli.maven.xmlParse.xmlParseTool;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.IOException;
import java.util.List;

/**
 * Created by kouyang on 12/3/2014.
 */
public class JDomParser {

    private String filePath;

    public JDomParser(String filePath) {
        this.filePath = filePath;
    }

    public void executeParse(){
        SAXBuilder build = new SAXBuilder();

        try {
            Document document = build.build(filePath);
            Element rootElement = document.getRootElement();
            List books = rootElement.getChildren("book");

            for (int i = 0; i < books.size(); i++) {
                Element book = (Element)books.get(i);
                List bookInfo = book.getChildren();
                System.out.println("id="+book.getAttribute("id").getValue());
                for (int j = 0; j < bookInfo.size(); j++) {
                    System.out.println(((Element)bookInfo.get(j)).getName()+":"+((Element)bookInfo.get(j)).getValue());
                }
                System.out.println();
            }

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
