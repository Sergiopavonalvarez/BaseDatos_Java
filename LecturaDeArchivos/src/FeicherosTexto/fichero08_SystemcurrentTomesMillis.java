package FeicherosTexto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fichero08_SystemcurrentTomesMillis {

	public static void main(String[] args) throws IOException {
		final long tInicio = System.currentTimeMillis();
		File fl = new File("QuijoteCompleto.txt");
		FileReader t = new FileReader("QuijoteCompleto.txt");
		FileWriter r = new FileWriter("Quijote3.txt");

		for (int i = 0; i < fl.length(); i++) {

			r.write((char) t.read());

		}
		
		final long tFinal=System.currentTimeMillis();
		System.out.println("Ha tardado: "+ (tFinal-tInicio + " milisegundos"));
		

	}

}
