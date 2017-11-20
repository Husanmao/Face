package com.huawei.colin.algorithm;

import com.huawei.colin.algorithm.RunOver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Description:java多线程的几种实现
 * @author Colin
 * @date 2017年6月12日上午4:42:18
 */
public class MyThread {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		Thread myThread = new Thread1();
		myThread.start();
		
		Thread myThread1 = new Thread(new MyHandler());
		myThread1.start();
		
		Callable myCallable = new MyCallable();
		FutureTask oneTask = new FutureTask(myCallable);
		Thread oneThread = new Thread(oneTask);
		oneThread.start();
		
		int taskSize = 5;
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		List<Future> list = new ArrayList<Future>();
		for (int i = 0; i < taskSize; i++) {
			Future newFuture = pool.submit(new MyCallable());
			list.add(newFuture);
		}
		
		pool.shutdown();
		for(Future f : list) {
			System.out.println(f.get().toString());
		}
	}

	/**
	 * Method 1 : 继承Thread实现多线程
	 * @author Colin
	 * @date 2017年6月12日上午5:09:09
	 */
	static class Thread1 extends Thread {
		public void run() {
			System.out.println("MyThread.run");
		}
	}
	
	/**
	 * Method 2 : 实现Runnable方法并作为参数传给Thread实现多线程
	 * @author Colin
	 * @date 2017年6月12日上午5:09:42
	 */
	static class MyHandler extends RunOver implements Runnable{
		
		public void run() {
			System.out.println("MyHandler.run");
		}
		
	}
	
	/**
	 * Method 3 : 构造Callable,FutureTask对象,方便调用Thread(FutureTask)实现多线程
	 * @author Colin
	 * @date 2017年6月12日上午5:10:24
	 */
	@SuppressWarnings("rawtypes")
	static class MyCallable implements Callable {
		
		@Override
		public Object call() throws Exception {
			
			Date date1 = new Date();
			Thread.sleep(1000);
			// TODO Auto-generated method stub
			System.out.println("MyCallable.run");
			Date date2 = new Date();
			return "sleep " + (date2.getTime() - date1.getTime());
		}
		
	}
	
}

