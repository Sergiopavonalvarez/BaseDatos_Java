package FicherosBinarios;

import java.io.*;

public class fichero12_Serializable implements Serializable {
	private static final long serialVersionUID = 1L;
	public String nombre;
	public byte edad;
	public byte noGrupo;
	public float alturaAproxEnMetros;
	public boolean juegaEnConsola;
	public long horasEnElLOL;
	public String juegoFavorito;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public byte getNoGrupo() {
		return noGrupo;
	}

	public void setNoGrupo(byte noGrupo) {
		this.noGrupo = noGrupo;
	}

	public float getAlturaAproxEnMetros() {
		return alturaAproxEnMetros;
	}

	public void setAlturaAproxEnMetros(float alturaAproxEnMetros) {
		this.alturaAproxEnMetros = alturaAproxEnMetros;
	}

	public boolean isJuegaEnConsola() {
		return juegaEnConsola;
	}

	public void setJuegaEnConsola(boolean juegaEnConsola) {
		this.juegaEnConsola = juegaEnConsola;
	}

	public long getHorasEnElLOL() {
		return horasEnElLOL;
	}

	public void setHorasEnElLOL(long horasEnElLOL) {
		this.horasEnElLOL = horasEnElLOL;
	}

	public String getJuegoFavorito() {
		return juegoFavorito;
	}

	public void setJuegoFavorito(String juegoFavorito) {
		this.juegoFavorito = juegoFavorito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}


