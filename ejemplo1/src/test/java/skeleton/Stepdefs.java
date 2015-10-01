package skeleton;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import skeleton.strategy.PapelStrategy;
import skeleton.strategy.PiedraStrategy;
import skeleton.strategy.TijeraStrategy;

public class Stepdefs {

	private Jugador jugadorUno;
	private Jugador jugadorDos;
	private Resultado resultado;

	@Given("^jugadorUno juega PIEDRA$")
	public void jugadorUno_juega_PIEDRA() throws Throwable {
		jugadorUno = new Jugador(new PiedraStrategy());
	}

	@Given("^jugadorUno juega PAPEL$")
	public void jugadorUno_juega_PAPEL() throws Throwable {
		jugadorUno = new Jugador(new PapelStrategy());
	}

	@Given("^jugadorUno juega TIJERA")
	public void jugadorUno_juega_TIJERA() throws Throwable {
		jugadorUno = new Jugador(new TijeraStrategy());
	}

	@When("^jugadorDos juega PAPEL$")
	public void jugadorDos_juega_PAPEL() throws Throwable {
		jugadorDos = new Jugador(new PapelStrategy());
	}

	@When("^jugadorDos juega TIJERA$")
	public void jugadorDos_juega_TIJERA() throws Throwable {
		jugadorDos = new Jugador(new TijeraStrategy());
	}

	@When("^jugadorDos juega PIEDRA$")
	public void jugadorDos_juega_PIEDRA() throws Throwable {
		jugadorDos = new Jugador(new PiedraStrategy());
	}

	@Then("^gana jugadorDos$")
	public void gana_jugadorDos() throws Throwable {
		resultado = jugadorDos.jugarContra(jugadorUno);
		Assert.assertEquals(Resultado.GANA, resultado);
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
