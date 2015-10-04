package skeleton;

import java.util.HashSet;
import java.util.Set;

public class Juego {

	private Jugador jugador;
	private String palabraSecreta;
	private Set<String> letrasArriesgadas = new HashSet<>();

	public Juego(Jugador jugador, String palabraSecreta) {
		this.palabraSecreta = palabraSecreta.toLowerCase();
		this.jugador = jugador;
	}

	public void arriesgar(String letra) {
		String letraEnMinuscula = letra.toLowerCase();
		letrasArriesgadas.add(letraEnMinuscula);

		if (!palabraSecreta.contains(letraEnMinuscula)) {
			jugador.decrementarVidas();
		}
	}

	public int getVidaDelJugador() {
		return jugador.getVidas();
	}

	public String getEstado() {
		return calcularEstado();
	}

	private String calcularEstado() {
		String estadoPalabraSecreta = new String(palabraSecreta);

		for (char letraSecreta : estadoPalabraSecreta.toCharArray()) {
			if (!letrasArriesgadas.contains(Character.toString(letraSecreta))) {
				estadoPalabraSecreta = estadoPalabraSecreta.replace(letraSecreta, '*');
			}
		}
		return estadoPalabraSecreta;
	}

}