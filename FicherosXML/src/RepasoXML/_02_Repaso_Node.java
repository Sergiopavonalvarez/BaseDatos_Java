package RepasoXML;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class _02_Repaso_Node {
	public static void main(String[] args) throws Exception {
		// Crear una fábrica de constructores de documentos
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// Obtener un constructor de documentos a partir de la fábrica
		DocumentBuilder db = factory.newDocumentBuilder();

		// Parsear el archivo XML y obtener un documento
		Document document = db.parse(new File("Ejercicio_01.xml"));

		// Obtener el nodo raíz del documento
		Node raiz = document.getFirstChild();

		// Ignorar el resultado de getNodeName() ya que no se está utilizando

		// Obtener la lista de nodos hijos del nodo raíz
		NodeList nodos = raiz.getChildNodes();

		// Iterar sobre los nodos hijos
		for (int i = 0; i < nodos.getLength(); i++) {
			Node nodo = nodos.item(i);

			// Verificar si el nodo es de tipo ELEMENT_NODE (elemento XML)
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				// Convertir el nodo a un elemento (Element)
				Element persona = (Element) nodo;

				// Obtener la lista de nodos hijos del elemento "Persona"
				NodeList nameList = persona.getChildNodes();

				// Variables para almacenar información de la persona
				String nombre = null;
				String serieFavorita = null;

				// Iterar sobre los nodos hijos de "Persona"
				for (int x = 0; x < nameList.getLength(); x++) {
					Node n = nameList.item(x);

					// Verificar si el nodo hijo es de tipo ELEMENT_NODE
					if (n.getNodeType() == Node.ELEMENT_NODE) {
						// Convertir el nodo hijo a un elemento (Element)
						Element name = (Element) n;

						// Obtener el nombre y la serie favorita
						if (name.getNodeName().equals("Nombre")) {
							nombre = name.getTextContent();
						} else if (name.getNodeName().equals("Serie_favorita")) {
							serieFavorita = name.getTextContent();
						}
					}
				}

				// Imprimir la información de la persona si se han encontrado nombre y serie
				// favorita
				if (nombre != null && serieFavorita != null) {
					System.out.println("Persona: " + nombre + ", Serie Favorita: " + serieFavorita);
				}
			}
		}
	}
}
