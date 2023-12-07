import java.io.File;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class DB4O_01 {

	public static void main(String[] args) {

		File f = new File("db.yap");
		if (f.exists()) {
			f.delete();
		}

		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "db.yap");
		AlumnoCFGS a1 = new AlumnoCFGS("Sergio", (byte) 35, (byte) 7, 5, false, 2, "Barbie");
		AlumnoCFGS a2 = new AlumnoCFGS("Miguel", (byte) 20, (byte) 7, 5, true, 2, "Pricesitas");
		AlumnoCFGS a3 = new AlumnoCFGS("Jhair", (byte) 21, (byte) 8, 5, false, 2, "Mujercitas");
		AlumnoCFGS a4 = new AlumnoCFGS("Pablo", (byte) 19, (byte) 8, 5, true, 2, "La Cenicienta");
		AlumnoCFGS a5 = new AlumnoCFGS("Sergio", (byte) 25, (byte) 9, 5, false, 2, "Barbie La Princesa");

		AlumnoCFGS a6 = new AlumnoCFGS("Dante", (byte) 27, (byte) 9, 5, true, 2, "Piratas Del Caribe");
		db.store(a1);
		db.store(a2);
		db.store(a3);
		db.store(a4);
		db.store(a5);
		db.store(a6);

		System.out.println();
		System.out.println("**********ALUMNOS GRUPO 7*****************");
		System.out.println();

		ObjectSet c = db.queryByExample(new AlumnoCFGS((byte) (7)));

		while (c.hasNext()) {
			System.out.println(c.next());
		}

		System.out.println();
		System.out.println("************ALUMNOS GRUPO 8******************");
		System.out.println();

		ObjectSet a = db.queryByExample(new AlumnoCFGS((byte) (8)));

		while (a.hasNext()) {
			System.out.println(a.next());
		}

		System.out.println();
		System.out.println("*************TODOS LOS ALUMNOS********************");
		System.out.println();

		ObjectSet os = db.queryByExample(AlumnoCFGS.class);
		while (os.hasNext()) {
			System.out.println(os.next());
		}

		System.out.println();
		System.out.println("*************LOS QUE JUEGAN A CONSOLA********************");
		System.out.println();

		ObjectSet as = db.queryByExample(new AlumnoCFGS(null, (byte) 0, (byte) 0, 0, true, 0, null));

		while (as.hasNext()) {
			db.delete(as.next());

		}

		ObjectSet oos = db.queryByExample(AlumnoCFGS.class);
		while (oos.hasNext()) {
			System.out.println(oos.next());
		}

		System.out.println();
		System.out.println("***************LOS SERGIOS********************");
		System.out.println();

		Object g = db.queryByExample(new AlumnoCFGS("Sergio"));
		while (((ObjectSet) g).hasNext()) {
			System.out.println(((ObjectSet) g).next());
		}

		db.close();
	}
}
