
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class XML_04_2main {

	public static void main(String[] args) throws FileNotFoundException {

		XStream xs = new XStream();

		xs.addPermission(NoTypePermission.NONE);
		xs.addPermission(NullPermission.NULL);
		xs.addPermission(PrimitiveTypePermission.PRIMITIVES);

		Class[] clases = { XML_04_listalumnos.class, XML_04_alumnos.class };
		xs.allowTypes(clases);
		xs.allowTypesByWildcard(new String[] { "com.your.package.*" });
		
		
		xs.alias("ListaObjetos", XML_04_listalumnos.class);
		xs.alias("ListaAlumnos", XML_04_listalumnos.class);
		xs.alias("Alumno", XML_04_alumnos.class);

		xs.addImplicitCollection(XML_04_listalumnos.class, "lista");

		XML_04_listalumnos ls = new XML_04_listalumnos();
		XML_04_listalumnos XML_04_listalumnos;

		for (int i = 1; i < 5; i++) {

			FileInputStream fis = new FileInputStream("Fila" + i + ".xml");
			XML_04_listalumnos = (XML_04_listalumnos) xs.fromXML(fis);

			for (Object alumno : XML_04_listalumnos.getListaAlumnos()) {
				ls.add(alumno);

			}
			xs.toXML(ls, new FileOutputStream("Alumnos.xml"));

		}

	}

}
