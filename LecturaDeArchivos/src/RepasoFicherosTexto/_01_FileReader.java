package RepasoFicherosTexto;

import java.io.FileReader;
import java.io.IOException;

public class _01_FileReader {
	
	public static void main(String[] args) throws IOException {
		FileReader fr =new FileReader("repaso_fichero.txt");
		System.out.println("***FICHERO 1****");
		//Este método lee el siguiente carácter del flujo de entrada del archivo asociado al FileReader. 
		//Retorna el valor del carácter leído como un entero. Si llega al final del archivo, devuelve -1
		int i=fr.read();
		
		while(i != -1) {
			// La conversión (char) i se realiza para mostrar el carácter en lugar de su valor entero
			System.out.print((char)i);
			//Después de imprimir el carácter, se realiza otra llamada a fr.read() para leer el 
			//siguiente carácter del archivo y actualizar el valor de i
			i=fr.read();
		}
		fr.close();

		
	
	
	
	}

}
