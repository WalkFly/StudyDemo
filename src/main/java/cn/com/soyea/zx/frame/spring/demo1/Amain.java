package cn.com.soyea.zx.frame.spring.demo1;

import cn.com.soyea.zx.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author zx
 * @date 2021/12/3 9:59
 */
public class Amain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
//        Car card = applicationContext.getBean("car", Car.class);
    }
}
