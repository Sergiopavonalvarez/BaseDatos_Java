package FeicherosTexto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fichero04 {

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("Quijote.txt");
		FileWriter fr2 = new FileWriter("Quijote2.txt", true);
		String fin = "\n Etc, etc.. \n Fin del fichero.";
	
		char[] linea = new char[88];

		
		

		fr.read(linea);
		fr.read(linea);
		fr2.write(linea);
		fr2.write(linea);
		fr2.write(linea);
		

		fr2.write(fin);
		

		fr.close();
		fr2.close();

	}

}
