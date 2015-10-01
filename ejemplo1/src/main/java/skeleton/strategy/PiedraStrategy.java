package skeleton.strategy;

import skeleton.Resultado;

public class PiedraStrategy implements PiedraPapelTijeraStrategy {

	public Resultado jugarContra(PiedraPapelTijeraStrategy opponentStrategy) {
		return opponentStrategy.jugar(this);
	}

	public Resultado jugar(PiedraStrategy piedraStrategy) {
		return Resultado.EMPATE;
	}

	public Resultado jugar(PapelStrategy papelStrategy) {
		return Resultado.GANA;
	}

	public Resultado jugar(TijeraStrategy tijeraStrategy) {
		return Resultado.PIERDE;
	}
}