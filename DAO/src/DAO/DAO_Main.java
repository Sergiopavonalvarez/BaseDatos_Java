package DAO;

import java.sql.SQLException;

public class DAO_Main {

	public static void main(String[] args) throws SQLException {

		DAO_Alumnos a = new DAO_Alumnos();

		//a.crearTabla();
		//a.rellenaTabla();
		// a.borraTabla();

		AlumnoCFGS b = new AlumnoCFGS("Sergio", (byte) 35, (byte) 9, (float) 1.78, false, (long) 70, "The last of us");
		AlumnoCFGS ñ = new AlumnoCFGS("Jhair", (byte) 35, (byte) 9, (float) 1.78, false, (long) 70, "The last of us");

		System.out.println(a.buscarMal(b));

		System.out.println("**************************************************************************************");
		a.imprimirBasesDAtos();

		System.out.println("**************************************************************************************");
		a.imprimeAlumno();
		a.borraNombre("Jhair");

		a.modificarNombre("Jose", 2);
		a.modificarEdad((byte) 9, 2);
		a.modificarNoGrupo((byte) 0, 2);
		a.modificarAltura((byte) 1.5, 2);
		a.modificarConsola(true, 2);
		a.modificarJuego("Pinta y colorea", 2);

		System.out.println("**************************************************************************************");
		a.imprimirBasesDAtos();
		System.out.println("**************************************************************************************");

		// a.rellenaUno(ñ);

	}

}