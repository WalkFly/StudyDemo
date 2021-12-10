package cn.com.soyea.zx.frame.spring.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author zx
 * @date 2021/12/3 9:58
 */
@Component
@Slf4j
public class Tank {
    private String name;

    public Tank() {
        log.info("tank被加载");
    }
}
