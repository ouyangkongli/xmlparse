package shdev.oukongli.maven.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by kouyang on 12/1/2014.
 */
public class DOMParser {
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

    //导入xml文件，并解析到DOM中
    public Document parse(String filePath) {
        Document document = null;
        filePath = this.getClass().getResource("/" + filePath).getFile();
        try {
            //DOM实例
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            //解析xml文件到DOM树中
            document = builder.parse(new File(filePath));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return document;
    }

    public static void main(String[] args) {
        DOMParser parser = new DOMParser();
        Document document = parser.parse("xmlfile.xml");


        //得到根节点
        Element rootElement = document.getDocumentElement();

        //遍历孩子节点
//        NodeList nodes = rootElement.getChildNodes();
//        for (int i = 0; i < nodes.getLength(); i++) {
//            Node node = nodes.item(i);
//            if (node.getNodeType() == Node.ELEMENT_NODE) {
//                Element child = (Element) node;
//            }
//        }

        NodeList nodeList = rootElement.getElementsByTagName("book");
        if (nodeList != null){
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    System.out.println(((Element)node).getAttribute("id"));

                    if (node.getChildNodes() != null) {
                        for (Node childNode = node.getFirstChild(); childNode != null; childNode = childNode.getNextSibling()) {
                            if (childNode.getNodeName().equals("title") || childNode.getNodeName().equals("author"))
                                System.out.println(childNode.getFirstChild().getNodeValue());
                        }
                    }
                }
            }
        }

//        NodeList nodeList = rootElement.getChildNodes();
//        if (nodeList != null) {
//            for (int i = 0; i < nodeList.getLength(); i++)
//            {
//                Node child = nodeList.item(i);
//                if (child.getNodeType() == Node.ELEMENT_NODE)
//                {
//                    System.out.println(child.getAttributes().getNamedItem("id").getNodeValue());
//                }
//                for (Node node = child.getFirstChild(); node != null; node = node.getNextSibling())
//                {
//                    if (node.getNodeName().equals("title"))
//                    {
//                        System.out.println(node.getFirstChild().getNodeValue());
//                    }
//                    if (node.getNodeName().equals("author"))
//                    {
//                        System.out.println(node.getFirstChild().getNodeValue());
//                    }
//                }
//            }
//        }

    }

}
