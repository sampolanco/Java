package mx.sam.estructural.decorator.archivo.clasesdecorator;

import mx.sam.estructural.decorator.archivo.service.MyDataSource;

public class DataSourceDecorator implements MyDataSource{
	private MyDataSource dataSource;

    DataSourceDecorator(MyDataSource dataSource) {
        this.dataSource = dataSource;
    }
    
	@Override
	public void escribirDato(String dato) {
		dataSource.escribirDato(dato);
		
	}

	@Override
	public String leerDato() {
		return dataSource.leerDato();
	}

}
