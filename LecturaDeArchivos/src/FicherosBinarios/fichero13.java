package FicherosBinarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class fichero13 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream fila1 = new ObjectInputStream(new FileInputStream("Fila1.dat"));
		ObjectInputStream fila2 = new ObjectInputStream(new FileInputStream("Fila2.dat"));
		ObjectInputStream fila3 = new ObjectInputStream(new FileInputStream("Fila3.dat"));
		ObjectInputStream fila4 = new ObjectInputStream(new FileInputStream("Fila4.dat"));
		ObjectOutputStream Clase = new ObjectOutputStream(new FileOutputStream("Clase.dat"));

		Object filas[] = new Object[4];
		filas[0] = fila1;
		filas[1] = fila2;
		filas[2] = fila3;
		filas[3] = fila4;

		fila1.readObject();
		fila2.readObject();
		fila3.readObject();
		fila4.readObject();

		for (int i = 0; i < filas.length; i++) {

			Clase.writeObject(filas[i]);

		}
		fila1.close();
		fila2.close();
		fila3.close();
		fila4.close();
		Clase.close();

	}

}
