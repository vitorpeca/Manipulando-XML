package meu.primeiro.pacote;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SendNote {
    public void send() throws IOException, SAXException, ParserConfigurationException {
        XmlReader xmlReader = new XmlReader();
        Document xmlNote = xmlReader.getXml("target/classes/myxml.xml");
        NodeList nList = xmlNote.getElementsByTagName("note");
        System.out.println("----------------------------");
        for (int index = 0; index < nList.getLength(); index++) {
            Node nNode = nList.item(index);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Id : " + (index + 1));
                System.out.println("DE.: " + eElement.getElementsByTagName("to").item(0).getTextContent());
                System.out.println("Para: " + eElement.getElementsByTagName("from").item(0).getTextContent());
                System.out.println("MSG: " + eElement.getElementsByTagName("body").item(0).getTextContent());
            }
        }
    }
}