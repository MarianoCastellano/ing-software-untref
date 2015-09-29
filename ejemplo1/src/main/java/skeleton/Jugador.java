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
			return compararMovimientos(adversario.getMovimiento(), Movimiento.PAPEL);
		}

		if (getMovimiento().equals(Movimiento.PAPEL)) {
			return compararMovimientoAdversarioConPiedra(adversario.getMovimiento());
		}

		if (getMovimiento().equals(Movimiento.TIJERA)) {
			return compararMovimientos(adversario.getMovimiento(), Movimiento.PIEDRA);
		}

		return null;
	}

	private Resultado compararMovimientoAdversarioConPiedra(Movimiento movimientoAdversario) {
		if (movimientoAdversario.equals(Movimiento.PIEDRA)) {
			return Resultado.GANA;
		} else {
			return Resultado.PIERDE;
		}
	}

	private Resultado compararMovimientos(Movimiento movimientoAdversario, Movimiento movimientoAComparar) {
		if (movimientoAdversario.equals(movimientoAComparar)) {
			return Resultado.PIERDE;
		} else {
			return Resultado.GANA;
		}
	}
}
