package com.wbb.jpa.controller;

import com.wbb.jpa.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    @RequestMapping(value = "/jpa" , method = RequestMethod.GET)
    public Object test3() throws Exception {
        Pageable pageable = new PageRequest(0,2);
        return personRepository.findAll(pageable);
    }
    @RequestMapping(value = "/jpa1" , method = RequestMethod.GET)
    public Object test4(@RequestParam("name")String name) throws Exception {
        personRepository.findByName(name);
        personRepository.readByName(name);
        personRepository.getByName(name);
       return null;
    }
}
