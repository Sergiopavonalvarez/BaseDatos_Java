import java.io.Serializable;

public class _02_Ejercicio_Pais implements Serializable {

	String Nombre;
	String Presidente;
	int PIB;
	String Coeficiente_Gini;

	public _02_Ejercicio_Pais(String nombre, String presidente, int pib, String coeficiente) {
		super();
		this.Nombre = nombre;
		this.Presidente = presidente;
		this.PIB = pib;
		this.Coeficiente_Gini = coeficiente;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getPresidente() {
		return Presidente;
	}

	public void setPresidente(String presidente) {
		this.Presidente = presidente;
	}

	public int getPib() {
		return PIB;
	}

	public void setPib(int pib) {
		this.PIB = pib;
	}

	public String getCoeficiente() {
		return Coeficiente_Gini;
	}

	public void setCoeficiente(String coeficiente) {
		this.Coeficiente_Gini = coeficiente;
	}

	@Override
	public String toString() {
		return "nombre=" + Nombre + ", presidente=" + Presidente + ", pib=" + PIB + ", coeficiente=" + Coeficiente_Gini
				+ "\n";
	}

}
