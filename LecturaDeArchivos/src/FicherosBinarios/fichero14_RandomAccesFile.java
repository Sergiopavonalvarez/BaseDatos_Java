package FicherosBinarios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class fichero14_RandomAccesFile {

	public static void main(String[] args) throws IOException {
		// como podemos modificar un dato en un fichero secuencial?

		RandomAccessFile fichero = new RandomAccessFile("FAleatorio.dat", "rw");

		String a = "Hola Mundo";

		// Para escribir String:

		fichero.writeUTF(a);

		System.out.println("Posicion actual del puntero del fichero: " + fichero.getFilePointer());

		// Coloca el puntero en la posicion dada, en este caso en la cero:

		fichero.seek(0);

		System.out.println(fichero.readUTF());

		fichero.close();

	}

}
