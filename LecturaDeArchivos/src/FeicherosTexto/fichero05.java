package FeicherosTexto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fichero05 {

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("Quijote.txt");
		FileWriter fr2 = new FileWriter("Quijote2.txt");
		char[] linea = new char[178];

		fr.read(linea, 22, 65);
		fr2.write(linea, 10, 55);

		fr.close();
		fr2.close();

	}

}
