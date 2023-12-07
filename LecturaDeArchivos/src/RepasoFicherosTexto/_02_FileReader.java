package RepasoFicherosTexto;

import java.io.FileReader;
import java.io.IOException;

public class _02_FileReader {
	public static void main(String[] args) throws IOException {
		// Se crea un objeto FileReader para leer el archivo "repaso_fichero2.txt"
		FileReader fr = new FileReader("repaso_fichero2.txt");

		// Se crea un arreglo de caracteres llamado "linea" con una longitud de 30
		char[] linea = new char[30];

		// Se realiza la primera lectura del archivo en el arreglo "linea"
		int i = fr.read(linea);

		// Se utiliza un bucle para leer y procesar el archivo en bloques de caracteres
		while (i != -1) {
			// Se imprime la línea actual convirtiendo el arreglo de caracteres a una cadena
			System.out.println(String.valueOf(linea));

			// Se realiza la siguiente lectura en el mismo arreglo "linea"
			i = fr.read(linea);
		}

		// Se cierra el FileReader después de completar la lectura del archivo
		fr.close();
	}
}
