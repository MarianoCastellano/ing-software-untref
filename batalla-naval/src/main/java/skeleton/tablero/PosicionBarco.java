package skeleton.tablero;

import skeleton.barco.Barco;
import skeleton.barco.Orientacion;

public class PosicionBarco {

	private Barco barco;
	private int filaInicial;
	private int columnaInicial;
	private Orientacion orientacion;

	public PosicionBarco(Barco barco, int filaInicial, int columnaInicial, Orientacion orientacion) {
		this.barco = barco;
		this.filaInicial = filaInicial;
		this.columnaInicial = columnaInicial;
		this.orientacion = orientacion;
	}

	public Barco getBarco() {
		return barco;
	}

	public int getColumnaInicial() {
		return columnaInicial;
	}

	public int getFilaInicial() {
		return filaInicial;
	}

	public Orientacion getOrientacion() {
		return orientacion;
	}
}
