package cn.com.soyea.zx.frame.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author zx
 * @date 2021/12/3 9:37
 */
public class TestDemo {
    public static void main(String[] args) {
        //use xml load bean
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        //use annotion load bean
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //
    }
}
