package com.lesson;

import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.text.ExtendedMessageFormat;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue(){
        ExtendedMessageFormat format = new ExtendedMessageFormat("12312---{user}");
       System.out.println( format.format(ImmutableMap.of("user","12312")));;

    }
}
