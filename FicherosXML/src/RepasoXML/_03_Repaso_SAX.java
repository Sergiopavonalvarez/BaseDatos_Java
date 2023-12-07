package RepasoXML;

import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class _03_Repaso_SAX extends DefaultHandler {

	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("Inicio del documento XML");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		System.out.println("<" + localName + ">");
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String texto = new String(ch, start, length);
		texto = texto.replace("\n", "").trim();
		if (texto.length() > 0) {
			System.out.println("\t" + texto);
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		System.out.println("<" + localName + "/>");
	}

	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("Fin del documento");
	}

	public static void main(String[] args) throws SAXException, IOException {
		// Crear un lector XML (XMLReader) usando la fábrica
		XMLReader procXML = XMLReaderFactory.createXMLReader();

		// Crear una instancia del gestor (handler) que implementa DefaultHandler
		_03_Repaso_SAX gestor = new _03_Repaso_SAX();

		// Establecer el gestor como el manejador de contenido del lector XML
		procXML.setContentHandler(gestor);

		// Especificar el archivo XML de entrada mediante un InputSource
		InputSource fileXML = new InputSource("Ejercicio_01.xml");

		// Parsear el documento XML
		procXML.parse(fileXML);
	}
}
