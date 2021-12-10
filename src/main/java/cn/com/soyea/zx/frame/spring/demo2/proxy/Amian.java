package cn.com.soyea.zx.frame.spring.demo2.proxy;

/**
 *
 * @author zx
 * @date 2021/12/7 13:58
 */
public class Amian {
    public static void main(String[] args) {
        //定义租房
        IRentHouse rentHouse = new RentHouse();
        //定义中介
        IRentHouse intermediary = new IntermediaryProxy(rentHouse);
        //中介租房
        intermediary.rentHouse();
    }

}
