package com.wbb.jpa.repository;

import com.wbb.jpa.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    // find、findBy、read、readBy、get、getBy

    Person getByName(String name);

    Person findByName(String name);

    Person readByName(String name);


}
