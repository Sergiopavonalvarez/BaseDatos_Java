package FeicherosTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class fichero07_BufferReaderyBufferWriter {

	public static void main(String[] args) throws IOException {

		final long tInicio = System.currentTimeMillis();

		FileReader t = new FileReader("QuijoteCompleto.txt");
		FileWriter r = new FileWriter("Quijote3.txt");

		BufferedReader o = new BufferedReader(t);
		BufferedWriter l = new BufferedWriter(r);

		String linea = o.readLine();

		while ((linea = o.readLine()) != null) {

			l.write(linea);
			l.write("\n");

		}

		final Long tFinal = System.currentTimeMillis();
		t.close();
		r.close();
		System.out.println(tFinal - tInicio);
		
		
		

	}

}
