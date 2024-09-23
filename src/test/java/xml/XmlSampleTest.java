package xml;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class XmlSampleTest {

    private XmlSample xmlSample;
    private DocumentBuilder builder;

    @BeforeEach
    void setUp() throws Exception {
        xmlSample = new XmlSample();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testConvertStringXMLFragmentToDocumentNode() throws Exception {
        // given
        String xmlString = "<root><child>Example</child></root>";

        // when
        Document document = xmlSample.convertStringXMLFragmentToDocumentNode(xmlString);

        // then
        // root element
        Element rootElement = document.getDocumentElement();
        assertNotNull(document);
        assertEquals("root", rootElement.getNodeName());
        // child element
        var childElement = rootElement.getElementsByTagName("child");
        assertNotNull(childElement);
        assertEquals(1, childElement.getLength());
        assertEquals("Example", childElement.item(0).getTextContent());
    }

    @Test
    void testInvalidXmlString() {
        // given
        String invalidXmlString = "<child>Example</child";

        // when, then
        assertThrows(SAXException.class, () -> {
            xmlSample.convertStringXMLFragmentToDocumentNode(invalidXmlString);
        });
    }

    @Test
    void testInsertDocumentNodeIntoExistingDocument() throws Exception {
        // given
        Document existingDocument = builder.newDocument();
        Element rootElement = existingDocument.createElement("existingRoot");
        existingDocument.appendChild(rootElement);

        String xmlString = "<child>Example</child>";
        Document newDocument = builder.parse(new InputSource(new StringReader(xmlString)));
        Element addNode = newDocument.getDocumentElement();

        // when
        Document insertedDocument = xmlSample.insertDocumentNodeIntoExistingDocument(existingDocument, addNode);

        // then
        assertNotNull(insertedDocument);
        assertEquals(1, insertedDocument.getDocumentElement().getChildNodes().getLength());
        assertEquals("child", insertedDocument.getDocumentElement().getChildNodes().item(0).getNodeName());
        assertEquals("Example", insertedDocument.getDocumentElement().getChildNodes().item(0).getTextContent());
    }
}