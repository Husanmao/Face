package com.huawei.colin.algorithm;

public class StepCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 15;
		System.out.println(stepCount2(a));
	}
	
	/**
	 * Solution 1 : 递归算法
	 * Description：走到n阶前，可能位于n-1阶，走一步即可;也可能位于n-2阶,走两步即可;也有可能位于n-3阶,走3步即可.
	 * @param n
	 * @return
	 */
	public static int stepCount(int n) {
		if (n <= 0) throw new IllegalArgumentException("Illegal Arguments");
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;
		return stepCount(n - 1) + stepCount(n - 2) + stepCount(n - 3);
	}
	
	/**
	 * Solution 2 : 使用for循环和标志返回值的位置的方式
	 * @param n
	 * @return
	 */
	public static int stepCount2(int n) {
		if (n <= 0) throw new IllegalArgumentException("Illegal Arguments");
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;
		
		int[] count = new int[]{1, 2, 4};
		int j = 0;
		for (int i = 4; i < n + 1; i++) {
			j = (i - 1) % 3;
			count[j] = count[0] + count[1] + count[2];
		}
		return count[j];
	}

}
