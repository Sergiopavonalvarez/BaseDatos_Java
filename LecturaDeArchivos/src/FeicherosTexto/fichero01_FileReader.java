package FeicherosTexto;

import java.io.FileReader;
import java.io.IOException;

public class fichero01_FileReader {
	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("Quijote.txt");
			System.out.println("******* El Quijote*******");
			int i = fr.read();

			while (i != -1) {
				System.out.print((char) i);
				i = fr.read();
			}
			System.out.println();
			System.out.println("*********Fichero2*********");

			FileReader fr2 = new FileReader("Quijote.txt");
			char[] linea = new char[60];
			int a;
			a = fr2.read(linea);
			System.out.println(String.valueOf(linea));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}}
