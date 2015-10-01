package skeleton.strategy;

import skeleton.Resultado;

public class PapelStrategy implements PiedraPapelTijeraStrategy {

	public Resultado jugarContra(PiedraPapelTijeraStrategy oponenteStrategy) {
		return oponenteStrategy.jugar(this);
	}

	public Resultado jugar(PiedraStrategy piedraStrategy) {
		return Resultado.PIERDE;
	}

	public Resultado jugar(PapelStrategy papelStrategy) {
		return Resultado.EMPATE;
	}

	public Resultado jugar(TijeraStrategy tijeraStrategy) {
		return Resultado.GANA;
	}
}