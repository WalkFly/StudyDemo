package cn.com.soyea.zx.concurrent.demo1;

/**

 *
 * @author zx
 * @date 2021/11/25 14:08
 */
public class DoubleCheckLock {
    //禁止指令重排优化
    private volatile static DoubleCheckLock instance;
    private DoubleCheckLock(){

    }

    public static DoubleCheckLock getInstance(){
        if(null == instance){
            //同步
            synchronized (DoubleCheckLock.class){
                //多线程环境下可能会出现问题的地方
                if(instance == null){
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }
}
