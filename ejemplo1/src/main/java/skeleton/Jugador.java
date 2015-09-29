package skeleton;

public class Jugador {

	private Movimiento movimiento;

	public void elegir(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public Resultado jugarContra(Jugador adversario) {
		if (getMovimiento().equals(adversario.getMovimiento())) {
			return Resultado.EMPATE;
		}

		if (getMovimiento().equals(Movimiento.PIEDRA)) {
			if (adversario.getMovimiento().equals(Movimiento.PAPEL)) {
				return Resultado.PIERDE;
			} else {
				return Resultado.GANA;
			}
		}

		if (getMovimiento().equals(Movimiento.PAPEL)) {
			if (adversario.getMovimiento().equals(Movimiento.PIEDRA)) {
				return Resultado.GANA;
			} else {
				return Resultado.PIERDE;
			}
		}

		if (getMovimiento().equals(Movimiento.TIJERA)) {
			if (adversario.getMovimiento().equals(Movimiento.PIEDRA)) {
				return Resultado.PIERDE;
			} else {
				return Resultado.GANA;
			}
		}

		return null;
	}
}
