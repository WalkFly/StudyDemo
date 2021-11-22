package cn.com.soyea.zx.jvm.cheapter1.demo2;

import sun.misc.Launcher;
import java.net.URL;

/**
 * jdk类加载器实例
 *
 * @author zx
 * @date 2021/11/11 15:29
 */
public class TestJDKClassLoader {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());


        System.out.println();
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoder = appClassLoader.getParent();
        ClassLoader bootstrapLoder = extClassLoder.getParent();

        System.out.println();
        System.out.println("the bootstrapLoader :" + bootstrapLoder);
        System.out.println("the extClassloader :" + extClassLoder);
        System.out.println("the appClassLoader :" + appClassLoader);

        System.out.println();
        System.out.println("bootstrapLoader加载以下文件：");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls){
            System.out.println(url);
        }

        System.out.println();
        System.out.println("extClassloader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println();
        System.out.println("appClassLoader加载以下文件：");
        System.out.println(System.getProperty("java.class.path"));
    }
}
