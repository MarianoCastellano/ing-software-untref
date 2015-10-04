package skeleton;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Stepdefs {

	private Juego juego = null;

	@Given("^la palabra secreta es \"(.*?)\"$")
	public void la_palabra_secreta_es_auto(String palabraSecreta) throws Throwable {
		juego = new Juego(new Jugador(), palabraSecreta);
	}

	@When("^arriesgo \"(.*?)\"$")
	public void arriesgo_a(char letra) throws Throwable {
		juego.arriesgar(letra);
	}

	@Then("^estado es \"(.*?)\"$")
	public void estado_es(String estado) throws Throwable {
		Assert.assertEquals(estado, juego.getEstado());
	}

	@And("^me quedan (\\d+) vidas$")
	public void me_quedan_7_vidas(int vidas) throws Throwable {
		Assert.assertEquals(vidas, juego.getVidaDelJugador());
	}
}
