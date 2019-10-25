package com.xxm.demoClassForProxy.impl;

import com.xxm.demoClassForProxy.AccountDao;

/**
 * @Program: IntelliJ IDEA test
 * @Description:
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-11 12:23:12 周五
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void save() {
        System.out.println("AccountDaoImpl-->save()");
    }
}
