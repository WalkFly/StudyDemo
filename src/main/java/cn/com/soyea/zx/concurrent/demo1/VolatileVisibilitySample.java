package cn.com.soyea.zx.concurrent.demo1;

/**
 * volatile的可见性
 *
 * @author zx
 * @date 2021/11/25 9:46
 */
public class VolatileVisibilitySample {
    volatile boolean initFlag = false;

    public void save(){
        this.initFlag = true;
        String threadName = Thread.currentThread().getName();
        System.out.println("线程："+threadName+":修改共享变量initFlag");
    }

    public void load(){
        String threadName = Thread.currentThread().getName();
        while(!initFlag){
            //线程在此处空跑，等待initFlag状态改变
        }
        System.out.println("线程："+threadName+"当前线程嗅探到initFlag的状态的改变");
    }

    public static void main(String[] args) {
        VolatileVisibilitySample volatileVisibilitySample = new VolatileVisibilitySample();
        Thread threadA = new Thread(()->{
            volatileVisibilitySample.save();
        },"threadA");

        Thread threadB = new Thread(()->{
            volatileVisibilitySample.load();
        },"threadB");

        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadA.start();
    }
}
