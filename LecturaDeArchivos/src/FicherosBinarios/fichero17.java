package FicherosBinarios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class fichero17 {

	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		RandomAccessFile f = new RandomAccessFile("FAleatorio3.dat", "rw");

		f.writeChars("Hello Barbie");
		f.seek(0);
		System.out.println(f.readLine());
		f.seek(12);
		f.writeChars("Ken!   ");
		f.seek(0);
		System.out.println(f.readLine());

	}

}
