
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class XML_03_leerxml_SAX extends DefaultHandler {

	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("Inicio del documento XML");
	}

	public void startElement(String url, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(url, localName, qName, attributes);
		System.out.println("<" + localName + ">");

	}

	public void characters(char[] ch, int start, int lenght) throws SAXException {
		super.characters(ch, start, lenght);
		String texto = new String(ch, start, lenght);
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
		System.out.println("fin del documento");
	}

	public static void main(String[] args) throws SAXException, IOException {

		XMLReader procXML = XMLReaderFactory.createXMLReader();
		XML_03_leerxml_SAX gestor = new XML_03_leerxml_SAX();
		procXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource("Ejercicio_01.xml");
		procXML.parse(fileXML);

	}

}
