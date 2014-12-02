package shdev.oukongli.maven.xmlParse.xmlParseTool;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by kouyang on 12/2/2014.
 * 通用XML解析
 */
public class DOMParserCommon {
    String filePath = null;

    public DOMParserCommon(String filePath) {
        this.filePath = filePath;
    }

    private Document parseToTree() {
        //获得DOM解析工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            //获得DOM解析器
            DocumentBuilder builder = factory.newDocumentBuilder();
            //把
            document = builder.parse(new File(filePath));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return document;
    }

    public void excuteParse()
    {
        //把XML文档解析成tree
        Document document = parseToTree();
        //获取tree根节点
        Element rootElement = document.getDocumentElement();
        //解析树
        parseTree(rootElement);
    }

    private void parseTree(Element element) {
        //getNodeName()是从Node接口中继承的方法、getTagName()是从Element接口中继承的方法，对于element节点，两者返回的都是element节点对应的xml文件中标记的名称
//      String tagName = element.getNodeName();
        String tagName = element.getTagName();

        //得到当前标签的所有属性值
        System.out.print("<" + tagName);
        NamedNodeMap map = element.getAttributes();
        if (map != null) {
            for (int i = 0; i < map.getLength(); i++) {
                Attr attr = (Attr) map.item(i);
                String attrName = attr.getName();
                String attrValue = attr.getValue();
                System.out.print(" " + attrName + "=\"" + attrValue + "\"");
            }
        }
        System.out.print(">");

        //分析子节点
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            switch (node.getNodeType()) {
                //元素节点，进行递归
                case Node.ELEMENT_NODE:
                    parseTree((Element) node);
                    break;
                //文本节点,打印值
                case Node.TEXT_NODE:
//                    if (!node.getNodeValue().trim().equals(""))
                        System.out.print(node.getNodeValue());
                    break;
                //注释,打印
                case Node.COMMENT_NODE:
                    Comment comment = (Comment) node;
                    System.out.print("<!--" + comment.getData() + "-->");
                    break;
            }
        }
        System.out.print("</" + tagName + ">");
    }
}
