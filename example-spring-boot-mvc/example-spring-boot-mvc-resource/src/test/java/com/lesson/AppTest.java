package com.lesson;

import static org.junit.Assert.assertTrue;

import com.lesson.boot.mvc.resource.BootMvcResourceBootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@RunWith(SpringRunner.class)
@SpringBootTest(classes =BootMvcResourceBootstrap.class)
public class AppTest 
{
    @Autowired
    private ResourceUrlProvider resourceUrlProvider;
    @Test
    public void shouldAnswerWithTrue()
    {


        String path = resourceUrlProvider.getForLookupPath("/jquery.js");
        System.out.println(path);
    }

    @Test
    public void test1()throws Exception{

        System.out.println(URLEncoder.encode("1.0.0/js/lib/jquery.js", StandardCharsets.UTF_8.displayName()));
    }
}
