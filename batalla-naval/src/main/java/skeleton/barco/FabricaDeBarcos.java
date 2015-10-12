package skeleton.barco;

import java.util.HashMap;
import java.util.Map;

public class FabricaDeBarcos {

	private Map<TipoDeBarco, Barco> tipoDeBarcoBarcoMap;

	public FabricaDeBarcos() {
		tipoDeBarcoBarcoMap = new HashMap<>();
		tipoDeBarcoBarcoMap.put(TipoDeBarco.ACORAZADO, new Acorazado(1));
		tipoDeBarcoBarcoMap.put(TipoDeBarco.LANCHA, new Lancha(2));
		tipoDeBarcoBarcoMap.put(TipoDeBarco.DESTRUCTOR, new Destructor(3));
	}

	public Barco crearBarco(TipoDeBarco tipoDeBarco) {
		return tipoDeBarcoBarcoMap.get(tipoDeBarco);
	}
}