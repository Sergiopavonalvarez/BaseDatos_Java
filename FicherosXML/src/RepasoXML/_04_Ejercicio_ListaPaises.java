package RepasoXML;
import java.util.ArrayList;

public class _04_Ejercicio_ListaPaises {

	private ArrayList<_04_Ejercicio_Pais> Pais;

	public _04_Ejercicio_ListaPaises() {
		this.Pais = new ArrayList<_04_Ejercicio_Pais>();
	}

	public ArrayList<_04_Ejercicio_Pais> getPais() {
		return Pais;
	}

	public void setPais(ArrayList<_04_Ejercicio_Pais> pais) {
		this.Pais = pais;
	}

	public void addPais(_04_Ejercicio_Pais pais) {
		this.Pais.add(pais);
	}

	public String toString() {
		return "" + Pais;
	}

}
