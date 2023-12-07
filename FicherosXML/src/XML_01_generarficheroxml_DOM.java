
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

public class XML_01_generarficheroxml_DOM {

	public static void main(String[] args)
			throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation implementacion = builder.getDOMImplementation();
		// Crear un documento vacio indicanco el nombre del nodo raiz:(primer parametro
		// null indica el espacio de los nombres, el tercer parametro es el doctype
		Document document = implementacion.createDocument(null, "PersonasSeries", null);
		// asignar la verison:
		document.setXmlVersion("1.0");

		// *******************
		// creamos elemento y añadimos al nodo raiz

		Element elemento2 = document.createElement("Persona");
		document.getDocumentElement().appendChild(elemento2);

		// creamos elementos finales y añadimos al elemento que corresponda

		Element elemFinal = document.createElement("Nombre");
		Text text = document.createTextNode("Dante");
		elemento2.appendChild(elemFinal);
		elemFinal.appendChild(text);

		Element elemFinal2 = document.createElement("Serie_favorita");
		Text text1 = document.createTextNode("South Park");
		elemento2.appendChild(elemFinal2);
		elemFinal2.appendChild(text1);

		// *******************

		Element elemento3 = document.createElement("Persona");
		document.getDocumentElement().appendChild(elemento3);

		Element elemFinalmiguel = document.createElement("Nombre");
		Text textmiguel = document.createTextNode("Miguel");
		elemento3.appendChild(elemFinalmiguel);
		elemFinalmiguel.appendChild(textmiguel);

		Element elemFinal2miguel = document.createElement("Serie_favorita");
		Text text1miguel = document.createTextNode("Gran Hemrano");
		elemento3.appendChild(elemFinal2miguel);
		elemFinal2miguel.appendChild(text1miguel);

		// ************************

		Element elemento4 = document.createElement("Persona");
		document.getDocumentElement().appendChild(elemento4);

		Element elemFinalpablo = document.createElement("Nombre");
		Text textpablo = document.createTextNode("Pablo");
		elemento4.appendChild(elemFinalpablo);
		elemFinalpablo.appendChild(textpablo);

		Element elemFinal2pablo = document.createElement("Serie_favorita");
		Text text1pablo = document.createTextNode("Juego de tronos");
		elemento4.appendChild(elemFinal2pablo);
		elemFinal2pablo.appendChild(text1pablo);

		// ****************************

		Element elemento5 = document.createElement("Persona");
		document.getDocumentElement().appendChild(elemento5);

		Element elemFinalsergio = document.createElement("Nombre");
		Text textsergio = document.createTextNode("Sergio");
		elemento5.appendChild(elemFinalsergio);
		elemFinalsergio.appendChild(textsergio);

		Element elemFinal2sergio = document.createElement("Serie_favorita");
		Text text1sergio = document.createTextNode("Gran Hemrano vip");
		elemento5.appendChild(elemFinal2sergio);
		elemFinal2sergio.appendChild(text1sergio);

		// ****************************

		Element elemento6 = document.createElement("Persona");
		document.getDocumentElement().appendChild(elemento6);

		Element elemFinaljhair = document.createElement("Nombre");
		Text textjhair = document.createTextNode("Jhair");
		elemento6.appendChild(elemFinaljhair);
		elemFinaljhair.appendChild(textjhair);

		Element elemFinajhair = document.createElement("Serie_favorita");
		Text text1jhair = document.createTextNode("Gran Hemrano vip");
		elemento6.appendChild(elemFinajhair);
		elemFinajhair.appendChild(text1jhair);

		// lo mismo con dos arrays y un bucle:
		//
		// String[] nombres = new String[]
		// {"Pablo","Sergio.R","Jhair","Dante","Sergio.P","Miguel"};
		// String[] series = new String[] {"El mentalista", "Game of thrones", "Suits",
		// "Game of thrones", "Gran Hermano", "South park"};
		//
		// for (int i = 0; i < series.length; i++) {
		// Element ele1 = doc.createElement("persona");
		// doc.getDocumentElement().appendChild(ele1);
		//
		// Element ele_1_1 = doc.createElement("nombre");
		// Text text = doc.createTextNode(nombres[i]);
		// ele1.appendChild(ele_1_1);
		// ele_1_1.appendChild(text);
		//
		// Element ele_1_2 = doc.createElement("serie_favorita");
		// Text text2 = doc.createTextNode(series[i]);
		// ele1.appendChild(ele_1_2);
		// ele_1_2.appendChild(text2);

		// **************************************************

		// una vez generado la estructura creamos la fuente xml a partir del documento
		Source source = new DOMSource(document);
		// Creamos el resultado en el fichero xml
		Result result = new StreamResult(new File("Ejercicio_01.xml"));
		// Obtenemos un transformerFactory
		Transformer transformer = TransformerFactory.newInstance().newTransformer();

		// le damos formato y realizamos la transformacion del docuemtno a fichero
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "XML");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		transformer.transform(source, result);

		// mostramos el documento por pantalla

		Result console = new StreamResult(System.out);
		transformer.transform(source, console);

	}

}
