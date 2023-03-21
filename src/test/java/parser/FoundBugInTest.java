package parser;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class FoundBugInTest {

    Assertion assertion = new Assertion();

    @Test(groups = "testsWithBugs")
    public void getValidXMLWithCommentTest() {
        XMLParser parser = new XMLParser("src/test/resources/errorCommentXML.xml");
        parser.parseDocument();
        assertion.assertTrue(parser.getErrors().isEmpty(), "This programme don't support comments");
    }
}