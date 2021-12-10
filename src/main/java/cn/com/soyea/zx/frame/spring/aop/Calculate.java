package cn.com.soyea.zx.frame.spring.aop;

/**
 * 实现计算方法类
 * @author zx
 * @date 2021/12/9 13:46
 */
public interface Calculate {
    /**
     * 加法
     * @param numA
     * @param numB
     * @return
     */
    int add(int numA, int numB);

    /**
     * 减法
     * @param numA
     * @param numB
     * @return
     */
    int sub(int numA, int numB);

    /**
     * 除法
     * @param numA
     * @param numB
     * @return
     */
    int div(int numA, int numB);

    /**
     * 乘法
     * @param numA
     * @param numB
     * @return
     */
    int multi(int numA, int numB);

    int mod(int numA, int numB);
}
