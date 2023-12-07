import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class _05_DAO_Paises {

	public void crearBaseDatos() throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Paises;create=true");
		String q1 = "CREATE TABLE TABLAPAISES (PAIS VARCHAR (90), PRESIDENTE VARCHAR (80)PRIMARY KEY, PIB INT, COEFICIENTE_GINI VARCHAR (20))";
		PreparedStatement sentencia = con.prepareStatement(q1);
		sentencia.execute();
		con.close();

	}

	public void rellenarBaseDatos() throws SQLException, IOException {

		XStream x = new XStream();

		x.addPermission(NoTypePermission.NONE);
		x.addPermission(NullPermission.NULL);
		x.addPermission(PrimitiveTypePermission.PRIMITIVES);

		Class<?>[] clases = { _02_Ejercicio_Pais.class, _02_Ejercicio_ListaPaises.class };
		x.allowTypes(clases);
		x.allowTypesByWildcard(new String[] { "com.your.package.*" });

		x.alias("Paises", _02_Ejercicio_ListaPaises.class);
		x.alias("Pais", _02_Ejercicio_Pais.class);

		x.addImplicitCollection(_02_Ejercicio_ListaPaises.class, "Pais");
		FileInputStream fis = new FileInputStream("Paises.xml");
		_02_Ejercicio_ListaPaises listaObj = (_02_Ejercicio_ListaPaises) x.fromXML(fis);

		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Paises;create=true");
		String q2 = "INSERT INTO TABLAPAISES (PAIS, PRESIDENTE, PIB, COEFICIENTE_GINI) VALUES (?,?,?,?)";
		PreparedStatement sentencia = con.prepareStatement(q2);

		try {
			for (_02_Ejercicio_Pais pais : listaObj.getPais()) {
				sentencia.setString(1, pais.getNombre());
				sentencia.setString(2, pais.getPresidente());
				sentencia.setInt(3, pais.getPib());
				sentencia.setString(4, pais.getCoeficiente());
				sentencia.executeUpdate();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void imprimirBasesDAtos() throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Paises;create=true");
		String q3 = "SELECT * FROM TABLAPAISES";
		PreparedStatement sentencia = con.prepareStatement(q3);
		ResultSet result = (ResultSet) sentencia.executeQuery();
		System.out.printf("%-15s %-30s %-10s %-15s%n", "PAIS", "PRESIDENTE", "PIB", "COEFICIENTE_GINI");
		System.out.println("---------------------------------------------------------------------------");
		while (result.next()) {

			System.out.printf("%-15s %-30s %-11s %-15s%n", result.getString("PAIS"), result.getString("PRESIDENTE"),
					result.getString("PIB"), result.getString("COEFICIENTE_GINI"));
		}
		System.out.println("----------------------------------------------------------------------------");
		con.close();
	}

	public void busquedaPais() throws SQLException {
		System.out.println("Introduce el pais: ");
		Scanner sc = new Scanner(System.in);
		String pais = "";
		pais = sc.nextLine();
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Paises;create=true");
		PreparedStatement sentencia = con.prepareStatement("SELECT * FROM TABLAPAISES WHERE PAIS=?");
		sentencia.setString(1, pais);

		ResultSet result = sentencia.executeQuery();
		System.out.printf("%-15s %-30s %-10s %-15s%n", "PAIS", "PRESIDENTE", "PIB", "COEFICIENTE_GINI");
		System.out.println("---------------------------------------------------------------------------");
		while (result.next()) {

			System.out.printf("%-15s %-30s %-11s %-15s%n", result.getString("PAIS"), result.getString("PRESIDENTE"),
					result.getInt("PIB"), result.getString("COEFICIENTE_GINI"));
		}
		System.out.println("----------------------------------------------------------------------------");
		con.close();
	}

	public void modificarPais(String s, String n) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Paises;create=true");
		PreparedStatement sentencia = con.prepareStatement("UPDATE TABLAPAISES SET PAIS = ? WHERE PAIS = ?");
		sentencia.setString(1, s);
		sentencia.setString(2, n);
		sentencia.execute();
		con.close();

	}

	public void modificarPresidente(String n, String j) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Paises;create=true");
		PreparedStatement sentencia = con.prepareStatement("UPDATE TABLAPAISES SET PRESIDENTE = ? WHERE PAIS = ?");
		sentencia.setString(1, n);
		sentencia.setString(2, j);
		sentencia.execute();
		con.close();

	}

	public void modificarPIB(int n, String j) throws SQLException {

//		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Paises;create=true");
//		PreparedStatement sentencia = con.prepareStatement("UPDATE TABLAPAISES SET PIB = ? WHERE PAIS = ?");
//
//		sentencia.setInt(1, n);
//		sentencia.setString(2, j);
//		sentencia.execute();
//		con.close();

		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Paises;create=true");

		String q3 = "SELECT PIB FROM TABLAPAISES WHERE PAIS = ?";
		PreparedStatement sentenciaSelect = con.prepareStatement(q3);
		sentenciaSelect.setString(1, j);
		ResultSet result = sentenciaSelect.executeQuery();

		if (result.next()) {
			int valorActualPIB = result.getInt("PIB");

			String qUpdate = "UPDATE TABLAPAISES SET PIB = ? WHERE PAIS = ?";
			PreparedStatement sentenciaUpdate = con.prepareStatement(qUpdate);
			sentenciaUpdate.setInt(1, valorActualPIB + n);
			sentenciaUpdate.setString(2, j);
			sentenciaUpdate.execute();

			con.close();
		} else {
			System.out.println("No se encontró el país con el nombre: " + j);
		}

	}

	public void modificarCoeficiente_Gini(String n, String j) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Paises;create=true");
		PreparedStatement sentencia = con
				.prepareStatement("UPDATE TABLAPAISES SET COEFICIENTE_GINI = ? WHERE PAIS = ?");
		sentencia.setString(1, n);
		sentencia.setString(2, j);
		sentencia.execute();
		con.close();

	}

	public void limpiarTabla() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Paises;create=true");
		PreparedStatement sentencia = con.prepareStatement("DELETE FROM TABLAPAISES");
		sentencia.execute();
		con.close();

	}

}
