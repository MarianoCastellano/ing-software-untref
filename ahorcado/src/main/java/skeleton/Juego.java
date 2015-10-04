package skeleton;

import java.util.HashSet;
import java.util.Set;

public class Juego {

	private Jugador jugador;
	private String palabraSecreta;
	private Set<Character> letrasArriesgadas = new HashSet<>();

	public Juego(Jugador jugador, String palabraSecreta) {
		this.palabraSecreta = palabraSecreta.toLowerCase();
		this.jugador = jugador;
	}

	public void arriesgar(char letra) {
		for (char caracter : palabraSecreta.toCharArray()) {
			char letraArriesgadaEnMinuscula = Character.toLowerCase(letra);
			if (caracter == letraArriesgadaEnMinuscula) {
				letrasArriesgadas.add(caracter);
			}
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
			if (!letrasArriesgadas.contains(letraSecreta)) {
				estadoPalabraSecreta = estadoPalabraSecreta.replace(letraSecreta, '*');
			}
		}
		return estadoPalabraSecreta;
	}

}