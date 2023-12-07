import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _05_DAO_Main {

	public static void main(String[] args) throws SQLException, IOException {

		_05_DAO_Paises j = new _05_DAO_Paises();

		// j.crearBaseDatos();
		j.rellenarBaseDatos();
		System.out.println();
		System.out.println("---------------------------------PAISES------------------------------------");
		System.out.println();
		j.imprimirBasesDAtos();
		// j.busquedaPais();

		System.out.println();
		System.out.println("----------------------------MODIFICACION PIB-------------------------------");
		System.out.println();

		String[] paises = new String[] { "Belice", "El Salvador", "Guatemala", "Honduras", "Nicaragua", "Mexico",
				"Panama", "Costa Rica" };

		for (int i = 0; i < paises.length; i++) {
			j.modificarPIB(+10, paises[i]);

		}

		j.imprimirBasesDAtos();

		System.out.println();
		System.out.println("------------------------MODIFICACION COEFICIENTE GINI----------------------");
		System.out.println();
		
		j.modificarPais("Japon", "Belice");

		j.modificarCoeficiente_Gini("25.87", "El Salvador");
		j.modificarCoeficiente_Gini("32.20", "Honduras");
		j.modificarCoeficiente_Gini("30.27", "Mexico");
		

		j.imprimirBasesDAtos();

		j.limpiarTabla();

	}

}
