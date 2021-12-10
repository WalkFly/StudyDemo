package cn.com.soyea.zx.frame.spring.demo2.decorate;
/**
 * 抽象装饰者，定义具体装饰者要实现的代码
 * @author 98583
 *
 */
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
