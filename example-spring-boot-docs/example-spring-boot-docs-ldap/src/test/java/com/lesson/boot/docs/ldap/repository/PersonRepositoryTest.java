package com.lesson.boot.docs.ldap.repository;

import com.alibaba.fastjson.JSON;
import com.lesson.boot.docs.ldap.DocsLdapBootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DocsLdapBootstrap.class)
public class PersonRepositoryTest {


	@Autowired
	private PersonRepository repository;


	@Test
	public void test(){

		repository.findAll().forEach(person -> {

			System.out.println(JSON.toJSONString(person));
		});

	}



}