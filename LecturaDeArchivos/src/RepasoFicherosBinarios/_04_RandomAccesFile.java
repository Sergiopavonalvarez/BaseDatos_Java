package RepasoFicherosBinarios;

import java.io.IOException;
import java.io.RandomAccessFile;

public class _04_RandomAccesFile {
	public static void main(String[] args) throws IOException {

		// Se crea un objeto RandomAccessFile para el archivo "FAleatorio2.dat" en modo
		// de lectura y escritura ("rw")
		RandomAccessFile f = new RandomAccessFile("FAleatorio2.dat", "rw");

		// Se define la cantidad de términos de la serie de Fibonacci a generar
		int n = 10;

		System.out.println("Serie de Fibonacci:");

		int a = 0;
		int b = 1;

		int temp = 0;

		// Se genera la serie de Fibonacci y se escribe cada término en el archivo
		for (int i = 2; i < n; i++) {
			temp = a + b;
			System.out.print(temp + ", ");
			a = b;
			b = temp;
			f.writeLong(temp);
		}

		System.out.println("");

		// Se calcula el tamaño del archivo (se resta 24 bytes para evitar leer datos
		// recién escritos)
		long size = f.length() - 24;

		System.out.println("Serie de Fibonacci modificada:");

		int k = 0;

		// Se posiciona el puntero al final del archivo y se escribe un valor (0) en los
		// últimos 8 bytes
		f.seek(size);
		f.writeLong(k);

		// Se realiza una operación de lectura que no se utiliza
		f.read();

		// Se reposiciona el puntero al inicio del archivo
		f.seek(0);

		// Se lee y muestra los 8 primeros términos de la serie de Fibonacci
		for (long i = 0; i < 8; i++) {
			System.out.print(f.readLong() + ", ");
		}

		// Se cierra el archivo
		f.close();
	}
}
