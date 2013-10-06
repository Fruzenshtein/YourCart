package com.yc.init;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {
	
	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebAppConfig.class);
		servletContext.addListener(new ContextLoaderListener(ctx));
		
		//=============Filter registration================
		registerSecurityFilterChainFilter(servletContext);
		registerCharacterEncodingFilter(servletContext);
		registerHiddenHttpMethodFilter(servletContext);		
		   
		ctx.setServletContext(servletContext);	
		
		Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
	
	private void registerSecurityFilterChainFilter(ServletContext servletContext) {
		FilterRegistration.Dynamic fr = servletContext
				.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
		fr.addMappingForUrlPatterns(null, false, "/*");

	}
	
	private void registerCharacterEncodingFilter(ServletContext servletContext) {
		FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter",  
			      new CharacterEncodingFilter());
		fr.setInitParameter("encoding", "UTF-8");
		fr.setInitParameter("forceEncoding", "true");
		fr.addMappingForUrlPatterns(null, true, "/*");
	}
	
	private void registerHiddenHttpMethodFilter(ServletContext servletContext) {
		FilterRegistration.Dynamic fr = servletContext
				.addFilter("hiddenHttpMethodFilter", HiddenHttpMethodFilter.class);
		fr.addMappingForServletNames(
				EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), 
				false, 
				DISPATCHER_SERVLET_NAME);
	}

}
