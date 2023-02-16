package parser;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class FoundBugsInTests {

    Assertion assertion = new Assertion();

    @Test(groups = "testsWithBugs", description = "This programme don't support comments")
    public void getValidXMLWithCommentTest() {
        XMLParser parser = new XMLParser("src/test/resources/errorCommentXML.xml");
        parser.parseDocument();
        assertion.assertTrue(parser.getErrors().isEmpty());
    }
}