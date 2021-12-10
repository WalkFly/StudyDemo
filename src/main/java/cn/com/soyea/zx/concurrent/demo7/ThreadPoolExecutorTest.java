package cn.com.soyea.zx.concurrent.demo7;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.*;

/**
 *
 * @author zx
 * @date 2021/12/1 16:49
 */
@Slf4j
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        MyThreadFactory myThreadFactory = new MyThreadFactory();
        MyRunnable myRunnable = new MyRunnable();
        BlockingQueue objectDeque = new LinkedBlockingDeque<>(88);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 9999L, TimeUnit.SECONDS, objectDeque , myThreadFactory ,new myReject());
        threadPoolExecutor.setRejectedExecutionHandler(new myReject());
        for(int i = 0 ; i<100; i++){
            threadPoolExecutor.execute(myRunnable);
        }

        while(true){
            Thread.sleep(1000);
            log.info("当前阻塞队列中存在线程数量{}",objectDeque.size());
        }
    }

   static class MyRunnable implements Runnable {
        private String name;

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(100000);   //睡眠4秒
                System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class myReject implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            log.warn("{}被拒绝了" , ((MyRunnable)r).getName());
        }
    }

    static class MyThreadFactory implements ThreadFactory{

        @Override
        public Thread newThread(Runnable r) {
            Thread newthread = new Thread(r);
            newthread.setName("wang" + new Date());  // 自定义工厂，如果出现异常是可以自定义处理的。
            newthread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println("自定义处理异常" + t.getName() + e.getMessage());
                    e.printStackTrace();
                }
            });
            return newthread;
        }
    }
}
