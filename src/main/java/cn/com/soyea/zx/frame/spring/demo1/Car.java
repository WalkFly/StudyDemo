package cn.com.soyea.zx.frame.spring.demo1;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author zx
 * @date 2021/12/3 9:48
 */
@Component
@Slf4j
public class Car {
    private String name;
    private Tank tank;

    public static Logger getLog() {
        return log;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Car(){
        log.info("car 被加载");
    }
}
