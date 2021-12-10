package cn.com.soyea.zx.frame.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * TODO
 *
 * @author zx
 * @date 2021/12/9 13:50
 */
public class TulingLogInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(getClass()+"调用方法前");
        Object ret=invocation.proceed();
        System.out.println(getClass()+"调用方法后");
        return ret;
    }
}
