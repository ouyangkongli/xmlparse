package shdev.oukongli.maven.xmlParse;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by kouyang on 12/2/2014.
 */
public class SaxHandlerCommon extends DefaultHandler{
    @Override
    public void startDocument() throws SAXException {
        System.out.println("...开始解析文档...");
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\n...文档解析完成...");
        super.endDocument();
    }

    /* uri是名称空间
    localName是包含名称空间的标签，如果没有名称空间，则为空
    qName是不包含名称空间的标签
    attributes是属性集合*/
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.print("开始解析标签" + qName);
//        System.out.print("开始解析标签");
        System.out.print("<");
        System.out.print(qName);
        if (attributes == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.print(attributes.getQName(i) + "=\"" + attributes.getValue(i) + "\"");
            }
        }
        System.out.print(">");
        super.startElement(uri, localName, qName, attributes);
    }

    /* uri是名称空间
       localName是包含名称空间的标签，如果没有名称空间，则为空
       qName是不包含名称空间的标签 */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.print("解析标签完成");
        System.out.print("</");
        System.out.print(qName);
        System.out.print(">");
        super.endElement(uri, localName, qName);
    }

    /*ch表示传回来的字符数组*/
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        System.out.print(content);
        super.characters(ch, start, length);
    }

    private String xmlFilePath;

    public SaxHandlerCommon(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
    }

    public void executeSaxParse()
    {
        //实例化SAXParserFactory对象
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //创建解析器
        try {
            SAXParser parser = factory.newSAXParser();
            File f = new File(xmlFilePath);
            parser.parse(f, this);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
