package cn.com.soyea.zx.concurrent.demo5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

/**
 * TODO
 *
 * @author zx
 * @date 2021/11/30 10:15
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new DelayQueue();
        blockingQueue.add("123");
    }
}
