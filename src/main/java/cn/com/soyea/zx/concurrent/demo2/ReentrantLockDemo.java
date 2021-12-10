package cn.com.soyea.zx.concurrent.demo2;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockDemo
 *
 * @author zx
 * @date 2021/11/29 10:55
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(false);//false为非公平锁，true为公平锁
        lock.lock(); //加锁
        lock.unlock(); //解锁
    }
}
