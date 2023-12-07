package FicherosBinarios;

import java.io.IOException;
import java.io.RandomAccessFile;

public class fichero16 {
	public static void main(String[] args) throws IOException {

		RandomAccessFile f = new RandomAccessFile("FAleatorio2.dat", "rw");

		int n = 10;
		System.out.println("Serie de Fibonacci:");

		int a = 0;
		int b = 1;

		int temp = 0;

		for (int i = 2; i < n; i++) {
			temp = a + b;
			System.out.print(temp + ", ");
			a = b;
			b = temp;
			f.writeLong(temp);

		}

		System.out.println("");

		long size = 0;
		size = f.length() - 24;

		System.out.println("Serie de Fibonacci modificada:");
		int k = 0;

		f.seek(size);
		f.writeLong(k);
		f.read();
		f.seek(0);

		for (long i = 0; i < 8; i++) {

			// f.seek(i * 4);
			System.out.print(f.readLong() + ", ");

		}

		f.close();

	}

}
