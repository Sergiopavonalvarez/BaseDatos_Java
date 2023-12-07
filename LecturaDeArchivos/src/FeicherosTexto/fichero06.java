package FeicherosTexto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fichero06 {

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("Quijote.txt");
		FileWriter fr2 = new FileWriter("Quijote2.txt", true);
		String salto = "\n";
		char[] linea = new char[178];
		fr.read(linea);

		for (int i = 0; i < 6; i++) {
			
			fr2.write(linea);
			fr2.write(salto);

		}

	}

}
