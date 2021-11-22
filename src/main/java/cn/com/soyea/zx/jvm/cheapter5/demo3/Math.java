package cn.com.soyea.zx.jvm.cheapter5.demo3;

import cn.com.soyea.zx.jvm.cheapter1.demo3.User;

/**
 *
 * @author zx
 * @date 2021/11/17 10:53
 */
public class Math {
    public static final int initData = 666;
    public static User user = new User();

    public int compute() {  //一个方法对应一块栈帧内存区域
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        while (true){
            math.compute();
        }
    }
}
