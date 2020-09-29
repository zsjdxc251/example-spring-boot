package com.lesson;

import static org.junit.Assert.assertTrue;

import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
        BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.upgradeEncoding(passwordEncoder.encode("123456")));
        System.out.println(passwordEncoder.upgradeEncoding(MD5Encoder.encode(passwordEncoder.encode("123456").getBytes())));
    }
}
