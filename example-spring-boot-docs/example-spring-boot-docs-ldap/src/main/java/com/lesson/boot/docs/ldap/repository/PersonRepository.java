package com.lesson.boot.docs.ldap.repository;

import com.lesson.boot.docs.ldap.entity.Person;
import org.springframework.data.repository.CrudRepository;

import javax.naming.Name;

/**
 * @author zhengshijun
 * @version created on 2019/6/19.
 */
public interface PersonRepository extends CrudRepository<Person, Name> {
}
