package com.xxm.service.impl;

import com.xxm.dao.AccountDao;
import com.xxm.service.AccountService;
import org.springframework.beans.factory.BeanFactory;

/**
 * @Program: IntelliJ IDEA test
 * @Description:
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-11 12:32:43 周五
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class AccountServiceImpl implements AccountService {
    @Override
    public void save() {
        System.out.println("AccountServiceImpl-->save()");
    }
}
