package ejemplos.lambda.calcularPromedio;

//Para implementar una lambda debe ser una interface funcional
/*
 * 
 * Solo puede tener un metodo abstracto
 * Puede tener muchos metodos default
 * */
public interface Aritmetica {
	//Metodo abstracto
	double calcularPromedio(double x,double y);
	
	//Metodos default
	default double calcularPromedio(double x,double y,double z) {return (x+y+z)/3;}
	default double calcularSuma(double x,double y,double z) {return (x+y+z);}
}
