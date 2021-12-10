package cn.com.soyea.zx.config;

import cn.com.soyea.zx.frame.spring.aop.Calculate;
import cn.com.soyea.zx.frame.spring.aop.TulingCalculate;
import cn.com.soyea.zx.frame.spring.aop.TulingLogInterceptor;
import cn.com.soyea.zx.frame.spring.aop.TulingMethodBeforeAdvice;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @author zx
 * @date 2021/12/3 9:46
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"cn.com.soyea.zx.frame.spring"})
public class MainConfig {
    @Bean
    public Calculate tulingCalculate() {
        return new TulingCalculate();
    }

    // Advice 方式
    @Bean
    public TulingMethodBeforeAdvice tulingLogAdvice(){
        return new TulingMethodBeforeAdvice();
    }

    // Interceptor方式 ， 类似环绕通知
    @Bean
    public TulingLogInterceptor tulingLogInterceptor() {
        return new TulingLogInterceptor();
    }

    /**
     * FactoryBean方式单个： ProxyFactoryBean
     * @return
     */
//    @Bean
//    public ProxyFactoryBean calculateProxy(){
//        ProxyFactoryBean userService=new ProxyFactoryBean();
//        userService.setInterceptorNames("tulingLogAspect");  // 根据指定的顺序执行
//        userService.setTarget(tulingCalculate());
//        return userService;
//    }

//    @Bean
//    public NameMatchMethodPointcutAdvisor tulingLogAspect(){
//        NameMatchMethodPointcutAdvisor advisor=new NameMatchMethodPointcutAdvisor();
//        // 通知(Advice)  ：是我们的通知类
//        // 通知者(Advisor)：是经过包装后的细粒度控制方式。
//        advisor.setAdvice(tulingLogAdvice());
//        advisor.setMappedNames("div");
//        return  advisor;
//    }

    @Bean
    public BeanNameAutoProxyCreator autoProxyCreator(){
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        //设置要创建代理的那些Bean的名字
        beanNameAutoProxyCreator.setBeanNames("cn.com.soyea.zx.*");
        //设置拦截链名字(这些拦截器是有先后顺序的)
        beanNameAutoProxyCreator.setInterceptorNames("tulingLogInterceptor");
        return beanNameAutoProxyCreator;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }
}
