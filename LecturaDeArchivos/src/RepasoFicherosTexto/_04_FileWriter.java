package RepasoFicherosTexto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _04_FileWriter {

	public static void main(String[] args) throws IOException {
		// Se define una cadena
		String frase = " Esto es un puto coñazo de asignatura";

		// Se crea un FileReader para leer el archivo "repaso_fichero.txt"
		FileReader fr = new FileReader("repaso_fichero.txt");

		// Se crea un FileWriter para escribir en el archivo "repaso_fichero2.txt"
		FileWriter fw = new FileWriter("repaso_fichero2.txt");

		// Se lee el contenido del primer archivo y se escribe en el segundo archivo
		int i = fr.read();
		while (i != -1) {
			fw.write((char) i);
			i = fr.read();
		}

		// Se añade la cadena "frase" al final del segundo archivo
		fw.write(frase);

		// Se cierran los FileReader y FileWriter
		fr.close();
		fw.close();

		// Se crea un FileReader para leer el segundo archivo
		FileReader fr2 = new FileReader("repaso_fichero2.txt");

		// Se lee y muestra el contenido del segundo archivo en la consola
		int o = fr2.read();
		while (o != -1) {
			System.out.print((char) o);
			o = fr2.read();
		}

		// Se cierra el FileReader del segundo archivo
		fr2.close();
	}
}
