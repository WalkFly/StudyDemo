package cn.com.soyea.zx.concurrent.demo1;

import org.openjdk.jol.info.ClassLayout;

/**
 * 打印类头部信息
 *
 * @author zx
 * @date 2021/11/29 10:40
 */
public class LockSoutDemo {

    public static void main(String[] args) {
        LockSoutDemo lockSoutDemo = new LockSoutDemo();
        System.out.println(ClassLayout.parseInstance(lockSoutDemo).toPrintable());
    }
}
