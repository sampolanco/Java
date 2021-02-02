package mx.com.springBoot.interceptors;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ClienteInterceptor implements HandlerInterceptor{
	private static final Logger logger=LoggerFactory.getLogger(ClienteInterceptor.class);

	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	    logger.info("Interceptor preHandle de cliente");
	    Instant inicio=Instant.now();
	    request.setAttribute("inicio", inicio);
	    Thread.sleep(3000);
	    
	    boolean error=false;
	    if(error) {
		    response.sendRedirect(request.getContextPath()+"/login");
	    }
	    return !error;
	}
	
	public void postHandle(HttpServletRequest request,  
			HttpServletResponse response,Object handler,  
			ModelAndView modelAndView) throws Exception {
	    logger.info("Interceptor postHandle de cliente");
	    Instant inicio=(Instant)request.getAttribute("inicio");
	    Instant fin=Instant.now();
	    logger.info("Tiempo entre inicio y fin= "+ Duration.between(inicio, fin).getNano() + " Nanosegundos");
	    

	}
	
}
