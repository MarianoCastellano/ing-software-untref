package skeleton;

import org.junit.Assert;
import org.junit.Test;
import skeleton.barco.Barco;
import skeleton.barco.FabricaDeBarcos;
import skeleton.barco.TipoDeBarco;

public class FabricaDeBarcosTest {

	@Test
	public void crearBarcoDeberiaCrearUnBarcoDeTamanioUno() {
		FabricaDeBarcos fabricaDeBarcos = new FabricaDeBarcos();
		Barco barco = fabricaDeBarcos.crearBarco(TipoDeBarco.ACORAZADO);

		Assert.assertEquals(1, barco.getTamanio());
	}

	@Test
	public void crearBarcoDeberiaCrearUnBarcoDeTamanioDos() {
		FabricaDeBarcos fabricaDeBarcos = new FabricaDeBarcos();
		Barco barco = fabricaDeBarcos.crearBarco(TipoDeBarco.LANCHA);

		Assert.assertEquals(2, barco.getTamanio());
	}

	@Test
	public void crearBarcoDeberiaCrearUnBarcoDeTamanioTres() {
		FabricaDeBarcos fabricaDeBarcos = new FabricaDeBarcos();
		Barco barco = fabricaDeBarcos.crearBarco(TipoDeBarco.DESTRUCTOR);

		Assert.assertEquals(3, barco.getTamanio());
	}
}
