package model.escuela;

//Para implementar una lambda debe ser una interface funcional
/*
 * 
 * Solo puede tener un metodo abstracto
 * Puede tener muchos metodos default
 * */
public interface Aritmetica {
	//Metodo abstracto
	double calcularAreaCirculo(double radio);
	
	//Metodos default
	default double calcularPromedio(double x,double y,double z) {return (x+y+z)/3;}
	default double calcularSuma(double x,double y,double z) {return (x+y+z);}
}
