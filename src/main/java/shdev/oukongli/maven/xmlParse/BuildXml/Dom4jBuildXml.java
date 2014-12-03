package shdev.oukongli.maven.xmlParse.BuildXml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by kouyang on 12/3/2014.
 */
public class Dom4jBuildXml {
    public void build()
    {
        Document document = DocumentHelper.createDocument();

        Element rootElement = document.addElement("books");
        rootElement.setText("小说");

        Element book = rootElement.addElement("book");
        book.addAttribute("id","001");
        Element name = book.addElement("name");
        Element author = book.addElement("author");
        name.addAttribute("language","中文");
        name.setText("射雕英雄传");
        author.setText("金庸");

        System.out.println(document.asXML());

        try {
            String path = System.getProperty("user.dir") + "\\src\\main\\resources\\";
            Writer fileWrite = new FileWriter(path + "BuildXMLResult.xml");
            XMLWriter xmlWriter = new XMLWriter(fileWrite);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Dom4jBuildXml tmp = new Dom4jBuildXml();
        tmp.build();
    }


}
