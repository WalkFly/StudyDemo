package cn.com.soyea.zx.frame.spring.demo2.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author zx
 * @date 2021/12/7 13:56
 */
@Slf4j
public class IntermediaryProxy implements IRentHouse{
    private IRentHouse rentHouse;

    public IntermediaryProxy(IRentHouse irentHouse){
        rentHouse = irentHouse;
    }

    @Override
    public void rentHouse() {
        log.info("先交中介费");
        rentHouse.rentHouse();
        log.info("中介负责维修管理");
    }
}
