package com.xxM.test;

import com.xxm.service.AccountService;
import com.xxm.utils.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Program: IntelliJ IDEA test
 * @Description:
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-11 12:47:58 周五
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class FactoryTest {
    public static void main(String[] args) {
            AccountService accountService= (AccountService) BeanFactory.getBeans("accountService");
            accountService.save();
    }
}
