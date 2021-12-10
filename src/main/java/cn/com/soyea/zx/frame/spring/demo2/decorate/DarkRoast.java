package cn.com.soyea.zx.frame.spring.demo2.decorate;

/**
 * 被装饰者
 * @author 98583
 *
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }

    public double cost() {
        return .99;
    }
}