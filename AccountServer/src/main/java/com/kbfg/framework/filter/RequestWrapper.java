/**
 * 
 */
package com.kbfg.framework.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 파일명     : RequestWrapper.java
 * 프로젝트  : ContentApi
 * 날짜        : 2020. 11. 11.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 11. 11.     	|	   kbfg196       	|                             |	
 * ===============================================================================
 * </pre>
 */
public class RequestWrapper extends HttpServletRequestWrapper {
  private static final Logger logger = LoggerFactory.getLogger(RequestWrapper.class);

  public RequestWrapper(HttpServletRequest servletRequest) {
    super(servletRequest);
  }

  public String[] getParameterValues(String parameter) {
    String[] values = super.getParameterValues(parameter);
    if (values == null) {
      return null;
    }
    int count = values.length;
    String[] encodedValues = new String[count];
    for (int i = 0; i < count; i++) {
      encodedValues[i] = cleanXSS(values[i]);
    }
    return encodedValues;
  }

  public String getParameter(String parameter) {
    String value = super.getParameter(parameter);
    if (value == null) {
      return null;
    }
    return cleanXSS(value);
  }

  public String getHeader(String name) {
    String value = super.getHeader(name);
    if (value == null) {
      return null;
    }
    return cleanXSS(value);
  }

  private String cleanXSS(String value) {
    value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
    value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
    value = value.replaceAll("'", "& #39;");
    value = value.replaceAll("eval\\((.*)\\)", "");
    value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
    value = value.replaceAll("script", "");
    return value;
  }
}
