package cn.com.soyea.zx.frame.spring.aop;

import org.springframework.aop.framework.AopContext;

/**
 * 计算类实现类
 *
 * @author zx
 * @date 2021/12/9 13:47
 */
public class TulingCalculate implements Calculate{

    @Override
    public int add(int numA, int numB) {
        System.out.println("执行目标方法:add");
        System.out.println(1/0);
        return numA+numB;
    }

    @Override
    public int sub(int numA, int numB) {
        System.out.println("执行目标方法:reduce");
        return numA-numB;
    }

    @Override
    public int div(int numA, int numB) {
        System.out.println("执行目标方法:div");
        return numA/numB;
    }

    @Override
    public int multi(int numA, int numB) {
        System.out.println("执行目标方法:multi");
        return numA*numB;
    }

    @Override
    public int mod(int numA, int numB) {
        System.out.println("执行目标方法:mod");
        int retVal = ((Calculate) AopContext.currentProxy()).add(numA,numB);
        return retVal%numA;
    }
}
