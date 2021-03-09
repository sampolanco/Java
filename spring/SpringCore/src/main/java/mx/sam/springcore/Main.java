package mx.sam.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.sam.springcore.beans.AlumnoBean;
import mx.sam.springcore.controller.AlumnoController;
import mx.sam.springcore.service.AlumnoService;

public class Main {

	public static void main(String[] args) {
		//resources\META-INF
		ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        AlumnoBean alumno = ctx.getBean("alumnoBean", AlumnoBean.class);
        AlumnoController alumnoController = ctx.getBean("alumnoController", AlumnoController.class);
        AlumnoService alumnoService = ctx.getBean("alumnoService", AlumnoService.class);

        System.out.println(alumno.getNombre());
        alumnoController.guardarAlumno(null);
        alumnoService.guardarAlumno(null);
	}

}
