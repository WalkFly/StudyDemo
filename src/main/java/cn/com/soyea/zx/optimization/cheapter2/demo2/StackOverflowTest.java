package cn.com.soyea.zx.optimization.cheapter2.demo2;

/**
 *
 * @author zx
 * @date 2021/11/12 13:56
 */
public class StackOverflowTest {
    static int count =0;

    public static void doTest(){
        while(true){
            count ++;
        }
    }

    public static void main(String[] args) {
        StackOverflowTest.doTest();
    }

}
