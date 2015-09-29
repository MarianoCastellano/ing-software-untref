package skeleton;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Stepdefs {

	private Jugador jugadorUno;
	private Jugador jugadorDos;
	private Resultado resultado;

	@Given("^jugadorUno juega PIEDRA$")
	public void jugadorUno_juega_PIEDRA() throws Throwable {
		jugadorUno = new Jugador();
		jugadorUno.elegir(Movimiento.PIEDRA);
	}

	@Given("^jugadorUno juega PAPEL$")
	public void jugadorUno_juega_PAPEL() throws Throwable {
		jugadorUno = new Jugador();
		jugadorUno.elegir(Movimiento.PAPEL);
	}

	@Given("^jugadorUno juega TIJERA")
	public void jugadorUno_juega_TIJERA() throws Throwable {
		jugadorUno = new Jugador();
		jugadorUno.elegir(Movimiento.TIJERA);
	}

	@When("^jugadorDos juega PAPEL$")
	public void jugadorDos_juega_PAPEL() throws Throwable {
		jugadorDos = new Jugador();
		jugadorDos.elegir(Movimiento.PAPEL);
	}

	@When("^jugadorDos juega TIJERA$")
	public void jugadorDos_juega_TIJERA() throws Throwable {
		jugadorDos = new Jugador();
		jugadorDos.elegir(Movimiento.TIJERA);
	}

	@When("^jugadorDos juega PIEDRA$")
	public void jugadorDos_juega_PIEDRA() throws Throwable {
		jugadorDos = new Jugador();
		jugadorDos.elegir(Movimiento.PIEDRA);
	}

	@Then("^gana jugadorDos$")
	public void gana_jugadorDos() throws Throwable {
		resultado = jugadorUno.jugarContra(jugadorDos);
		Assert.assertEquals(Resultado.PIERDE, resultado);
	}

	@Then("^hay empate")
	public void hay_empate() throws Throwable {
		resultado = jugadorUno.jugarContra(jugadorDos);
		Assert.assertEquals(Resultado.EMPATE, resultado);
	}

	@Then("^gana jugadorUno$")
	public void gana_jugadorUno() throws Throwable {
		resultado = jugadorUno.jugarContra(jugadorDos);
		Assert.assertEquals(Resultado.GANA, resultado);
	}
}
