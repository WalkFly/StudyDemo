package cn.com.soyea.zx.concurrent.demo3;

import java.util.concurrent.CountDownLatch;

/**
 * TODO
 *
 * @author zx
 * @date 2021/11/30 9:21
 */
public class SeeDoctorTask implements Runnable{
    private CountDownLatch countDownLatch;

    public SeeDoctorTask(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("开始看医生");
            Thread.sleep(3000);
            System.out.println("看医生结束，准备离开病房");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (countDownLatch != null)
                countDownLatch.countDown();
        }
    }
}
