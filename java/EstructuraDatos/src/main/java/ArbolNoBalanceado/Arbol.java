package ArbolNoBalanceado;

public class Arbol {
	private Nodo root;
	public void agregarNodo(Integer dato) {
		if(root==null)
			root=new Nodo(dato);
		else
			agregarNodo(dato,root);
	}
	
	public Integer getMinimo() {
		if(root==null) return null;
		return getMinimo(root).getDato();
	}
	
	public Integer getMaximo() {
		if(root==null) return null;
		return getMaximo(root).getDato();
	}
	public void recorrerInOrden() {
		if(root==null) return;
		recorrerInOrden(root);
	}
	
	public Integer getSuma() {
		return getSuma(root);
	}
	private Integer getSuma(Nodo nodo) {
		Integer suma=0;
		if(nodo.getIzquierdo()!=null)
			suma+=getSuma(nodo.getIzquierdo());
		if(nodo.getDerecho()!=null)
			suma+=getSuma(nodo.getDerecho());
		
		System.out.println(nodo.getDato() +" sumando a " + suma);
		suma+=nodo.getDato();
		return suma;
	}
	//Recorrer inOrden (Izquierda,Nodo,Derecha
	private void recorrerInOrden(Nodo nodo) {
		if(nodo.getIzquierdo()!=null)
			recorrerInOrden(nodo.getIzquierdo());
		//En este punto, ya se recorrieron los nodos izquierdos
		System.out.print(nodo.getDato()+"-->");
		if(nodo.getDerecho()!=null)
			recorrerInOrden(nodo.getDerecho());
	}
	private Nodo getMinimo(Nodo nodo) {
		if(nodo.getIzquierdo()!=null)
			return getMinimo(nodo.getIzquierdo());
		else
			return nodo;
	}
	private Nodo getMaximo(Nodo nodo) {
		if(nodo.getDerecho()!=null)
			return getMaximo(nodo.getDerecho());
		else
			return nodo;
	}
	private void agregarNodo(Integer dato,Nodo nodo) {
		if(dato.compareTo(nodo.getDato())<0) {
			//Si el dato es menor que el nodo agregar a la izquierda
			if(nodo.getIzquierdo()!=null)
				agregarNodo(dato,nodo.getIzquierdo());
			else
				nodo.setIzquierdo(new Nodo(dato));
			return;
		}
		else if(dato.compareTo(nodo.getDato())>0) {
			//Si el dato es mayor que el nodo agregar a la izquierda
			if(nodo.getDerecho()!=null)
				agregarNodo(dato,nodo.getDerecho());
			else
				nodo.setDerecho(new Nodo(dato));
			return;		
		}
		else return;
	}
}
