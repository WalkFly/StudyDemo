package cn.com.soyea.zx.concurrent.demo5;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

/**
 * 我们的生成器构造函数将 BlockingQueue 作为参数，用于协调生产者和使用者之间的处理。我们看到方法 generateNumbers() 将 100 个元素（生产100副药给武大郎吃）放入队列中。它还需要有毒 （ poison ） 丸 （ pill ） （潘金莲给武大郎下毒）消息，以便知道在执行完成时放入队列的消息类型。该消息需要将 poisonPillPerProducer 次放入队列中。
 * 每个消费者将使用 take() 方法从 BlockingQueue 获取一个元素，因此它将阻塞，直到队列中有一个元素。从队列中取出一个 Integer 后，它会检查该消息是否是毒 （ poison ） 丸 （ pill ）（武大郎看潘金莲有没有下毒） ，如果是，则完成一个线程的执行。否则，它将在标准输出上打印出结果以及当前线程的名称。
 *
 * @author zx
 * @date 2021/11/30 10:05
 */
@Slf4j
public class NumbersConsumer implements Runnable{
    private BlockingQueue<Integer> queue;
    private final int poisonPill;

    public NumbersConsumer(BlockingQueue<Integer> queue, int poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer number = queue.take();
                if (number.equals(poisonPill)) {
                    return;
                }
                log.info("武大郎-{}号,喝药-编号:{}",Thread.currentThread().getId(),number);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
