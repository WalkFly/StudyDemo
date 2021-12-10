package cn.com.soyea.zx.frame.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 * @author zx
 * @date 2021/12/9 13:49
 */
public class TulingMethodBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        String methodName = method.getName();
        System.out.println("执行目标方法【"+methodName+"】的<前置通知>,入参"+ Arrays.asList(args));
    }
}
