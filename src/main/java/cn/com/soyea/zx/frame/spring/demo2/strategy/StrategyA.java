package cn.com.soyea.zx.frame.spring.demo2.strategy;

/**
 * @Classname StrategyA
 * @Description 定义具体策略角色 每个节日的具体促销活动
 * @Date 2021/3/31 15:29
 * @Created by dell
 */
public class StrategyA implements Strategy{
    @Override
    public void show() {
        System.out.println("A促销 买一送一");
    }
}
