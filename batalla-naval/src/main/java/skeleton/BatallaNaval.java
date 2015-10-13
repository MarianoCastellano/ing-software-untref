package skeleton;

import skeleton.barco.Barco;
import skeleton.barco.FabricaDeBarcos;
import skeleton.barco.Orientacion;
import skeleton.barco.TipoDeBarco;
import skeleton.tablero.PosicionBarco;
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
		if (!validarPosicion(fila, columna)) {
			return ResultadoDisparo.AGUA;
		}

		return ResultadoDisparo.BLANCO;
	}
}