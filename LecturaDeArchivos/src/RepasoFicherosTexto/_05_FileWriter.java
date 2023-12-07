package RepasoFicherosTexto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _05_FileWriter {

	public static void main(String[] args) throws IOException {
		// Se define una cadena
		String frase = " Esto es un puto coñazo de asignatura y punto";

		// Se crea un FileReader para leer el archivo "repaso_fichero2.txt"
		FileReader fr = new FileReader("repaso_fichero2.txt");

		// Se crea un FileWriter para escribir en el archivo "repaso_fichero3.txt"
		FileWriter fw = new FileWriter("repaso_fichero3.txt");

		// Se crea un arreglo de caracteres para almacenar los primeros 20 caracteres
		char buf[] = new char[20];

		// Se lee los primeros 20 caracteres del primer archivo y se escriben en el
		// segundo archivo
		fr.read(buf);
		fw.write(buf);

		// Se añade la cadena "frase" al final del segundo archivo
		fw.write(frase);

		// Se cierran los FileReader y FileWriter
		fr.close();
		fw.close();

		// Se crea un FileReader para leer el segundo archivo
		FileReader fr2 = new FileReader("repaso_fichero3.txt");

		// Se lee y muestra el contenido del segundo archivo en la consola
		int i = fr2.read();
		while (i != -1) {
			System.out.print((char) i);
			i = fr2.read();
		}

		// Se cierra el FileReader del segundo archivo
		fr2.close();
	}
}
