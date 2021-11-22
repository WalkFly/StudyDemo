package cn.com.soyea.zx.jvm.cheapter2.demo1;

/**
 * 测试jvm分配内存过程
 * @author zx
 * @date 2021/11/12 10:51
 */
public class Hello {
    public static void main(String[] args) {
        Hello hello = new Hello();
        int testVal = hello.test();
    }

    public int test() {
        //int类型
        int a = 5 + 10;      //验证直接相加在编译阶段已合并完结果
        int b = a + 3;        //探究变量与常量的相加过程
        b = b + 6;             //验证int不在-1~5，在-128~127范围的指令是bipush
        b = b + 128;         //验证int不在-128~127，在-32768~32767范围的指令是sipush
        b = b + 32768;     //验证int不在-32768~32767，在-2147483648~2147483647范围的指令是ldc(ldc：从常量池取并压栈，所以这个范围的int是存在常量池)
        //short                  //验证byte、short、char在操作数栈压栈前均会转为int
        short a_s = 5 + 10;
        short b_s = (short)(a_s + 3);
        //float类型            //以下验证float、double、String均是从常量池中取出(均使用了ldc、ldc_w、ldc2_w其中一个)
        float a_f = 5.00F + 10.00F;
        float b_f = a_f + 3.00F;
        //double类型
        double a_d = 5.00D + 10.00D;
        double b_d = a_d + 3.00D;
        //String类型
        String a_str = "a" + "b";
        String b_str = a_str + "c";
        return b;
    }



    /**
     *   首先这个会保存在方法的Code 属性中，javac Hello.java编译，然后javap -verbose Hello.class反编译分析test()方法如下：
     *     Code:
     *     stack=4, locals=13, args_size=1
     *             0: bipush        15 //1 15压入操作数的栈顶(编译过程中5+10合并成15，并且由于15在-128-127范围，即用bipush)  压栈
     *             2: istore_1           //2  从栈顶弹出并压入局部变量表访问索引为1的Slot                                                                    弹栈入局部变量表
     *          3: iload_1            //3  将局部变量表中访问索引为1的Slot重新压入栈顶                                                                    局部变量表入栈
     *          4: iconst_3          //4  数值3压入操作数的栈顶(范围-1~5，即用指令iconst)                                                              压栈
     *          5: iadd                //5  将栈顶的前两个弹出并进行加法运算后将结果重新压入栈顶                                                     前两弹栈相加
     *          6: istore_2          //6   从栈顶弹出并压入局部变量表访问索引为2的Slot                                                                    弹栈入局部变量表
     *          7: iload_2            //7  将局部变量表中访问索引为2的Slot重新压入栈顶                                                                    局部变量表入栈
     *          8: bipush        6  //8  6压入操作数的栈顶(在-128-127范围，用bipush指令)
     *             10: iadd
     *         11: istore_2
     *         12: iload_2
     *         13: sipush     128//9  128压入操作数的栈顶(在-32768~32767范围，用sipush指令)
     *             16: iadd
     *         17: istore_2
     *         18: iload_2
     *         19: ldc           #5  // int 32768  //10  128压入操作数的栈顶(在-2147483648~2147483647范围，用ldc指令)
     *             21: iadd
     *         22: istore_2
     *         23: bipush        15 //11  验证了short、byte、char压栈前都会转为int
     *             25: istore_3
     *         26: iload_3
     *         27: iconst_3
     *         28: iadd
     *         29: i2s
     *         30: istore        4
     *             32: ldc           #6   // float 15.0f //12  以下验证float、double、String均是从常量池中取出(均使用了ldc、ldc_w、ldc2_w其中一个)
     *             34: fstore        5
     *             36: fload         5
     *             38: ldc           #7                  // float 3.0f
     *             40: fadd
     *         41: fstore        6
     *             43: ldc2_w        #8                  // double 15.0d
     *             46: dstore        7
     *             48: dload         7
     *             50: ldc2_w        #10                 // double 3.0d
     *             53: dadd
     *         54: dstore        9
     *             56: ldc           #12                 // String ab
     *             58: astore        11
     *             60: new           #13                 // class java/lang/StringBuilder
     *             63: dup
     *         64: invokespecial #14                 // Method java/lang/StringBuilder."<init>":()V
     *             67: aload         11
     *             69: invokevirtual #15                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
     *             72: ldc           #16                 // String c
     *             74: invokevirtual #15                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
     *             77: invokevirtual #17                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
     *             80: astore        12
     *             82: iload_2
     *         83: ireturn                        //13  返回结果
     */


}
