package skeleton.barco;

import java.util.HashMap;
import java.util.Map;

public abstract class Barco {

	private int tamanio;
	private Map<Posicion, Boolean> posiciones;

	public Barco(int tamanio) {
		this.tamanio = tamanio;
		this.posiciones = new HashMap<>();
	}

	public int getTamanio() {
		return tamanio;
	}

	public void agregarPosicion(int fila, int columna) {
		this.posiciones.put(new Posicion(fila, columna), false);
	}

	public boolean estasHundido() {
		boolean estaHundido = true;
		for (boolean daniado : posiciones.values()) {
			estaHundido = estaHundido && daniado;
		}
		return estaHundido;
	}

	public boolean estaEnPosicion(Posicion posicion) {
		return posiciones.containsKey(posicion);
	}

	public void daniar(Posicion posicion) {
		posiciones.put(posicion, true);
	}
}
