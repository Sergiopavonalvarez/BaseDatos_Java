import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class _03_Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		XStream x = new XStream();

		x.addPermission(NoTypePermission.NONE);
		x.addPermission(NullPermission.NULL);
		x.addPermission(PrimitiveTypePermission.PRIMITIVES);

		Class[] clases = { _02_Ejercicio_Pais.class, _02_Ejercicio_ListaPaises.class };
		x.allowTypes(clases);
		x.allowTypesByWildcard(new String[] { "com.your.package.*" });

		x.alias("Paises", _02_Ejercicio_ListaPaises.class);
		x.alias("Pais", _02_Ejercicio_Pais.class);

		x.addImplicitCollection(_02_Ejercicio_ListaPaises.class, "Pais");
		FileInputStream fis = new FileInputStream("Paises.xml");
		_02_Ejercicio_ListaPaises listaObj = (_02_Ejercicio_ListaPaises) x.fromXML(fis);

		for (_02_Ejercicio_Pais pais : listaObj.getPais()) {

			System.out.println("Nombre: " + pais.getNombre());
			System.out.println("Presidente: " + pais.getPresidente());
			System.out.println("PIB: " + pais.getPib());
			System.out.println("Coeficiente Gini: " + pais.getCoeficiente());
			System.out.println("----------------------");
		}
	}
}