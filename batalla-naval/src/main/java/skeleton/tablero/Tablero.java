package skeleton.tablero;

import skeleton.barco.Barco;
import skeleton.barco.Orientacion;
import skeleton.barco.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

	private boolean[][] grilla;
	private List<Barco> barcos;

	public Tablero(int alto, int ancho) {
		this.grilla = new boolean[alto][ancho];
		this.barcos = new ArrayList<>();
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
					Barco barco = posicionBarco.getBarco();
					barcos.add(barco);
					barco.agregarPosicion(filaInicial, columnaActual);
				}
			}
		} else {
			int filaFinal = filaInicial + tamanioBarco;
			boolean estaOcupada = validarPosicionOcupada(filaInicial, filaFinal, columnaInicial);
			if (!estaOcupada) {
				for (int filaActual = filaInicial; filaActual < filaFinal; filaActual++) {
					grilla[columnaInicial][filaActual] = true;
					Barco barco = posicionBarco.getBarco();
					barcos.add(barco);
					barco.agregarPosicion(columnaInicial, filaActual);
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

	public ResultadoDisparo disparar(Posicion posicion) {
		Barco barco = obtenerBarcoPorFilaYColumna(posicion);
		if (barco == null) {
			return ResultadoDisparo.AGUA;
		}
		agregarDanio(barco, posicion);
		boolean estaHundido = barco.estasHundido();
		if (!estaHundido) {
			return ResultadoDisparo.BLANCO;
		} else {
			return ResultadoDisparo.HUNDIDO;
		}

	}

	private void agregarDanio(Barco barco, Posicion posicion) {
		barco.daniar(posicion);
	}

	private Barco obtenerBarcoPorFilaYColumna(Posicion posicion) {
		for (Barco barco : barcos) {
			if (barco.estaEnPosicion(posicion)) {
				return barco;
			}
		}
		return null;
	}
}
