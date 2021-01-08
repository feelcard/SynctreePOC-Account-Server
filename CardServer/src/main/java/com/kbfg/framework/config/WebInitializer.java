package com.kbfg.framework.config;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import com.kbfg.framework.filter.XssFilter;

/**
 * <pre>
 * 파일명     : WebConfiguration.java
 * 프로젝트  : ContentsAPI
 * 날짜        : 2020. 4. 7.
 * 작성자     : kbfg196
 * 프로그램  : web서블릿 매칭경로 설정
 * </pre>
 */
public class WebInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.setConfigLocation("com.kbfg.framework.config");
    // Processes application requests
    ServletRegistration.Dynamic dispatcher =
        servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");

    // UTF-8
    FilterRegistration.Dynamic charaterEncodingFilter =
        servletContext.addFilter("charaterEncodingFilter", new CharacterEncodingFilter());
    charaterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true,
        "/*");
    charaterEncodingFilter.setInitParameter("encoding", "UTF-8");
    charaterEncodingFilter.setInitParameter("forceEncoding", "true");

    // XSS Filter
    FilterRegistration.Dynamic xssFilter = servletContext.addFilter("xssFilter", new XssFilter());
    xssFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
  }
}
