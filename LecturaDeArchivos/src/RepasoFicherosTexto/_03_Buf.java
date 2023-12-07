package RepasoFicherosTexto;

import java.io.FileReader;
import java.io.IOException;

public class _03_Buf {
	public static void main(String[] args) throws IOException {
		// Se crea un objeto FileReader para leer el archivo "repaso_fichero2.txt"
		FileReader fr = new FileReader("repaso_fichero2.txt");

		// Se crea un arreglo de caracteres llamado "buf" con una longitud de 60
		char buf[] = new char[60];

		// Se realiza la lectura del archivo en el arreglo "buf"
		fr.read(buf);

		// Se imprime el contenido del arreglo "buf"
		System.out.println(buf);
		fr.close();

	}
}
