package cn.com.soyea.zx.jvm.cheapter1.demo1;

/**
 * 类加载机制详解
 *
 * @author zx
 * @date 2021/11/11 15:19
 */
public class TestDynamicLoad {
    static {
        System.out.println("##############load TestDynamicLoad############");
    }

    public static void main(String[] args) {
        new A();
        System.out.println("#######load test ############");
        B b = null;
    }
}
