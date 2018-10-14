package com.itheima.text;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DaoTest {
    @Test
    public void DaoDemo(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao dao = ac.getBean(AccountDao.class);
        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
