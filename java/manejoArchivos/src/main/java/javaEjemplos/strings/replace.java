package javaEjemplos.strings;

public class replace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String original="\\basketSEDOFEM/CHIHUAHUA/251-2004/251-2004_10.pdf";
		String nuevo=original.replace("/basketSEDOFEM", "/WbasketSEDOFEM").replace("\\basketSEDOFEM", "\\WbasketSEDOFEM");
		System.out.println(nuevo);
	}

}
