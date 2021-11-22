package cn.com.soyea.zx.jvm.cheapter1.demo1;

/**
 * 测试B类
 *
 * @author zx
 * @date 2021/11/11 15:23
 */
public class B {
    static {
        System.out.println("#######load A##########");
    }

    public B(){
        System.out.println("########## initial A ###########");
    }
}
