package cn.com.soyea.zx.jvm.cheapter5.demo1;

import cn.com.soyea.zx.jvm.cheapter1.demo3.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 内存溢出测试
 *
 * @author zx
 * date 2021/11/17 10:31
 */
public class OOMTest {
    public static List<Object> list = new ArrayList<>();

    // JVM设置
    // -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\jvm.dump
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User(i++, UUID.randomUUID().toString()));
            new User(j--, UUID.randomUUID().toString());
        }
    }
}
