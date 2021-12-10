package cn.com.soyea.zx.frame.spring.demo2.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author zx
 * @date 2021/12/7 13:56
 */
@Slf4j
public class RentHouse implements IRentHouse{
    @Override
    public void rentHouse() {
        log.info("租了一间房子");
    }
}
