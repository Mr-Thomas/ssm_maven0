package com.itcast.test;

import com.itcast.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {
    @Test
    public void run01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService as = ac.getBean("accountService", AccountService.class);
        as.transfer("张三","李四",100d);
    }
}
