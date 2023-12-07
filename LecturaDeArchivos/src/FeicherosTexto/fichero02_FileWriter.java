package FeicherosTexto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class fichero02_FileWriter {

	public static void main(String[] args) throws IOException {

		FileReader fr2 = new FileReader("Quijote.txt");
		FileWriter fr3 = new FileWriter("Quijote2.txt");
		int i = fr2.read();

		String fin = "\n Etc, etc... Fin del fichero.";

		while (i != -1) {
			fr3.write(i);
			i = fr2.read();
			System.out.print((char)i);
		}
		fr3.write(fin);

		fr2.close();
		fr3.close();

	}

}
