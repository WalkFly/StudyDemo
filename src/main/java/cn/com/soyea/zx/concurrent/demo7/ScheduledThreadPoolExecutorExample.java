package cn.com.soyea.zx.concurrent.demo7;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPoolExecutorExample Demo
 *
 * @author zx
 * @date 2021/12/3 8:52
 */
@Slf4j
public class ScheduledThreadPoolExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        Task task1 = new Task ("Demo Task 1");
        Task task2 = new Task ("Demo Task 2");
        System.out.println("The time is : " + new Date());
        executor.schedule(task1, 5 , TimeUnit.SECONDS);
        executor.schedule(task2, 10 , TimeUnit.SECONDS);

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Task implements Runnable
{
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run()
    {
        try {
            System.out.println("Doing a task during : " + name + " - Time - " + new Date());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
