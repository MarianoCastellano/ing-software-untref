package skeleton;

import skeleton.strategy.PiedraPapelTijeraStrategy;

public class Jugador {

	private PiedraPapelTijeraStrategy piedraPapelTijeraStrategy;

	public Jugador(PiedraPapelTijeraStrategy piedraPapelTijeraStrategy) {
		this.piedraPapelTijeraStrategy = piedraPapelTijeraStrategy;
	}

	public PiedraPapelTijeraStrategy getPiedraPapelTijeraStrategy() {
		return piedraPapelTijeraStrategy;
	}

	public Resultado jugarContra(Jugador oponente) {
		return getPiedraPapelTijeraStrategy().jugarContra(oponente.getPiedraPapelTijeraStrategy());
	}
}
