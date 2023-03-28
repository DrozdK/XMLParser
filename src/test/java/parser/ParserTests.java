package parser;

import Helpers.TextHelper;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import utilities.Iterator;

import java.lang.reflect.Field;

import static org.testng.Assert.assertEquals;

public class ParserTests {

    Assertion assertion = new Assertion();

    @Test(groups = "parserValidationTests")
    public void getXMLErrorsTest() {
        XMLParser parser = new XMLParser("src/test/resources/errorUnexpectedTag.xml");
        String expected = TextHelper.UNEXPECTED_TAG_TEXT.getTextHelper();
        parser.parseDocument();
        Iterator<String> errorsIter = parser.getErrors().iterator();
        String actual = errorsIter.next();
        assertion.assertEquals(actual, expected);
    }

    @Test(groups = "parserValidationTests")
    public void getValidXMLTest() {
        XMLParser parser = new XMLParser("src/test/resources/validXML.xml");
        parser.parseDocument();
        assertion.assertTrue(parser.getErrors().isEmpty());
    }

    @Test(groups = "parserValidationTests")
    public void checkValidationRootTagTest() {
        XMLParser parser = new XMLParser("src/test/resources/errorRootTag.xml");
        String expected = TextHelper.START_WITH_ROOT_TAG_TEXT.getTextHelper();
        parser.parseDocument();
        Iterator<String> errorsIter = parser.getErrors().iterator();
        String actual = errorsIter.next();
        assertion.assertEquals(actual, expected);
    }

    @Test(groups = "parserValidationTests")
    public void checkValidationCloseRootTagTest() {
        XMLParser parser = new XMLParser("src/test/resources/errorCloseRootTag.xml");
        String expected = TextHelper.CLOSE_ROOT_TAG_TEXT.getTextHelper();
        parser.parseDocument();
        Iterator<String> errorsIter = parser.getErrors().iterator();
        String actual = errorsIter.next();
        assertion.assertEquals(actual, expected);
    }

    @Test(groups = "parserValidationTests")
    public void checkValidationDataInRootTagTest() {
        XMLParser parser = new XMLParser("src/test/resources/errorDataInRootTag.xml");
        String expected = TextHelper.ALL_DATA_IN_ROOT_TAG_TEXT.getTextHelper();
        parser.parseDocument();
        Iterator<String> errorsIter = parser.getErrors().iterator();
        String actual = errorsIter.next();
        assertion.assertEquals(actual, expected);
    }

    @Test(groups = "parserValidationTests")
    public void checkValidationFormatTagTest() {
        XMLParser parser = new XMLParser("src/test/resources/errorFormatTag.xml");
        String expected = TextHelper.TAG_FORMAT_TEXT.getTextHelper();
        parser.parseDocument();
        Iterator<String> errorsIter = parser.getErrors().iterator();
        String actual = errorsIter.next();
        assertion.assertEquals(actual, expected);
    }

    @Test(groups = "parserValidationTests")
    public void checkValidationCloseTagTest() {
        XMLParser parser = new XMLParser("src/test/resources/errorCloseTag.xml");
        String expected = TextHelper.CLOSE_TAG_TEXT.getTextHelper();
        parser.parseDocument();
        Iterator<String> errorsIter = parser.getErrors().iterator();
        String actual = errorsIter.next();
        assertion.assertEquals(actual, expected);
    }

    @Test(groups = "functionalParserTests")
    public void testGetNameFromRoot(){
        XMLParser parser = new XMLParser("src/test/resources/validXML.xml");
        parser.parseDocument();
        String xmlTageName;
        try {
            Field field = parser.getClass().getDeclaredField("root");
            field.setAccessible(true);
            XMLTag xmlTag = (XMLTag) field.get(parser);
            xmlTageName = xmlTag.getName();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        assertEquals(xmlTageName, "contacts");
    }
}