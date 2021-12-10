package cn.com.soyea.zx.concurrent.demo5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 既然我们有生产者和消费者，我们就可以开始我们的计划。我们需要定义队列的容量，并将其设置为 10个元素。
 * 我们创建4 个生产者线程，并且创建等于可用处理器数量的消费者线程：
 *
 * @author zx
 * @date 2021/11/30 10:06
 */
public class AMain {
    public static void main(String[] args) {
        int BOUND = 10;
        int N_PRODUCERS = 16;
        int N_CONSUMERS = Runtime.getRuntime().availableProcessors();
        int poisonPill = Integer.MAX_VALUE;
        int poisonPillPerProducer = N_CONSUMERS / N_PRODUCERS;
        int mod = N_CONSUMERS % N_PRODUCERS;
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(BOUND);

        //潘金莲给武大郎熬药
        for(int i =1; i<N_PRODUCERS ; i++){
            new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer)).start();
        }

        //武大郎开始喝药
        for (int j = 0; j < N_CONSUMERS; j++) {
            new Thread(new NumbersConsumer(queue, poisonPill)).start();
        }

        //潘金莲开始投毒，武大郎喝完毒药GG
        new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer + mod)).start();
    }

}
