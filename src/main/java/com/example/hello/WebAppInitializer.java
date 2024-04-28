package com.example.hello;

import com.example.hello.config.DispatcherConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.h2.server.web.WebServlet;


public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);

        ContextLoaderListener listener = new ContextLoaderListener(rootContext);
        servletContext.addListener(listener);

        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(DispatcherConfig.class);

//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(10 * 1024 * 1024);
//        dispatcherContext.getBeanFactory().registerSingleton("multipartResolver", multipartResolver);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("H2Console", new WebServlet());
        h2ConsoleServlet.setLoadOnStartup(2);
        h2ConsoleServlet.setInitParameter("webAllowOthers", "true");
        h2ConsoleServlet.addMapping("/h2-console/*");

        FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
        filter.setInitParameter("encoding", "UTF-8");
        filter.addMappingForServletNames(null, false, "dispatcher");
    }
}