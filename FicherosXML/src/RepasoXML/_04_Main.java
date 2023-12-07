package RepasoXML;
import java.io.FileInputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;



public class _04_Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		XStream x = new XStream();

		x.addPermission(NoTypePermission.NONE);
		x.addPermission(NullPermission.NULL);
		x.addPermission(PrimitiveTypePermission.PRIMITIVES);

		Class[] clases = { _04_Ejercicio_Pais.class, _04_Ejercicio_ListaPaises.class };
		x.allowTypes(clases);
		x.allowTypesByWildcard(new String[] { "com.your.package.*" });

		x.alias("Paises", _04_Ejercicio_ListaPaises.class);
		x.alias("Pais", _04_Ejercicio_Pais.class);

		x.addImplicitCollection(_04_Ejercicio_ListaPaises.class, "Pais");
		FileInputStream fis = new FileInputStream("Paises.xml");
		_04_Ejercicio_ListaPaises listaObj = (_04_Ejercicio_ListaPaises) x.fromXML(fis);

		for (_04_Ejercicio_Pais pais : listaObj.getPais()) {

			System.out.println("Nombre: " + pais.getNombre());
			System.out.println("Presidente: " + pais.getPresidente());
			System.out.println("PIB: " + pais.getPib());
			System.out.println("Coeficiente Gini: " + pais.getCoeficiente());
			System.out.println("----------------------");
		}
	}
}