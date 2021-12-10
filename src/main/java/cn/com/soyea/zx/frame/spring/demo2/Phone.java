package cn.com.soyea.zx.frame.spring.demo2;

/**
 * TODO
 *
 * @author zx
 * @date 2021/12/7 11:01
 */
public class Phone {
    public void charge(Charge5V c) {
        c.charging();
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        MobilePower mobilePower = new MobilePower();
        phone.charge(mobilePower);

        ChargerAdapter chargerAdapter = new ChargerAdapter();
        phone.charge(chargerAdapter);
    }
}
