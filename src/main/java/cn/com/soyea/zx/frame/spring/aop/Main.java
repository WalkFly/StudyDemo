package cn.com.soyea.zx.frame.spring.aop;

import cn.com.soyea.zx.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author zx
 * @date 2021/12/9 13:51
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        Calculate calculateProxy = ctx.getBean("tulingCalculate",Calculate.class);
        calculateProxy.div(1,1);
        calculateProxy.sub(1,1);
    }
}
