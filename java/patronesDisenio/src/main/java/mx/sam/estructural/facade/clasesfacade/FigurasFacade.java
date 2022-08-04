package mx.sam.estructural.facade.clasesfacade;

import mx.sam.estructural.facade.service.*;

public class FigurasFacade {
	   private Figura circulo;
	   private Figura triangulo;
	   private Figura cuadrado;

	   public FigurasFacade() {
		   circulo = new Circulo();
		   triangulo = new Triangulo();
		   cuadrado = new Cuadrado();
	   }

	   public void dibujarCirculo(){
		   circulo.dibujar();
	   }
	   public void dibujarTriangulo(){
		   triangulo.dibujar();
	   }
	   public void dibujarCuadrado(){
		   cuadrado.dibujar();
	   }
}
