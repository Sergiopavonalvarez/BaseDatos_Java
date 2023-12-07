import java.io.File;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class DBRO_03 {

	public static void main(String[] args) {

		File f = new File("db.yap");
		if (f.exists()) {
			f.delete();
		}

		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "db.yap");
		Query query = db.query();
		AlumnoCFGS a = new AlumnoCFGS();

		String[] nombre = { "Miguel", "Dante", "Sergio.R", "Sergio.P", "Pablo", "Jhair" };
		byte[] edad = { 27, 36, 35, 23, 28, 28 };
		byte[] noGrupo = { 7, 8, 9, 7, 9, 8 };
		float[] alturaMetros = { (float) 1.80, (float) 1.90, (float) 1.78, (float) 1.98, (float) 1.96, (float) 1.57 };
		boolean[] juegaConsola = { true, false, false, true, true, true };
		long[] horasLol = { 200, 45, 70, 0, 23, 72 };
		String[] juegoFavorito = { "The last of us", "Monsters inc", "The last of us", "Barbie la princesa costurera",
				"LOL", "Harry potter" };

		for (int i = 0; i < nombre.length; i++) {
			db.store(new AlumnoCFGS(nombre[i], (byte) (edad[i]), (byte) (noGrupo[i]), alturaMetros[i], juegaConsola[i],
					(long) (horasLol[i]), juegoFavorito[i]));
		}

		query.descend("juegaEnConsola").constrain(true).and(query.descend("edad").constrain(29).smaller());
		ObjectSet<AlumnoCFGS> result = query.execute();

		while (result.hasNext()) {
			System.out.println(result.next());
		}

		db.close();

	}

}
