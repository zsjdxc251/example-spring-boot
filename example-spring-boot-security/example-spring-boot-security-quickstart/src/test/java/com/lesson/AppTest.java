package com.lesson;

import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.server.PathContainer;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        PathPatternParser pathPatternParser = new PathPatternParser();
        PathPattern pathPattern =  pathPatternParser.parse("/**/order/**");
//        boolean result = pathPattern.matches(new PathContainer(){
//
//            @Override
//            public String value() {
//                return null;
//            }
//
//            @Override
//            public List<Element> elements() {
//                return ImmutableList.of(()->"/api/app/order/invest/*");
//            }
//        });

        boolean result = pathPattern.matches(PathContainer.parsePath("/api/app/order/invest/3"));

        System.out.println(result);

        //AntPathMatcher antPathMatcher = new AntPathMatcher();



    }

    @Test
    public void test1(){
        AntPathMatcher antPathMatcher = new AntPathMatcher();

        System.out.println(antPathMatcher.match("/**/order/**","/api/app/order/invest/3"));
    }
}
