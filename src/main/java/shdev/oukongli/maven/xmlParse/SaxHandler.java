package shdev.oukongli.maven.xmlParse;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import shdev.oukongli.maven.model.Book;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kouyang on 12/2/2014.
 */
public class SaxHandler extends DefaultHandler{

    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始解析文档......");
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析完成......");
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("book"))
        {
            book = new Book();
            book.setId(attributes.getValue("id"));
        }
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book"))
        {
            books.add(book);
        }else if (qName.equals("title"))
        {
            book.setTitle(content);
        }else if (qName.equals("author"))
        {
            book.setAuthor(content);
        }
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        content = new String(ch, start, length);
    }

    private ArrayList<Book> books = new ArrayList<Book>();
    private Book book;

    private String content;
    private String xmlFilePath;

    public SaxHandler(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
    }

    public void executeParse()
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        File f = new File(xmlFilePath);
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(f, this);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        printBooks();
    }

    public void printBooks()
    {
        if (books != null)
        {
            System.out.println("开始输出解析内容:");
            for (Book book : books)
            {
                System.out.println("bookid=" + book.getId());
                System.out.println("title" + book.getTitle());
                System.out.println("author" + book.getAuthor());
            }
        }
    }

}
