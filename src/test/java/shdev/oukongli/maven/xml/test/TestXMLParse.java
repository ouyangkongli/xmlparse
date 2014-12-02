package shdev.oukongli.maven.xml.test;

import shdev.oukongli.maven.xmlParse.DOMParser;
import shdev.oukongli.maven.xmlParse.DOMParserCommon;

/**
 * Created by kouyang on 12/2/2014.
 * 测试Parse
 */
public class TestXMLParse {
    public static void main(String[] args) {
        TestXMLParse test = new TestXMLParse();
//        test.testDomParser();
//        test.testDomParserCommon();


    }

    public void testDomParser(){
        DOMParser domParser = new DOMParser("xmlfile.xml");
        domParser.executeParse();
    }

    public void testDomParserCommon() {
        DOMParserCommon domParserCommon = new DOMParserCommon("xmlfile.xml");
        domParserCommon.excuteParse();
    }

}
