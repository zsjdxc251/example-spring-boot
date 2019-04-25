package com.lesson.boot.mvc.automate;

import org.apache.catalina.webresources.AbstractArchiveResourceSet;
import org.apache.catalina.webresources.Cache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * {@code org.apache.jasper.servlet.JspServlet#serviceJspFile(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.String, boolean)}
 *
 * {@code Cache#getResource(java.lang.String, boolean)}
 *
 * {@code org.apache.catalina.webresources.CachedResource#validateResource(boolean)}
 *
 *  // 组装jar
 * {@link AbstractArchiveResourceSet#getResource(java.lang.String)}
 *
 * {@code org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory#prepareContext(org.apache.catalina.Host, org.springframework.boot.web.servlet.ServletContextInitializer[])}
 *
 * {@code org.springframework.boot.web.servlet.server.DocumentRoot#getValidDirectory()}
 *
 * @author zhengshijun
 * @version created on 2018/11/19.
 */
@SpringBootApplication(scanBasePackages = "com.lesson.boot.mvc.automate")
public class BootMvcAutomateBootstrap {

    public static void main(String[] args){


        SpringApplication.run(BootMvcAutomateBootstrap.class,args);

    }
}
