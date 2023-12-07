
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XML_02_leerxml_Node {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = factory.newDocumentBuilder();
        Document document = db.parse(new File("Ejercicio_01.xml"));

        Node raiz = document.getFirstChild();

        raiz.getNodeName();
        NodeList nodos = raiz.getChildNodes();

        for (int i = 0; i < nodos.getLength(); i++) {
            Node nodo = nodos.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element persona = (Element) nodo;
                NodeList nameList = persona.getChildNodes();
                String nombre = null;
                String serieFavorita = null;
                for (int x = 0; x < nameList.getLength(); x++) {
                    Node n = nameList.item(x);
                    if (n.getNodeType() == Node.ELEMENT_NODE) {
                        Element name = (Element) n;
                        if (name.getNodeName().equals("Nombre")) {
                            nombre = name.getTextContent();
                        } else if (name.getNodeName().equals("Serie_favorita")) {
                            serieFavorita = name.getTextContent();
                        }
                    }
                }
                if (nombre != null && serieFavorita != null) {
                    System.out.println("Persona: " + nombre + ", Serie Favorita: " + serieFavorita);
                }
            }
        }
    }
}
