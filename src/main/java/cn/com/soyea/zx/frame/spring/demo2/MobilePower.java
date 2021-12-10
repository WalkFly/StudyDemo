package cn.com.soyea.zx.frame.spring.demo2;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author zx
 * @date 2021/12/7 11:00
 */
@Slf4j
public class MobilePower implements Charge5V{

    @Override
    public void charging() {
        log.info("使用充电宝给手机充电(5V)");
    }
}
