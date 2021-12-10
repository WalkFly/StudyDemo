package cn.com.soyea.zx.frame.spring.demo2.strategy;

/**
 * @Classname StrategyC
 * @Description 定义具体策略角色 每个节日的具体促销活动
 * @Date 2021/3/31 15:30
 * @Created by dell
 */
public class StrategyC implements Strategy{
    @Override
    public void show() {
        System.out.println("C促销 满500元可兑换小礼品");
    }
}
