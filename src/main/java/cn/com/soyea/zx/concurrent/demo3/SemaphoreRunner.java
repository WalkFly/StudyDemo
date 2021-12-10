package cn.com.soyea.zx.concurrent.demo3;

import java.util.concurrent.Semaphore;

/**
 * 资源访问，服务限流(Hystrix里限流就有基于信号量方式)。
 *
 * @author zx
 * @date 2021/11/30 9:10
 */
public class SemaphoreRunner {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for(int i =0;i<100;i++){
            new Thread(new Task(semaphore,"zx+"+i)).start();
        }
    }

    static class Task extends Thread{
        Semaphore semaphore;

        public Task(Semaphore semaphore , String tname){
            this.semaphore = semaphore;
            this.setName(tname);
        }

        public void run(){
            try{
                semaphore.acquire();
                System.out.println(String.format("%s:aquire() at time:%s" , Thread.currentThread().getName() , System.currentTimeMillis()));
                Thread.sleep(3000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName()+":release() at time:"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
