package mx.sam.comportamiento.iterator.tienda.model;

import mx.sam.comportamiento.iterator.tienda.clasesiterator.Container;
import mx.sam.comportamiento.iterator.tienda.clasesiterator.MiIterator;

public class CatalogoDepartamento implements Container {
	public String departamentos[] = { "Perfumeria", "Juguetes", "Limpieza", "Alimentos" };

	@Override
	public MiIterator getIterator() {
		return new DepartamentoIterator();
	}

	private class DepartamentoIterator implements MiIterator {
		int index;

		@Override
		public boolean hasNext() {
			if (index < departamentos.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if (this.hasNext()) {
				return departamentos[index++];
			}
			return null;
		}
	}
}
