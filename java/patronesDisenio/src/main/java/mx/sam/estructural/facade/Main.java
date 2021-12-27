package mx.sam.estructural.facade;

import mx.sam.estructural.facade.clasesfacade.FigurasFacade;

public class Main {

	public static void main(String[] args) {
	      FigurasFacade figuraFacade = new FigurasFacade();

	      figuraFacade.dibujarCirculo();
	      figuraFacade.dibujarCuadrado();
	      figuraFacade.dibujarTriangulo();
	}

}
