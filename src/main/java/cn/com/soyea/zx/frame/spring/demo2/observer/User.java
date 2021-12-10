package cn.com.soyea.zx.frame.spring.demo2.observer;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author zx
 * @date 2021/12/7 14:36
 */
public class User implements Observer {
    private String name;
    public User(String name){
        this.name = name;
    }


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("微信用户："+name+"，您的微信公众号更新这些内容："+arg);
    }
}
