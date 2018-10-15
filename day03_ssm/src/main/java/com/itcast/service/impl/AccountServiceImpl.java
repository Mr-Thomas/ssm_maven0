package com.itcast.service.impl;

import com.itcast.dao.AccountDao;
import com.itcast.domain.Account;
import com.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {
        System.out.println("业务层:findAll方法执行了。。。");
        return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println("业务层:saveAccount方法执行了。。。");
        accountDao.saveAccount(account);
    }

    public void transfer(String oldAccount, String newAccount, Double money) {
        System.out.println("业务层:stransfer方法执行了。。。");
        //根据名称查询账户
        Account oldA = accountDao.findAccountByName(oldAccount);
        Account newA = accountDao.findAccountByName(newAccount);
        //oldA账户减 100
        oldA.setMoney(oldA.getMoney() - 100);
        //newA账户加 100
        newA.setMoney(newA.getMoney() + 100);
        //保存修改
        accountDao.updataAccount(oldA);

       int i = 1 / 0;

        accountDao.updataAccount(newA);
    }

    //修改账户
    public void updataAccount(Account account) {
        accountDao.updataAccount(account);
    }
}
