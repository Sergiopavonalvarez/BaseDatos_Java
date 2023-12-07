package RepasoFicherosBinarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _01_FileInputStream_FileOutputStream {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream("repaso_ficherobinario.dat");
		
		for (int i = 0; i < 100; i++) {
			fos.write(i);
			
		}
		fos.close();
		FileInputStream fis=new FileInputStream("repaso_ficherobinario.dat");
		int o=fis.read();
	
		while(o != -1) {
			System.out.println(o);
			//igualamos de nuevo para que avance
			o=fis.read();
		}
		fis.close();

	}

}
