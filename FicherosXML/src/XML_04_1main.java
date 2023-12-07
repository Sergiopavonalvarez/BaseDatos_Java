
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission; 
//import org.kxml2.*;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class XML_04_1main {

	private List<XML_04_alumnos> lista = new ArrayList<XML_04_alumnos>();

	public void añadirpersonas(XML_04_alumnos alum) {
		lista.add(alum);
	}

	public XML_04_1main() {

	}

	public List<XML_04_alumnos> getLista() {
		return lista;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		XML_04_listalumnos alum=new XML_04_listalumnos();
		
		
		alum.add(new XML_04_alumnos("Sergio Pavon",(byte)35,(byte)7,(float)1.72,true,0,"The Last of Us"));
		alum.add(new XML_04_alumnos("Miguel Pavon",(byte)27,(byte)7,(float)1.72,true,0,"Fifa"));
		alum.add(new XML_04_alumnos("Dante Gennari",(byte)36,(byte)8,(float)1.87,true,0,"Fifa"));
		alum.add(new XML_04_alumnos("Pablo Navarro",(byte)28,(byte)9,(float)1.86,true,0,"Total War"));
		alum.add(new XML_04_alumnos("Sergio Rubio",(byte)23,(byte)9,(float)1.93,true,0,"The Last of Us"));
		
		XStream xstream = new XStream();
		xstream.alias("ListaObjetos", XML_04_listalumnos.class);
		xstream.alias("Alumno", XML_04_alumnos.class);
		xstream.addImplicitCollection(XML_04_listalumnos.class, "lista");
		xstream.toXML(alum, new FileOutputStream("Fila3.xml"));
		
		

		
		
	}

	
	

}
