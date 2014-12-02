package shdev.oukongli.maven.xml.test;

import shdev.oukongli.maven.xmlParse.DOMParser;
import shdev.oukongli.maven.xmlParse.DOMParserCommon;

/**
 * Created by kouyang on 12/2/2014.
 * 测试Parse
 */
public class TestXMLParse {
    public static void main(String[] args) {
        DOMParser domParser = new DOMParser("xmlfile.xml");
        domParser.executeParse();

        DOMParserCommon domParserCommon = new DOMParserCommon("xmlfile.xml");
        domParserCommon.excuteParse();
    }
}
