import com.xxm.demoClassForProxy.AccountDao;
import com.xxm.demoClassForProxy.impl.AccountDaoImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Program: IntelliJ IDEA test
 * @Description:
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-10 19:59:05 周四
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class JDKProxy {

    @Test
    public void fun01(){
        AccountDao accountDao = new AccountDaoImpl();
        AccountDao proxyDao =  (AccountDao) Proxy.newProxyInstance(accountDao.getClass().getClassLoader(), accountDao.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if("save".equals(method.getName())){
                    System.out.println("权限校验...");
                    return method.invoke(accountDao,args);
                }
                return method.invoke(accountDao, args);
            }
        });
        proxyDao.save();
    }
}