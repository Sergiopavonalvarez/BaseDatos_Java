package RepasoFicherosTexto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _06_FileWriter_desplazamiento {

	public static void main(String[] args) throws IOException {
		File repaso4=new File("repaso_fichero.txt");
		FileReader fr=new FileReader(repaso4);
		FileWriter fw=new FileWriter("repaso_fichero4.txt");
		
		char buf[]=new char[(int)repaso4.length()];
		System.out.println((buf.length));
		System.out.println(buf);
		int desplec=22;
		int despEcs=10;
		int tamlec=200;
		int tamesc=tamlec-despEcs;
		fr.read(buf,desplec,tamlec);

		fw.write(buf,despEcs,tamesc);
		fr.close();
		fw.close();
		
		

	}

}
