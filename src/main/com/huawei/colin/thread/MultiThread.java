package com.huawei.colin.thread;

public class MultiThread {

	public static void main(String[] args) {
		Thread test1 = new TestThread();
		Thread test2 = new TestThread();
		Thread test3 = new TestThread();
		Thread test4 = new TestThread();
		Thread test5 = new TestThread();
		test1.start();
		test2.start();
		test3.start();
		test4.start();
		test5.start();
	}
	
//	static class MyAsyncTask extends AsyncTask<Integer, Integer, Integer>() {
//
//	}
}
