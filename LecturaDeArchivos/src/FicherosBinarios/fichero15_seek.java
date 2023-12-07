package FicherosBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class fichero15_seek {

	public static void main(String[] args) throws IOException {

//	    calcular cuántos enteros tiene el fichero
//		size = fichero.length();
//		/*cada int en Java ocupa 4 bytes. Si dividimos el total de bytes 	entre 4 obtenemos el número de enteros que contiene el    
//		fichero.*/
//		size = size / 4;
//		System.out.println("El fichero tiene " + size + " enteros");

		RandomAccessFile f = new RandomAccessFile("FAleatorio2.dat", "rw");
//		DataOutputStream out = new DataOutputStream(new FileOutputStream(f));
//		DataInputStream in = new DataInputStream(new FileInputStream(f));

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
			f.writeInt(temp);

		}

		System.out.println("");

		long size = 0;
		size = f.length();
		System.out.println(size);
		int pos = 4;
		int k = 0;

		f.seek((pos - 1) * 4);
		f.writeInt(k);
		f.read();
		f.seek(0);

		System.out.println("Serie de Fibonacci modificada:");

		for (int i = 0; i < 8; i++) {

			f.seek(i * 4);
			System.out.print(f.readInt() + ", ");

		}

		f.close();

	}

}
