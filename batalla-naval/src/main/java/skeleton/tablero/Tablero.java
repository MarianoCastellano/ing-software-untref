package skeleton.tablero;

import skeleton.barco.Orientacion;

public class Tablero {

	private boolean[][] grilla;

	public Tablero(int alto, int ancho) {
		this.grilla = new boolean[alto][ancho];
	}

	public boolean estaPosicionOcupada(int fila, int columna) {
		return grilla[fila][columna];
	}

	public void posicionarBarco(PosicionBarco posicionBarco) {
		int columnaInicial = posicionBarco.getColumnaInicial();
		int filaInicial = posicionBarco.getFilaInicial();
		Orientacion orientacion = posicionBarco.getOrientacion();
		int tamanioBarco = posicionBarco.getBarco().getTamanio();

		if (orientacion.equals(Orientacion.HORIZONTAL)) {
			int columnaFinal = columnaInicial + tamanioBarco;
			boolean estaOcupada = validarPosicionOcupada(columnaInicial, columnaFinal, filaInicial);
			if (!estaOcupada) {
				for (int columnaActual = columnaInicial; columnaActual < columnaFinal; columnaActual++) {
					grilla[filaInicial][columnaActual] = true;
				}
			}
		} else {
			int filaFinal = filaInicial + tamanioBarco;
			boolean estaOcupada = validarPosicionOcupada(filaInicial, filaFinal, columnaInicial);
			if (!estaOcupada) {
				for (int filaActual = filaInicial; filaActual < filaFinal; filaActual++) {
					grilla[columnaInicial][filaActual] = true;
				}
			}
		}
	}

	private boolean validarPosicionOcupada(int inicial, int size, int fija) {
		for (int actual = inicial; actual < size; actual++) {
			boolean posicionOcupada = estaPosicionOcupada(fija, actual);
			if (posicionOcupada) {
				return true;
			}
		}
		return false;
	}
}
