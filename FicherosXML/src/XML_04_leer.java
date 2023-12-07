
import javax.xml.parsers.*;
import java.io.*;
import org.w3c.dom.*;

public class XML_04_leer {
	public static void main(String[] args) {
		try {
			// Crear un DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Cargar el archivo XML
			Document document = builder.parse(new File("Alumnos.xml"));

			// Imprimir el documento XML en la consola
			printXML(document.getDocumentElement(), "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Método para imprimir el documento XML recursivamente
	private static void printXML(Node node, String indent) {
		System.out.print(indent + "<" + node.getNodeName());

		NamedNodeMap attributes = node.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++) {
			Node attribute = attributes.item(i);
			System.out.print(" " + attribute.getNodeName() + "=\"" + attribute.getNodeValue() + "\"");
		}

		System.out.print(">");

		if (node.hasChildNodes()) {
			NodeList children = node.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node child = children.item(i);

				if (child.getNodeType() == Node.ELEMENT_NODE) {
					System.out.println();
					printXML(child, indent + "  ");
				} else if (child.getNodeType() == Node.TEXT_NODE) {
					System.out.print(child.getNodeValue());
				}
			}
		}

		System.out.print("</" + node.getNodeName() + ">");
	}
}
