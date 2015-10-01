package skeleton.strategy;

import skeleton.Resultado;

public class TijeraStrategy implements PiedraPapelTijeraStrategy {

	public Resultado jugarContra(PiedraPapelTijeraStrategy opponentStrategy) {
		return opponentStrategy.jugar(this);
	}

	public Resultado jugar(PapelStrategy papelStrategy) {
		return Resultado.PIERDE;
	}

	public Resultado jugar(PiedraStrategy piedraStrategy) {
		return Resultado.GANA;
	}

	public Resultado jugar(TijeraStrategy tijeraStrategy) {
		return Resultado.EMPATE;
	}
}