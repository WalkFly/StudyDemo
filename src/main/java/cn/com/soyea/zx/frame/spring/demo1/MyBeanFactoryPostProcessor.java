package cn.com.soyea.zx.frame.spring.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 扩展类
 *
 * @author zx
 * @date 2021/12/3 17:10
 */
@Slf4j
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        log.info("MyBeanFactoryPostProcessor ....postProcessBeanFactory ");
        //当前已经完成初始化的beanFactory
        int count = configurableListableBeanFactory.getBeanDefinitionCount();
        log.info("当前beanFactory中有："+count+"个bean的定义信息，分别是如下：");
        String[] names = configurableListableBeanFactory.getBeanDefinitionNames();
        log.info(String.valueOf(Arrays.asList(names)));
    }
}
