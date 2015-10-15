package skeleton;

import skeleton.barco.*;
import skeleton.tablero.PosicionBarco;
import skeleton.tablero.ResultadoDisparo;
import skeleton.tablero.Tablero;

public class BatallaNaval {

	private Tablero tablero;

	public BatallaNaval(Tablero tablero) {
		this.tablero = tablero;
	}

	public boolean validarPosicion(int fila, int columna) {
		return tablero.estaPosicionOcupada(fila, columna);
	}

	public void posicionar(TipoDeBarco tipoDeBarco, int fila, int columna, Orientacion orientacion) {
		Barco barco = new FabricaDeBarcos().crearBarco(tipoDeBarco);
		PosicionBarco posicionBarco = new PosicionBarco(barco, fila, columna, orientacion);
		tablero.posicionarBarco(posicionBarco);
	}

	public ResultadoDisparo disparar(int fila, int columna) {
		return tablero.disparar(new Posicion(fila, columna));
	}
}