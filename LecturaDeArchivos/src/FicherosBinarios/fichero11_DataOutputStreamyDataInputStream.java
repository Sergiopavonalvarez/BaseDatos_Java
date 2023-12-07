package FicherosBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class fichero11_DataOutputStreamyDataInputStream {

	public static void main(String[] args) throws IOException {

		File f = new File("fBinario.dat");
		File f2 = new File("fBinario2.dat");
		DataOutputStream out = new DataOutputStream(new FileOutputStream(f));
		DataOutputStream out2 = new DataOutputStream(new FileOutputStream(f2));
		DataInputStream in = new DataInputStream(new FileInputStream(f));

		int num = 12;
		int fibo1 = 1;
		int fibo2 = 1;
		out.writeInt(num);
		out2.writeInt(fibo1);

		System.out.print(fibo1 + " ");
		int aux = in.readInt();
		for (int i = 2; i <= aux; i++) {
			System.out.print(fibo2 + " ");
			out2.writeInt(fibo2);
			out2.writeUTF(" ");
			fibo2 = fibo1 + fibo2;
			fibo1 = fibo2 - fibo1;
		}
		out.close();
		out2.close();
		in.close();

	}

}
