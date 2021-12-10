package cn.com.soyea.zx.config;

import cn.com.soyea.zx.frame.spring.demo1.MyBeanFactoryPostProcessor;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author zx
 * @date 2021/12/3 17:09
 */
@Configuration
public class SpringApplicationContextInitializer implements ApplicationContextInitializer {


    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        MyBeanFactoryPostProcessor myBeanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        applicationContext.addBeanFactoryPostProcessor(myBeanFactoryPostProcessor);
    }
}
