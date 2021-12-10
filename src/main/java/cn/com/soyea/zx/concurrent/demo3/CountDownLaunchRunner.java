package cn.com.soyea.zx.concurrent.demo3;

import java.util.concurrent.CountDownLatch;

/**
 * TODO
 *
 * @author zx
 * @date 2021/11/30 9:35
 */
public class CountDownLaunchRunner {
    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new SeeDoctorTask(countDownLatch)).start();
        new Thread(new QueueTask(countDownLatch)).start();
        //等待线程池中的2个任务执行完毕，否则一直
        countDownLatch.await();
        System.out.println("over，回家 cost:"+(System.currentTimeMillis()-now));
    }
}
