package cn.com.soyea.zx.concurrent.demo5;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 接下来我们创建一个由两部分组成的程序 - 生产者 ( Producer ) 和消费者 ( Consumer ) 。
 * 生产者将生成一个 0 到 100 的随机数(十全大补丸的编号)，并将该数字放在 BlockingQueue 中。我们将创建 16 个线程（潘金莲）用于生成随机数并使用 put() 方法阻塞，直到队列中有可用空间。
 * 需要记住的重要一点是，我们需要阻止我们的消费者线程无限期地等待元素出现在队列中。
 * 从生产者(潘金莲)向消费者(武大郎)发出信号的好方法是，不需要处理消息，而是发送称为毒 （ poison ） 丸 （ pill ） 的特殊消息。 我们需要发送尽可能多的毒 （ poison ） 丸 （ pill ） ，因为我们有消费者(武大郎)。然后当消费者从队列中获取特殊的毒 （ poison ） 丸 （ pill ）消息时，它将优雅地完成执行。
 * 以下生产者的代码：
 *
 * @author zx
 * @date 2021/11/30 9:57
 */
@Slf4j
public class NumbersProducer implements Runnable{
    private BlockingQueue<Integer> numbersQueue;
    private final int poisonPill;
    private final int poisonPillPerProducer;

    public NumbersProducer(BlockingQueue<Integer> numbersQueue, int poisonPill, int poisonPillPerProducer) {
        this.numbersQueue = numbersQueue;
        this.poisonPill = poisonPill;
        this.poisonPillPerProducer = poisonPillPerProducer;
    }

    @Override
    public void run() {
        try {
            generateNumbers();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void generateNumbers() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            numbersQueue.put(ThreadLocalRandom.current().nextInt(100));
            log.info("潘金莲-{}号,给武大郎的泡药！",Thread.currentThread().getId());
        }
        for (int j = 0; j < poisonPillPerProducer; j++) {
            numbersQueue.put(poisonPill);
            log.info("潘金莲-{}号,往武大郎的药里放入第{}颗毒丸！",Thread.currentThread().getId(),j+1);
        }
    }
}
