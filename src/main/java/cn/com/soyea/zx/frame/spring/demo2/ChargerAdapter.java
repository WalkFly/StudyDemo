package cn.com.soyea.zx.frame.spring.demo2;

import lombok.extern.slf4j.Slf4j;

/**
 * 适配器，转化为5v
 *
 * @author zx
 * @date 2021/12/7 11:03
 */
@Slf4j
public class ChargerAdapter extends Socket implements Charge5V{
    @Override
    public void charging() {
        chargingWith220V();
        log.info("转化为5V");
    }
}
