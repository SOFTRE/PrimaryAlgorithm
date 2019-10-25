import com.xxm.demoClassForProxy.impl.AccountDaoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Program: IntelliJ IDEA test
 * @Description:
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-10 19:57:20 周四
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class Cglib {
    @Test
    public void fun01(){
        AccountDaoImpl accountDao = new AccountDaoImpl();

        //创建enhancer对象
        Enhancer enhancer  = new Enhancer();
        //设置代理的父类
        enhancer.setSuperclass(AccountDaoImpl.class);

        enhancer.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if("save".equals(method.getName())){
                    System.out.println("权限校验...");
                    return method.invoke(accountDao, args);
                }
                return method.invoke(accountDao, args);
            }
        });

        AccountDaoImpl accountDaoProxy = (AccountDaoImpl) enhancer.create();
        accountDaoProxy.save();
    }
}
