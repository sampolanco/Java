package mx.com.springBoot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import mx.com.springBoot.interceptors.ClienteInterceptor;

@Configuration
public class InterceptoresConfig implements WebMvcConfigurer {

	@Autowired
	ClienteInterceptor clienteInterceptor;
	
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//registry.addInterceptor(clienteInterceptor).addPathPatterns("/cliente/**");
	}

}
