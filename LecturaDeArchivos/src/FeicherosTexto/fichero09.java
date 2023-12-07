package FeicherosTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fichero09 {

	public static void main(String[] args) throws IOException {

		final long tInicio = System.currentTimeMillis();
		FileReader t = new FileReader("QuijoteCompleto.txt");
		FileWriter r = new FileWriter("Quijote3.txt");
		BufferedReader R = new BufferedReader(t);
		BufferedWriter l = new BufferedWriter(r);
		String linea;

		while ((linea = R.readLine()) != null) {

			l.write(linea);
			l.write("\n");

		}
		final long tFinal = System.currentTimeMillis();
		System.out.println("Ha tardado " + (tFinal - tInicio)+" milisegundos");

	}

}
