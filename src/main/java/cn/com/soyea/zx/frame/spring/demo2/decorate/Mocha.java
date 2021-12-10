package cn.com.soyea.zx.frame.spring.demo2.decorate;

/**
 *
 * @author zx
 * @date 2021/12/7 13:45
 */
public class Mocha extends CondimentDecorator{
    /**
     * 保留一个被装饰者的引用
     */
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}
