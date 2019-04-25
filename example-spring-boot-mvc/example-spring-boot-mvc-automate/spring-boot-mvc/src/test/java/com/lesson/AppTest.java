package com.lesson;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.jar.JarFile;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException {


//        System.out.println(getClass().getProtectionDomain().getCodeSource());
        // URL url = new URL("file:/D:/workspace/githome/github/example-spring-boot/example-spring-boot-mvc/example-spring-boot-mvc-automate/spring-boot-mvc/target/spring-boot-mvc-1.0-SNAPSHOT.jar!/BOOT-INF/classes!/templates/jsp/index.jsp");



        URL url = new URL("file:/D:\\workspace\\githome\\github\\example-spring-boot\\example-spring-boot-mvc\\example-spring-boot-mvc-automate\\spring-boot-mvc\\target\\spring-boot-mvc-1.0-SNAPSHOT.jar");



        System.out.println(url.openConnection().getClass());

    }
}
