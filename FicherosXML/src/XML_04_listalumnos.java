
import java.util.ArrayList;
import java.util.List;

public class XML_04_listalumnos {
	private List<Object> lista = new ArrayList<>();

	public XML_04_listalumnos() {
	}

	public void add(Object a) {
		lista.add(a);
	}

	public List<Object> getListaAlumnos() {
		return lista;
	}
}
