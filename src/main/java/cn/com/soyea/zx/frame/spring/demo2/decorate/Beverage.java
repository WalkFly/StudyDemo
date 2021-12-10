package cn.com.soyea.zx.frame.spring.demo2.decorate;
/**
 * 抽象组件，装饰者和被装饰者都继承自它
 * @author 98583
 *
 */
public abstract class Beverage {
    /**
     * 饮料的名称，用来代表是哪种饮料
     */
    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    /**
     * 每个子类都有自己的实现方法
     * @return
     */
    public abstract double cost();
}
