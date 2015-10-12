package skeleton.tablero;

import skeleton.exception.PosicionOcupadaException;
import skeleton.barco.Orientacion;

public class Tablero {

	private boolean[][] grilla;

	public Tablero(int alto, int ancho) {
		this.grilla = new boolean[alto][ancho];
	}

	public boolean estaPosicionOcupada(int fila, int columna) {
		return grilla[fila][columna];
	}

	public void posicionarBarco(PosicionBarco posicionBarco) throws Exception {
		int columnaInicial = posicionBarco.getColumnaInicial();
		int filaInicial = posicionBarco.getFilaInicial();
		Orientacion orientacion = posicionBarco.getOrientacion();
		int tamanioBarco = posicionBarco.getBarco().getTamanio();

		if (orientacion.equals(Orientacion.HORIZONTAL)) {
			int columnaFinal = columnaInicial + tamanioBarco;
			for (int columnaActual = columnaInicial; columnaActual < columnaFinal; columnaActual++) {
				validarPosicionOcupada(filaInicial, columnaActual);
			}
			for (int columnaActual = columnaInicial; columnaActual < columnaFinal; columnaActual++) {
				grilla[filaInicial][columnaActual] = true;
			}
		} else {
			int filaFinal = filaInicial + tamanioBarco;
			for (int filaActual = filaInicial; filaActual < filaFinal; filaActual++) {
				validarPosicionOcupada(columnaInicial, filaActual);
			}
			for (int filaActual = filaInicial; filaActual < filaFinal; filaActual++) {
				grilla[columnaInicial][filaActual] = true;
			}
		}
	}

	private boolean validarPosicionOcupada(int fila, int columna) throws Exception {
		if (grilla[fila][columna]) {
			throw new PosicionOcupadaException("Posicion ocupada");
		}
		return false;
	}
}
