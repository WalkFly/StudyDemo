package cn.com.soyea.zx.frame.spring.demo1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 *
 * @author zx
 * @date 2021/12/6 16:01
 */
@Component
public class BeanPostPrcessorDemo implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "---postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "---postProcessAfterInitialization");
        return bean;
    }
}
