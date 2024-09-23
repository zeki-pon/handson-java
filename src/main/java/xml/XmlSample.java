package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class XmlSample {

    /**
     * @param xmlString: xml形式の文字列
     * @return Document Object
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public Document convertStringXMLFragmentToDocumentNode(String xmlString)
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new InputSource(new StringReader(xmlString)));
    }

    /**
     * @param existingDocument: 既存のドキュメントオブジェクト
     * @param addNode: 追加したいノード
     * @return Document Object
     */
    public Document insertDocumentNodeIntoExistingDocument(Document existingDocument, Element addNode) {
        Element newNode = (Element) existingDocument.importNode(addNode, true);
        existingDocument.getDocumentElement().appendChild(newNode);
        return existingDocument; // TODO: 引数のオブジェクトを変更しているのでよくないきがする
    }
}
