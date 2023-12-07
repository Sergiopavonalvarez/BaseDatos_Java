package RepasoFicherosTexto;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _08_BufferedWriter {

	public static void main(String[] args) throws IOException {
		// Se crea un FileWriter para escribir en el archivo "repaso_fichero5.txt"
		FileWriter fw = new FileWriter("repaso_fichero5.txt");

		// Se crea un BufferedWriter para mejorar el rendimiento de escritura
		BufferedWriter bfw = new BufferedWriter(fw);

		// Se define un arreglo de cadenas
		String[] lineas = { "Uno", "Dos", "Tres" };

		// Se recorre el arreglo y se escribe cada línea en el archivo, seguida de un
		// salto de línea
		for (int i = 0; i < lineas.length; i++) {
			bfw.write(lineas[i] + "\n");
		}

		// Se cierra BufferedWriter antes que FileWriter
		bfw.close();
		fw.close();
	}
}
