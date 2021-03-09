package mx.sam.springcore.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutsComunes {
	
	// Todos los metodos guardarAlumno
	@Pointcut("execution(* guardarAlumno(..))") 
	private void guardarAlumno() {
		System.out.println("Pointcut todos los metodos guardarAlumno");
	} 
	
    @Pointcut("within(mx.sam.springcore.controller..*)")
    public void inControllerLayer() {
    	System.out.println("Pointcut en la capa Controller");
    }

    @Pointcut("within(mx.sam.springcore.service..*)")
    public void inServiceLayer() {
    	System.out.println("Pointcut en la capa Service");
    }

    @Pointcut("within(mx.sam.springcore.dao..*)")
    public void inDataAccessLayer() {
    	System.out.println("Pointcut en la capa DAO");
    }

    /**
     * A business service is the execution of any method defined on a service
     * interface. This definition assumes that interfaces are placed in the
     * "service" package, and that implementation types are in sub-packages.
     *
     * If you group service interfaces by functional area (for example,
     * in packages com.xyz.myapp.abc.service and com.xyz.myapp.def.service) then
     * the pointcut expression "execution(* com.xyz.myapp..service.*.*(..))"
     * could be used instead.
     *
     * Alternatively, you can write the expression using the 'bean'
     * PCD, like so "bean(*Service)". (This assumes that you have
     * named your Spring service beans in a consistent fashion.)
     */
    @Pointcut("execution(* mx.sam.springcore.service.*.*(..))")
    public void businessService() {
    	System.out.println("Pointcut businessService");
    }

    /**
     * A data access operation is the execution of any method defined on a
     * dao interface. This definition assumes that interfaces are placed in the
     * "dao" package, and that implementation types are in sub-packages.
     */
    @Pointcut("execution(* mx.sam.springcore.dao.*.*(..))")
    public void dataAccessOperation() {
    	System.out.println("Pointcut dataAccessOperation");
    }
}
