package com.huawei.colin.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: hudongfeng
 * @Description: 生产者和消费者模型，两者通过BlockingQueue进行数据交互
 *               交互的数据中含有静态变量，必须使用线程安全的AtoicInteger类型进行自增.
 *               以下LinkedBlockingQueue的几个操作函数说明:
 *               add        增加一个元素              如果队列已满则抛出ILLegalSlabException异常
 *               remove     移除并返回队列头部的元素    如果队列为空则抛出NoSuchElementException异常
 *               element    返回队列头部的元素         如果队列为空则抛出NoSuchElementException异常
 *               offer      添加一个元素并返回true     如果队列已满则返回false表示插入失败
 *               poll       移除并返回队列头部的元素    如果队列为空则返回null
 *               peek       返回队列头部的元素         如果队列为空则返回null
 *               put        添加一个元素              如果队列已满则阻塞
 *               take       移除并返回队列头部的元素    如果队列为空则阻塞
 *
 * @Date: 2017/12/6
 */
public class Producer implements Runnable {

    private BlockingQueue<String> product;
    private volatile boolean isRunning = true;
    private static AtomicInteger a = new AtomicInteger(0);

    public Producer(BlockingQueue<String> a) {
        this.product = a;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                String data = a.incrementAndGet() + "";
                /* offer函数插入时如果超过阈值直接返回，插入失败 */
                boolean succeed = product.offer(data);
//                if (succeed) {
//                    System.out.println("insert data " + data + " succeed");
//                } else {
//                    System.out.println("insert data " + data + " failed");
//                }
                /* put函数会阻塞直到队列中有空间 */
//                product.put(data);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<String> c = new LinkedBlockingQueue<String>(1000);

        //Using cached thread pool to improve the performance
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Thread(new Producer(c)));
        service.execute(new Thread(new Producer(c)));
        service.execute(new Thread(new Producer(c)));
        service.execute(new Thread(new Consumer(c)));
        service.execute(new Thread(new Consumer(c)));
        service.execute(new Thread(new Consumer(c)));
    }
}

class Consumer implements Runnable {
    private BlockingQueue<String> product;
    private volatile boolean isRunning = true;

    public Consumer(BlockingQueue<String> b) {
        this.product = b;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                String data = product.poll(2, TimeUnit.SECONDS);
                if (null == data) {
                    isRunning = false;
                } else {
                    System.out.println(data);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}