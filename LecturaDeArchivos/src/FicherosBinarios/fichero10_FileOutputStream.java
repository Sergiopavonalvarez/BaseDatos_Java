package FicherosBinarios;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class fichero10_FileOutputStream {

	public static void main(String[] args) throws IOException {

		FileOutputStream i = new FileOutputStream("sumaGaussBinaria.dat");

		int resultado = 0;
		for (int j = 0; j <= 100; j++) {

			resultado += j;

		}
		i.write(resultado);
		i.close();
		System.out.println(resultado);

	}

}
