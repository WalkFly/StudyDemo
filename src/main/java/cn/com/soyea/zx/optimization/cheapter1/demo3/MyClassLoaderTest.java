package cn.com.soyea.zx.optimization.cheapter1.demo3;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 实现自定义类加载机制
 *
 * @author zx
 * @date 2021/11/11 15:51
 */
public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, UnsupportedEncodingException {
        //初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父加载器设置为应用程序类加载器AppClassLoader
//        MyClassLoader classLoader = new MyClassLoader("D:/test");
//        //D盘创建 test/com/tuling/jvm 几级目录，将User类的复制类User1.class丢入该目录
//        Class clazz = classLoader.loadClass("cn.com.soyea.zx.cheapter1.demo3.User");
//        Object obj = clazz.newInstance();
//        Method method = clazz.getDeclaredMethod("sout", null);
//        method.invoke(obj,null);
//        System.out.println(clazz.getClassLoader().getClass().getName());


        //初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父加载器设置为应用程序类加载器AppClassLoader
        MyClassLoader classLoader = new MyClassLoader("D:/test");
        //D盘创建 cn.com.soyea.zx.cheapter1.demo3 几级目录，将User类的复制类User1.class丢入该目录
        Class clazz = classLoader.loadClass("cn.com.soyea.zx.optimization.cheapter1.demo3.User");
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sout", null);
        method.invoke(obj,null);
        System.out.println(clazz.getClassLoader());

        //初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父加载器设置为应用程序类加载器AppClassLoader
        MyClassLoader classLoader1 = new MyClassLoader("D:/test");
        //D盘创建 cn.com.soyea.zx.cheapter1.demo3 几级目录，将User类的复制类User1.class丢入该目录
        Class clazz1 = classLoader1.loadClass("cn.com.soyea.zx.optimization.cheapter1.demo3.User");
        Object obj1 = clazz1.newInstance();
        Method method1 = clazz1.getDeclaredMethod("sout", null);
        method1.invoke(obj1 ,null);
        System.out.println(clazz1.getClassLoader());
    }

}
