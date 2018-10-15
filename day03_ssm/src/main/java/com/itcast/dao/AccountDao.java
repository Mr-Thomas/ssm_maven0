package com.itcast.dao;

import com.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface AccountDao {
    //查询所有
    @Select("select * from account")
    List<Account> findAll();

    //保存账户
    @Insert("insert into account values (null,#{name},#{money})")
    void saveAccount(Account account);

    //根据名称查询账户
    @Select("select * from account where name = #{name}")
    Account findAccountByName(String username);

    //修改账户
    @Update("update account set name=#{name},money=#{money} where id = #{id}")
    void updataAccount(Account account);
}
