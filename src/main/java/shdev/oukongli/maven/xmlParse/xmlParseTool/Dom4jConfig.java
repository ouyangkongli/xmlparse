package shdev.oukongli.maven.xmlParse.xmlParseTool;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


import shdev.oukongli.maven.xmlParse.CustomException.FileNotFoundException;
import shdev.oukongli.maven.xmlParse.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kouyang on 12/3/2014.
 */
public class Dom4jConfig
{
    private Document doc;
    private String title;
    private String author;
    private static Dom4jConfig instance;
    private String configFile;
    private List<Book> books;


    public static Dom4jConfig getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new Dom4jConfig();
            return instance;
        }
    }

    private Dom4jConfig() {
        String filePath = this.getClass().getResource("/xmlfile.xml").getFile();
        this.configFile = filePath;
        try {
            SAXReader saxReader = new SAXReader();
            doc = saxReader.read(this.configFile);
        } catch (DocumentException docEx) {
            try {
                throw new FileNotFoundException("xmlfile.xml is missing");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        init();
    }

    private void init(){
        initBooks();
    }

    private void initBooks() {
        books = new ArrayList<Book>();
        List<Node> bookNodes = doc.selectNodes("/books/book");
        for (Node bookNode : bookNodes) {
            Book book = new Book();
            book.setId(bookNode.selectSingleNode("./@id").getText());
            book.setTitle(bookNode.selectSingleNode("./title").getText());
            book.setAuthor(bookNode.selectSingleNode("./author").getStringValue());
            books.add(book);
        }
    }

    public List<Book> getBooks(){
        return books;
    }

    public static void main(String[] args) {
        Dom4jConfig.getInstance();
    }

}