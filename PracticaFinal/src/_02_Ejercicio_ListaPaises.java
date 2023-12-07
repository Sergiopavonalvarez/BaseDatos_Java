import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class _02_Ejercicio_ListaPaises {

	private ArrayList<_02_Ejercicio_Pais> Pais;

	public _02_Ejercicio_ListaPaises() {
		this.Pais = new ArrayList<_02_Ejercicio_Pais>();
	}

	public ArrayList<_02_Ejercicio_Pais> getPais() {
		return Pais;
	}

	public void setPais(ArrayList<_02_Ejercicio_Pais> pais) {
		this.Pais = pais;
	}

	public void addPais(_02_Ejercicio_Pais pais) {
		this.Pais.add(pais);
	}

	public String toString() {
		return "" + Pais;
	}

}
