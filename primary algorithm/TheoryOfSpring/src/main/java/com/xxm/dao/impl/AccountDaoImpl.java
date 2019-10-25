package com.xxm.dao.impl;

import com.xxm.dao.AccountDao;

/**
 * @Program: IntelliJ IDEA test
 * @Description:
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-11 12:32:04 周五
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void save() {
        System.out.println("AccountDaoImpl-->save");
    }
}
