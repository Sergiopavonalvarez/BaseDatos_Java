import java.io.File;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class DB4O_02 {

	public static void main(String[] args) {
		File f = new File("db.yap");
		if (f.exists()) {
			f.delete();
		}

		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "db.yap");
		AlumnoCFGS a1 = new AlumnoCFGS("Sergio", (byte) 35, (byte) 7, 5, false, 2, "Barbie");
		AlumnoCFGS a2 = new AlumnoCFGS("Miguel", (byte) 27, (byte) 7, 5, true, 2, "Pricesitas");
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
		
		ObjectSet c = db.queryByExample(new AlumnoCFGS((byte) (8)));
		
		while(c.hasNext()) {
			db.delete(c.next());
		}
		
		ObjectSet oos = db.queryByExample(AlumnoCFGS.class);
		AlumnoCFGS b;		
		while (oos.hasNext()) {
			
			b=(AlumnoCFGS) oos.next();
			if (b.getNombre().equals("Miguel")||b.getNombre().equals("Sergio")) {
				b.setEdad((byte) (b.getEdad() + 1));
			}
			System.out.println(b);
		}		
		
		db.close();


	}

}
