package skeleton;

import org.junit.Assert;
import org.junit.Test;
import skeleton.barco.Barco;
import skeleton.barco.FabricaDeBarcos;
import skeleton.barco.Orientacion;
import skeleton.barco.TipoDeBarco;
import skeleton.tablero.PosicionBarco;
import skeleton.tablero.Tablero;

public class TableroTest {

	@Test
	public void estaPosicionOcupadaDeberiaDevolverQueNoHayPosicionOcupada() {
		Tablero tablero = new Tablero(10, 10);
		boolean validarPosicion = tablero.estaPosicionOcupada(1, 1);

		Assert.assertFalse(validarPosicion);
	}

	@Test
	public void posicionarBarcoHorizontalDeberiaOcuparPosicionLibre() throws Exception {
		Tablero tablero = new Tablero(10, 10);
		Barco barco = new FabricaDeBarcos().crearBarco(TipoDeBarco.ACORAZADO);
		PosicionBarco posicionBarco = new PosicionBarco(barco, 1, 1, Orientacion.HORIZONTAL);
		tablero.posicionarBarco(posicionBarco);
		boolean validarPosicion = tablero.estaPosicionOcupada(1, 1);

		Assert.assertTrue(validarPosicion);
	}

	@Test
	public void posicionarBarcoVerticalDeberiaOcuparPosicionLibre() throws Exception {
		Tablero tablero = new Tablero(10, 10);
		Barco barco = new FabricaDeBarcos().crearBarco(TipoDeBarco.ACORAZADO);
		PosicionBarco posicionBarco = new PosicionBarco(barco, 2, 2, Orientacion.VERTICAL);
		tablero.posicionarBarco(posicionBarco);
		boolean validarPosicion = tablero.estaPosicionOcupada(2, 2);

		Assert.assertTrue(validarPosicion);
	}

	@Test
	public void posicionarBarcoDeberiaNoOcuparPosicionLibre() throws Exception {
		Tablero tablero = new Tablero(10, 10);
		Barco barco = new FabricaDeBarcos().crearBarco(TipoDeBarco.ACORAZADO);
		PosicionBarco posicionBarco = new PosicionBarco(barco, 2, 2, Orientacion.VERTICAL);
		tablero.posicionarBarco(posicionBarco);
		boolean validarPosicion = tablero.estaPosicionOcupada(1, 1);

		Assert.assertFalse(validarPosicion);
	}

	@Test
	public void posicionarBarcoEnLugarOcupadoDeberiaSaltarExceptionDeLugarOcupado() throws Exception {
		Tablero tablero = new Tablero(10, 10);
		Barco barco = new FabricaDeBarcos().crearBarco(TipoDeBarco.ACORAZADO);
		PosicionBarco posicionBarco = new PosicionBarco(barco, 1, 1, Orientacion.VERTICAL);
		PosicionBarco posicionBarco2 = new PosicionBarco(barco, 1, 1, Orientacion.VERTICAL);

		tablero.posicionarBarco(posicionBarco);
		tablero.posicionarBarco(posicionBarco2);

		Assert.assertTrue(tablero.estaPosicionOcupada(1, 1));
	}

}