package mx.sam.estructural.flyweight.bosque.clasesflyweight;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import mx.sam.estructural.flyweight.bosque.model.*;

public class ArbolFlyweight {
	static Map<String, TipoArbol> tiposArboles = new HashMap<>();

    public static TipoArbol getTipoArbol(String name, Color color, String otherTreeData) {
    	TipoArbol result = tiposArboles.get(name);
        if (result == null) {
            result = new TipoArbol(name, color, otherTreeData);
            tiposArboles.put(name, result);
        }
        return result;
    }
}
