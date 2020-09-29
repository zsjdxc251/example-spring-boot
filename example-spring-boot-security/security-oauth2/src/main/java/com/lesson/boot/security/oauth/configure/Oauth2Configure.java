package com.lesson.boot.security.oauth.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

/**
 * @author zhengshijun
 * @version created on 2020/9/29.
 */
public class Oauth2Configure {

//	@Bean
//	public KeyPair keyPair() {
//
//
//		//从classpath下的证书中获取秘钥对
//		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "123456".toCharArray());
//		return keyStoreKeyFactory.getKeyPair("jwt", "123456".toCharArray());
//	}

	@Bean
	JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withJwkSetUri("classpath:x.pug").build();
	}
}
