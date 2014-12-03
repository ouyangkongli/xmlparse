package shdev.oukongli.maven.xmlParse.xmlParseTool;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

/**
 * Created by kouyang on 12/3/2014.
 */
public class DOM4JParser {
    private String filePath;

    public DOM4JParser(String filePath) {
        this.filePath = filePath;
    }

    public void executeDOM4JParse(){
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(filePath);
            Element books = document.getRootElement();

            for (Iterator i = books.elementIterator();i.hasNext();)
            {
                Element book = (Element)i.next();
                System.out.println("id=" + book.attribute("id").getValue());
                for (Iterator j = book.elementIterator(); j.hasNext();){
                    Element bookInfo = (Element) j.next();
                    System.out.println(bookInfo.getName() + ":" +bookInfo.getText());
                }
                System.out.println();
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
