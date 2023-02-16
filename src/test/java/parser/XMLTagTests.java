package parser;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ListADT;
import utilities.MyArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class XMLTagTests {

    SoftAssert softly = new SoftAssert();

    @Test(groups = "XMLTagTests")
    public void testXMLTagGetName() {
        XMLTag tag = new XMLTag("testName");
        assertEquals(tag.getName(), "testName");
    }

    @Test(groups = "XMLTagTests")
    public void testXMLTagSetName() {
        XMLTag tag = new XMLTag("testName");
        tag.setName("setTagName");
        assertEquals(tag.getName(), "setTagName");
    }

    @Test(groups = "XMLTagTests")
    public void testXMLTagPropertyConstructor() {
        XMLTag.TagProperty property = new XMLTag.TagProperty("testName", "testValue");
        softly.assertEquals(property.getName(), "testName");
        softly.assertEquals(property.getValue(), "testValue");
        softly.assertAll();
    }

    @Test(groups = "XMLTagTests")
    public void testXMLTagPropertySetName() {
        XMLTag.TagProperty property = new XMLTag.TagProperty("testName", "testValue");
        property.setName("newName");
        assertEquals(property.getName(), "newName");
    }

    @Test(groups = "XMLTagTests")
    public void testXMLTagPropertySetValue() {
        XMLTag.TagProperty property = new XMLTag.TagProperty("testName", "testValue");
        property.setValue("newValue");
        assertEquals(property.getValue(), "newValue");
    }

    @Test(groups = "XMLTagTests")
    public void testXMLTagGetEmptyMyArrayListAsProperties() {
        XMLTag tag = new XMLTag("tag");
        ListADT<XMLTag.TagProperty> properties = tag.getProperties();
        assertTrue(properties.isEmpty());
    }

    @Test(groups = "XMLTagTests")
    public void testXMLTagSetAndGetProperties() {
        XMLTag.TagProperty property1 = new XMLTag.TagProperty("testName", "testValue");
        XMLTag.TagProperty property2 = new XMLTag.TagProperty("testName", "testValue");
        ListADT<XMLTag.TagProperty> propertyListADT = new MyArrayList<>();
        propertyListADT.add(property1);
        propertyListADT.add(property2);
        XMLTag tag = new XMLTag("tag");
        tag.setProperties(propertyListADT);
        assertEquals(tag.getProperties(), propertyListADT);
    }

    @Test(groups = "XMLTagTests")
    public void testXMLTagGetEmptyMyArrayListAsNestedTags() {
        XMLTag tag = new XMLTag("tag");
        ListADT<XMLTag> nestedTags = tag.getNestedTags();
        assertTrue(nestedTags.isEmpty());
    }

    @Test(groups = "XMLTagTests")
    public void testXMLTagSetNestedTags() {
        XMLTag tag = new XMLTag("tag");
        ListADT<XMLTag> nestedTags = new MyArrayList<>();
        nestedTags.add(new XMLTag("test"));
        nestedTags.add(new XMLTag("alsoTest"));
        tag.setNestedTags(nestedTags);
        assertEquals(tag.getNestedTags(), nestedTags);
    }

    @Test(groups = "XMLTagTests")
    public void testXMLTagGetText(){
        XMLTag tag = new XMLTag("tag");
        assertNull(tag.getText());
    }

    @Test(groups = "XMLTagTests")
    public void testXMLTagSetText(){
        XMLTag tag = new XMLTag("tag");
        tag.setText("text");
        assertEquals(tag.getText(), "text");
    }
}