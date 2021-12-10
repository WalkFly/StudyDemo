package cn.com.soyea.zx.frame.spring.demo2.proxy;

/**
 * TODO
 *
 * @author zx
 * @date 2021/12/7 14:10
 */
public class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
