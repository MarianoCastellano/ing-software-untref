package skeleton;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import skeleton.barco.Orientacion;
import skeleton.barco.TipoDeBarco;
import skeleton.tablero.Tablero;

public class Stepdefs {

	private BatallaNaval batallaNaval;
	private ResultadoDisparo resultadoDisparo;

	@Before
	public void before() {
		Tablero tablero10x10 = new Tablero(10, 10);
		batallaNaval = new BatallaNaval(tablero10x10);
	}

	@Given("^posicion (\\d+),(\\d+) esta libre y posicion (\\d+),(\\d+) esta libre$")
	public void posicion_esta_libre_y_posicion_esta_libre(int fila1, int columna1, int fila2, int columna2) {
		boolean hayBarcosFila1Columna1 = batallaNaval.validarPosicion(fila1, columna1);
		boolean hayBarcosFila2Columna2 = batallaNaval.validarPosicion(fila2, columna2);

		Assert.assertFalse(hayBarcosFila1Columna1);
		Assert.assertFalse(hayBarcosFila2Columna2);
	}

	@When("^jugador posiciona un \"(.*?)\" en la posicion (\\d+),(\\d+) \"(.*?)\"$")
	public void jugador_posiciona_un_en_la_posicion(TipoDeBarco tipoDeBarco, int fila, int columna,
			Orientacion orientacion) throws Exception {
		batallaNaval.posicionar(tipoDeBarco, fila, columna, orientacion);
	}

	@Then("^barco posicionado exitosamente$")
	public void barco_posicionado_exitosamente() {
		Assert.assertTrue(batallaNaval.validarPosicion(1, 1));
	}

	@Given("^hay un barco en posicion (\\d+),(\\d+)$")
	public void hay_un_barco_en_posicion(int fila, int columna) throws Throwable {
		batallaNaval.posicionar(TipoDeBarco.ACORAZADO, fila, columna, Orientacion.HORIZONTAL);
	}

	@Then("^posicion ocupada no se puede ubicar el barco alli$")
	public void posicion_ocupada_no_se_puede_ubicar_el_barco_alli() throws Throwable {
		Assert.assertTrue(batallaNaval.validarPosicion(1, 1));
	}

	@Then("^posicion intermedia ocupada no se puede ubicar el barco alli$")
	public void posicion_intermedia_ocupada_no_se_puede_ubicar_el_barco_alli() throws Throwable {
		Assert.assertTrue(batallaNaval.validarPosicion(2, 6));
	}

	@Given("^no hay barcos en posicion (\\d+),(\\d+)$")
	public void no_hay_barcos_en_posicion(int fila, int columna) throws Throwable {
		boolean validarPosicion = batallaNaval.validarPosicion(fila, columna);
		Assert.assertFalse(validarPosicion);
	}

	@When("^disparo a la posicion (\\d+),(\\d+)$")
	public void disparo_a_la_posicion(int fila, int columna) throws Throwable {
		resultadoDisparo = batallaNaval.disparar(fila, columna);
	}

	@Then("^el disparo dio en el agua$")
	public void el_disparo_dio_en_el_agua() throws Throwable {
		Assert.assertEquals(resultadoDisparo, ResultadoDisparo.AGUA);
	}

	@Then("^el disparo dio en el blanco")
	public void el_disparo_dio_en_el_blanco() throws Throwable {
		Assert.assertEquals(resultadoDisparo, ResultadoDisparo.BLANCO);
	}

}