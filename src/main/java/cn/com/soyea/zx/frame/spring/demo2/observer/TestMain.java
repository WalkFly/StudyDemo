package cn.com.soyea.zx.frame.spring.demo2.observer;

/**
 *
 * @author zx
 * @date 2021/12/7 14:40
 */
public class TestMain {
    public static void main(String[] args) {
        OfficialAccount officialAccount = new OfficialAccount();
        User alice = new User("Alice");
        User bob = new User("Bob");
        User me = new User("me");
        officialAccount.addObserver(alice);
        officialAccount.addObserver(bob);
        officialAccount.addObserver(me);
        officialAccount.publishNewInfo("发布第一条消息");
        officialAccount.deleteObserver(me);
        officialAccount.publishNewInfo("发布第二条消息");
    }
}
