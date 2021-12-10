package cn.com.soyea.zx.frame.spring.demo2.strategy;

/**
 * @Classname Client
 * @Description 策略模式 测试类
 * @Date 2021/3/31 15:34
 * @Created by dell
 */
public class Amain {
    public static void main(String[] args) {
        SalesMan salesMan = new SalesMan(new StrategyA());
        //儿童节
        salesMan.salesManShow();

        System.out.println("=======================");
        //劳动节
        salesMan.setStrategy(new StrategyB());
        salesMan.salesManShow();

        System.out.println("=======================");
        //端午节
        salesMan.setStrategy(new StrategyC());
        salesMan.salesManShow();
    }
}
