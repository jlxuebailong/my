package com.my.ejb.ch02;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 * Created by gavin on 2020/12/21.
 */
@Stateless
public class HelloServiceBean implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }

}
