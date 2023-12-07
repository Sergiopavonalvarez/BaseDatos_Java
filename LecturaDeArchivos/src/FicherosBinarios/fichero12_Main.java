package FicherosBinarios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class fichero12_Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		fichero12_Serializable a = new fichero12_Serializable();
		a.setNombre("Dante");
		a.setEdad((byte) 36);
		a.setNoGrupo((byte) 8);
		a.setAlturaAproxEnMetros(2.87f);
		a.setJuegaEnConsola(true);
		a.setHorasEnElLOL(90);
		a.setJuegoFavorito("FIFA");

		fichero12_Serializable b = new fichero12_Serializable();
		b.setNombre("Pablo");
		b.setEdad((byte) 28);
		b.setNoGrupo((byte) 9);
		b.setAlturaAproxEnMetros(1.86f);
		b.setJuegaEnConsola(true);
		b.setHorasEnElLOL(500);
		b.setJuegoFavorito("Total World");

		fichero12_Serializable c = new fichero12_Serializable();
		c.setNombre("Sergio R.");
		c.setEdad((byte) 22);
		c.setNoGrupo((byte) 1.85f);
		c.setAlturaAproxEnMetros(2);
		c.setJuegaEnConsola(true);
		c.setHorasEnElLOL(1500);
		c.setJuegoFavorito("Counter Strike");

		fichero12_Serializable e = new fichero12_Serializable();
		e.setNombre("Sergio P.");
		e.setEdad((byte) 36);
		e.setNoGrupo((byte) 7);
		e.setAlturaAproxEnMetros(1.72f);
		e.setJuegaEnConsola(true);
		e.setHorasEnElLOL(90);
		e.setJuegoFavorito("Tetris");

		fichero12_Serializable f = new fichero12_Serializable();
		f.setNombre("Miguel");
		f.setEdad((byte) 36);
		f.setNoGrupo((byte) 7);
		f.setAlturaAproxEnMetros(1.73f);
		f.setJuegaEnConsola(true);
		f.setHorasEnElLOL(90);
		f.setJuegoFavorito("Last Of Us");

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Fila3.dat"));
		Object[] alumnos = new Object[5];
		alumnos[0] = a;
		alumnos[1] = b;
		alumnos[2] = c;
		alumnos[3] = e;
		alumnos[4] = f;

		for (int i = 0; i < alumnos.length; i++) {
			oos.writeObject(alumnos[i]);

		}
		oos.close();

	}

}
