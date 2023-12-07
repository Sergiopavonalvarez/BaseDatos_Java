import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class _01_Ejercicio {

	public static void main(String[] args)
			throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation implementacion = builder.getDOMImplementation();
		Document document = implementacion.createDocument(null, "Paises", null);
		document.setXmlVersion("1.0");

		String[] paises = new String[] { "Belice", "El Salvador", "Guatemala", "Honduras", "Nicaragua", "Mexico",
				"Panama", "Costa Rica" };
		String[] presidente = new String[] { "Froyla Tzalam", "Nayib Bukele", "Alejandro Giamattei", "Xiomara Castro",
				"Daniel Ortega", "Andres Manuel Lopez Obrador", "Laurentino Cortizo", "Rodrigo Chaves" };
		String[] PIB = new String[] { "1987", "74818", "185473", "85625", "47770", "2890685", "128500", "129950" };
		String[] coeficiente = new String[] { "53.3", "38.8", "48.3", "48.3", "46.2", "45.4", "50.9", "47.2" };

		for (int i = 0; i < paises.length; i++) {

			Element elemento = document.createElement("Pais");
			document.getDocumentElement().appendChild(elemento);

			Element elemFinalnombre = document.createElement("Nombre");
			Text textnombre = document.createTextNode(paises[i]);
			elemento.appendChild(elemFinalnombre);
			elemFinalnombre.appendChild(textnombre);

			Element elemFinalpresidente = document.createElement("Presidente");
			Text textpresidente = document.createTextNode(presidente[i]);
			elemento.appendChild(elemFinalpresidente);
			elemFinalpresidente.appendChild(textpresidente);

			Element elemFinalpib = document.createElement("PIB");
			Text textpib = document.createTextNode(PIB[i]);
			elemento.appendChild(elemFinalpib);
			elemFinalpib.appendChild(textpib);

			Element elemFinalcoeficiente = document.createElement("Coeficiente_Gini");
			Text textcoeficiente = document.createTextNode(coeficiente[i]);
			elemento.appendChild(elemFinalcoeficiente);
			elemFinalcoeficiente.appendChild(textcoeficiente);

		}
		Source source = new DOMSource(document);
		Result result = new StreamResult(new File("Paises.xml"));
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "XML");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		transformer.transform(source, result);

	}

}
