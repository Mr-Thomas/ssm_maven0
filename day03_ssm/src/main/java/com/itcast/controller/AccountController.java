package com.itcast.controller;

import com.itcast.domain.Account;
import com.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层:查询所有账号。。。");
        List<Account> list = accountService.findAll();
        model.addAttribute("listt", list);
        for (Account account : list) {
            System.out.println(account);
        }
        return "list";
    }
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("表现层:保存用户执行了。。。");
        accountService.saveAccount(account);
        System.out.println(account.getName() + "的账户有:" + account.getMoney());
        return "list";
    }
    @RequestMapping("/transfer")
    public String transfer(String oldAccount, String newAccount, Double money) {
        System.out.println("表现层:转账执行了。。。");
        accountService.transfer(oldAccount, newAccount, money);
        System.out.println(oldAccount + "给" + newAccount + "转账了" + money);
        return "list";
    }
    //没有返回值 默认跳转 跳转到account/initUpdat.jsp 页面
    @RequestMapping("/initUpdat")
    public void initUpdate() {
        System.out.println("initUpdate默认页面执行...");
    }
    @RequestMapping("/textDemo")
    public void textDemo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/list.jsp").forward(request, response);
        System.out.println("textDemo--请求转发--执行....");
    }
    @RequestMapping("/springForward") //SpringMVC提供的请求转发(返回String类型)
    public String springForward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("springForward--请求转发--执行....");
        return "forward:/WEB-INF/pages/list.jsp";
        //不走视图解析器了，所以需要编写完整的路径
//        return "forward:/aaa.jsp";
    }
    @RequestMapping("/textDemo1")
    public void textDemo1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("/aaa.jsp").forward(request, response);
        System.out.println("textDemo1--请求转发--执行....");
    }
    //重定向到jsp页面，则jsp页面不能写在 WEB-INF 目录中，否则无法找到
    @RequestMapping("/textDemo01")
    public void textDemo01(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.sendRedirect(request.getContextPath() + "/WEB-INF/pages/list.jsp");//错误
        System.out.println("textDemo01--重定向--执行....");
    }
    @RequestMapping("/springRedirect") //SpringMVC提供的重定向(返回String类型)
    public String springRedirect(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("textDemo02--重定向--执行....");
        return "redirect:/aaa.jsp";//正确
        //return "redirect:"+request.getContextPath()+"/aaa.jsp";错误写法,不用加虚拟路径(工程名)框架底层 帮忙加了
    }
    @RequestMapping("/textDemo02")
    public void textDemo02(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.sendRedirect(request.getContextPath() + "/aaa.jsp");
        System.out.println("textDemo02--重定向--执行....");
    }
    @RequestMapping("/writeDemo")
    public void writeDemo(HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("您好!!!");
    }
    //返回值ModelAndView
    @RequestMapping("/findAll01")
    public ModelAndView findAll01() {
        ModelAndView mv = new ModelAndView();
        //返回视图
        mv.setViewName("findAll");
        List<Account> list = accountService.findAll();
        System.out.println(list);
        //返回数据
        mv.addObject("aaa", list);
        return mv;
    }
}
