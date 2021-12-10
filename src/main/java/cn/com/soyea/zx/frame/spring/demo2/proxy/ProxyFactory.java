package cn.com.soyea.zx.frame.spring.demo2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author zx
 * @date 2021/12/7 14:11
 */
public class ProxyFactory {
    private Object target;// 维护一个目标对象

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");

                        // 执行目标对象方法
                        Object returnValue = method.invoke(target, args);

                        System.out.println("提交事务");
                        return null;
                    }
                });
    }
}
