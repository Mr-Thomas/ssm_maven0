package com.itcast.service;

import com.itcast.domain.Account;

import java.util.List;

public interface AccountService {
    //查询所有
    List<Account> findAll();

    //保存账户
    void saveAccount(Account account);

    //转账操作
    void transfer(String oldAccount,String newAccount,Double money);
    //修改账户
    void updataAccount(Account account);
}
