package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

public class DAO_Alumnos {

	public Connection con;

	public void crearTabla() throws SQLException {

		con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");

		String q1 = "CREATE TABLE TABLAALUMNOS (ID INT PRIMARY KEY, Nombre VARCHAR (200), EDAD SMALLINT, NOGRUPO SMALLINT, alturaAproxEnMetros REAL,"
				+ "juegaEnConsola BOOLEAN, horasEnElLOL BIGINT, juegoFavorito VARCHAR (200))";
		PreparedStatement sentencia = con.prepareStatement(q1);
		sentencia.execute();
		con.close();

	}

	public void borraTabla() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");
		PreparedStatement sentencia = con.prepareStatement("DROP TABLE TABLAALUMNOS");

		sentencia.execute();
		con.close();

	}

	public void rellenaUno(AlumnoCFGS ñ) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");
		String q2 = "INSERT INTO TABLAALUMNOS (ID, Nombre, EDAD, NOGRUPO, alturaAproxEnMetros, juegaEnConsola, horasEnElLOL, juegoFavorito) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement sentencia = con.prepareStatement(q2);

		sentencia.setString(1, ñ.getNombre());
		sentencia.setByte(2, ñ.getEdad());
		sentencia.setByte(3, ñ.getNoGrupo());
		sentencia.setFloat(4, ñ.getAlturaAproxEnMetros());
		sentencia.setBoolean(5, ñ.isJuegaEnConsola());
		sentencia.setLong(6, ñ.getHorasEnElLOL());
		sentencia.setString(7, ñ.getJuegoFavorito());

		con.close();

	}

	public void rellenaTabla() throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");

		String[] nombre = { "Miguel", "Dante", "Sergio", "Sergio", "Pablo", "Jhair" };
		byte[] edad = { 27, 36, 35, 23, 28, 28 };
		byte[] noGrupo = { 7, 8, 9, 7, 9, 8 };
		float[] alturaMetros = { (float) 1.80, (float) 1.90, (float) 1.78, (float) 1.98, (float) 1.96, (float) 1.57 };
		boolean[] juegaConsola = { true, false, false, true, true, true };
		long[] horasLol = { 200, 45, 70, 0, 23, 72 };
		String[] juegoFavorito = { "The last of us", "Monsters inc", "The last of us", "Barbie la princesa costurera",
				"LOL", "Harry potter" };

		String q2 = "INSERT INTO TABLAALUMNOS (ID, Nombre, EDAD, NOGRUPO, alturaAproxEnMetros, juegaEnConsola, horasEnElLOL, juegoFavorito) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement sentencia = con.prepareStatement(q2);

		for (int i = 0; i < nombre.length; i++) {

			sentencia.setInt(1, i + 1);
			sentencia.setString(2, nombre[i]);
			sentencia.setByte(3, edad[i]);
			sentencia.setByte(4, noGrupo[i]);
			sentencia.setFloat(5, alturaMetros[i]);
			sentencia.setBoolean(6, juegaConsola[i]);
			sentencia.setLong(7, horasLol[i]);
			sentencia.setString(8, juegoFavorito[i]);
			sentencia.execute();
		}
		con.close();

	}

	public void imprimirBasesDAtos() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");
		String q3 = "SELECT * FROM TABLAALUMNOS";
		PreparedStatement sentencia = con.prepareStatement(q3);
		ResultSet result = (ResultSet) sentencia.executeQuery();
		while (result.next()) {
			System.out.print(result.getInt("ID") + "\t");
			System.out.print(result.getString("NOMBRE") + "\t");
			System.out.print(result.getByte("EDAD") + "\t");
			System.out.print(result.getByte("NOGRUPO") + "\t");
			System.out.print(result.getFloat("alturaAproxEnMetros") + "\t");
			System.out.print(result.getBoolean("JuegaEnConsola") + "\t");
			System.out.print(result.getLong("horasEnElLOL") + "\t");
			System.out.print(result.getString("juegoFavorito"));
			System.out.println();
		}
		con.close();
	}

	public boolean buscarMal(AlumnoCFGS a) throws SQLException {
		boolean esta = false;
		con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");
		PreparedStatement sentencia = con.prepareStatement(
				"SELECT * FROM TABLAALUMNOS WHERE Nombre=? AND EDAD=? AND NOGRUPO=? AND alturaAproxEnMetros=? AND juegaEnConsola=? AND horasEnElLOL=? AND juegoFavorito=?");
		sentencia.setString(1, a.getNombre());
		sentencia.setByte(2, a.getEdad());
		sentencia.setByte(3, a.getNoGrupo());
		sentencia.setFloat(4, a.getAlturaAproxEnMetros());
		sentencia.setBoolean(5, a.isJuegaEnConsola());
		sentencia.setLong(6, a.getHorasEnElLOL());
		sentencia.setString(7, a.getJuegoFavorito());
		ResultSet res = sentencia.executeQuery();
		if (res.next()) {
			esta = true;
			return esta;
		}
		con.close();
		return false;

	}

	public void imprimeAlumno() throws SQLException {
		System.out.println("Introduce el nombre: ");
		Scanner sc = new Scanner(System.in);
		String nombre = "";
		nombre = sc.nextLine();
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");
		PreparedStatement sentencia = con.prepareStatement("SELECT * FROM TABLAALUMNOS WHERE Nombre=?");
		sentencia.setString(1, nombre);

		ResultSet res = sentencia.executeQuery();
		while (res.next()) {
			System.out.print(res.getString("NOMBRE") + "\t");
			System.out.print(res.getByte("EDAD") + "\t");
			System.out.print(res.getByte("NOGRUPO") + "\t");
			System.out.print(res.getFloat("alturaAproxEnMetros") + "m\t");
			System.out.print(res.getBoolean("JuegaEnConsola") + "\t");
			System.out.print(res.getLong("horasEnElLOL") + "\t");
			System.out.print(res.getString("juegoFavorito"));
			System.out.println();
		}
		con.close();
	}

	public void borraNombre(String l) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");
		PreparedStatement sentencia = con.prepareStatement("DELETE FROM TABLAALUMNOS WHERE Nombre=?");
		sentencia.setString(1, l);
		sentencia.execute();
		con.close();

	}

	public void modificarNombre(String s, int n) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");
		PreparedStatement sentencia = con.prepareStatement("UPDATE TABLAALUMNOS SET Nombre = ? WHERE ID = ?");
		sentencia.setString(1, s);
		sentencia.setInt(2, n);
		sentencia.execute();
		con.close();

	}

	public void modificarEdad(byte n, int j) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");
		PreparedStatement sentencia = con.prepareStatement("UPDATE TABLAALUMNOS SET Edad = ? WHERE ID = ?");
		sentencia.setByte(1, (byte) n);
		sentencia.setInt(2, j);
		sentencia.execute();
		con.close();

	}

	public void modificarNoGrupo(byte n, int j) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");
		PreparedStatement sentencia = con.prepareStatement("UPDATE TABLAALUMNOS SET NOGRUPO = ? WHERE ID = ?");
		sentencia.setByte(1, (byte) n);
		sentencia.setInt(2, j);
		sentencia.execute();
		con.close();

	}

	public void modificarAltura(float n, int j) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");
		PreparedStatement sentencia = con
				.prepareStatement("UPDATE TABLAALUMNOS SET alturaAproxEnMetros = ? WHERE ID = ?");
		sentencia.setFloat(1, (float) n);
		sentencia.setInt(2, j);
		sentencia.execute();
		con.close();

	}

	public void modificarConsola(boolean n, int j) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");
		PreparedStatement sentencia = con.prepareStatement("UPDATE TABLAALUMNOS SET juegaEnConsola = ? WHERE ID = ?");
		sentencia.setBoolean(1, n);
		sentencia.setInt(2, j);
		sentencia.execute();
		con.close();

	}

	public void modificarHorasLOL(long n, int j) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");
		PreparedStatement sentencia = con.prepareStatement("UPDATE TABLAALUMNOS SET horasEnElLOL = ? WHERE ID = ?");
		sentencia.setLong(1, n);
		sentencia.setInt(2, j);
		sentencia.execute();
		con.close();

	}

	public void modificarJuego(String n, int j) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:derby:basedatos\\Alumnos;create=true");
		PreparedStatement sentencia = con.prepareStatement("UPDATE TABLAALUMNOS SET juegoFavorito = ? WHERE ID = ?");
		sentencia.setString(1, n);
		sentencia.setInt(2, j);
		sentencia.execute();
		con.close();

	}

}