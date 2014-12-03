package shdev.oukongli.maven.xmlparse.test;

import shdev.oukongli.maven.xmlParse.xmlParseTool.*;

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
//        test.testSaxHandler();
//        test.testJDomParser();
        test.testDOM4JParser();
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

    public void testJDomParser(){
        JDomParser jDomParser = new JDomParser(xmlFilePath);
        jDomParser.executeParse();
    }

    public void testDOM4JParser(){
        DOM4JParser dom4JParser = new DOM4JParser(xmlFilePath);
        dom4JParser.executeDOM4JParse();
    }

}
