package cn.com.soyea.zx.jvm.cheapter3.demo2;

/**
 * 测试gc //添加运行JVM参数： -XX:+PrintGCDetails
 *
 * @author zx
 * @date 2021/11/15 15:38
 */
public class GCTest {
    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6;
        allocation1 = new byte[60000*1024];

        //allocation2 = new byte[8000*1024];

      allocation3 = new byte[1000*1024];
     allocation4 = new byte[1000*1024];
     allocation5 = new byte[1000*1024];
     allocation6 = new byte[1000*1024];
    }
}
