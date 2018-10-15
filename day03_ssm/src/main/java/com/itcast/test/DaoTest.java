package com.itcast.test;

import com.itcast.dao.AccountDao;
import com.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class DaoTest {
    /**
     * 查询所有
     * @throws Exception
     */
    @Test
    public void run02() throws Exception {
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConﬁg.xml");
        //创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        //执行方法
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        //释放资源
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 添加数据
     * @throws Exception
     */
    @Test
    public void run03() throws Exception {
        Account account = new Account();
        account.setName("李四");
        account.setMoney(3000d);
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConﬁg.xml");
        //创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        //执行方法
        dao.saveAccount(account);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        inputStream.close();
    }
}
