package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("findAll");
        List<Account> accounts = accountService.findAll();
        modelAndView.addObject("list", accounts);
        return modelAndView;
    }

    @RequestMapping("/testDemo")
    public String testDemo() {
        System.out.println("测试方法...");
        return "success";
    }
    @RequestMapping("/findOne")
    public String findOne(@RequestParam(value = "username") String name, Model model){
        System.out.println(name);
        Account account = accountService.findOne(name);
        model.addAttribute("one",account);
        return "success";
    }
}
