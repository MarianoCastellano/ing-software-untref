package skeleton.barco;

public abstract class Barco {

	private int tamanio;

	public Barco(int tamanio) {
		this.tamanio = tamanio;
	}

	public int getTamanio() {
		return tamanio;
	}
}
