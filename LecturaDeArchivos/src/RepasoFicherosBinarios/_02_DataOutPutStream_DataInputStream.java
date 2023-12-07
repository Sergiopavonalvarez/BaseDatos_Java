package RepasoFicherosBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _02_DataOutPutStream_DataInputStream {
	public static void main(String[] args) throws IOException {
		// Crear un DataOutputStream para escribir datos en el archivo binario
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("repaso_ficherobinario.dat"));

		// Datos a escribir en el archivo
		String nombres[] = { "Juan", "Pepe" };
		int edades[] = { 13, 56 };

		// Escribir datos en el archivo
		for (int i = 0; i < edades.length; i++) {
			dos.writeUTF(nombres[i]);
			dos.writeInt(edades[i]);
		}

		// Cerrar el DataOutputStream
		dos.close();

		// Crear un DataInputStream para leer datos del archivo binario
		DataInputStream dis = new DataInputStream(new FileInputStream("repaso_ficherobinario.dat"));

		try {
			// Leer datos del archivo mientras haya más datos disponibles
			while (dis.available() > 0) {
				// Leer una cadena y un entero del archivo
				String n = dis.readUTF();
				int e = dis.readInt();

				// Mostrar los datos leídos en la consola
				System.out.println(n + " " + e);
			}
		} catch (EOFException e) {
			// Manejar la excepción de fin de archivo
			System.out.println("Fin de archivo alcanzado.");
		} finally {
			// Cerrar el DataInputStream en un bloque finally
			dis.close();
		}
	}
}
