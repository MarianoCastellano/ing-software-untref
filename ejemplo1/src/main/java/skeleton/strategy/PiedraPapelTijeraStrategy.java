package skeleton.strategy;

import skeleton.Resultado;

public interface PiedraPapelTijeraStrategy {

	Resultado jugarContra(PiedraPapelTijeraStrategy opponentStrategy);

	Resultado jugar(PiedraStrategy piedraStrategy);

	Resultado jugar(PapelStrategy papelStrategy);

	Resultado jugar(TijeraStrategy tijeraStrategy);
}