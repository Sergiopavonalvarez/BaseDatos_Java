package RepasoFicherosTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _07_BufferReader {
	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("repaso_fichero3.txt");
		BufferedReader bfr=new BufferedReader(fr);
		String linea=bfr.readLine();
		while(linea != null) {
			System.out.println(linea);
			linea=bfr.readLine();
		}
		fr.close();
		bfr.close();
	}

}
