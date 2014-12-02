package shdev.oukongli.maven.xmlparse.test;

import shdev.oukongli.maven.xmlParse.xmlParseTool.DOMParser;
import shdev.oukongli.maven.xmlParse.xmlParseTool.DOMParserCommon;
import shdev.oukongli.maven.xmlParse.xmlParseTool.SaxHandler;
import shdev.oukongli.maven.xmlParse.xmlParseTool.SaxHandlerCommon;

/**
 * Created by kouyang on 12/2/2014.
 * 测试Parse
 */
public class TestXMLParse {

    private String xmlFilePath = "src/main/resources/xmlfile.xml";

    public static void main(String[] args) {
        TestXMLParse test = new TestXMLParse();

//        test.testDomParser();
//        test.testDomParserCommon();
//        test.testSaxHandlerCommon();
        test.testSaxHandler();

    }

    public void testDomParser()
    {

        DOMParser domParser = new DOMParser(xmlFilePath);
        domParser.executeParse();
    }

    public void testDomParserCommon()
    {
        DOMParserCommon domParserCommon = new DOMParserCommon(xmlFilePath);
        domParserCommon.excuteParse();
    }

    public void testSaxHandlerCommon()
    {
        SaxHandlerCommon saxHandler = new SaxHandlerCommon(xmlFilePath);
        saxHandler.executeSaxParse();
    }

    public void testSaxHandler()
    {
        SaxHandler saxHandler = new SaxHandler(xmlFilePath);
        saxHandler.executeParse();
    }

}
