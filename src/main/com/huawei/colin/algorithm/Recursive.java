package com.huawei.colin.algorithm;

/**
 * 汉诺塔问题 : 递推与递归
 * @author Colin
 * @date 2017年6月16日上午12:22:51
 */
public class Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		System.out.println(getSteps2(n));
	}

	/*
	 * Solution 1 : 递归实现汉诺塔问题
	 * @param n	碟子的数目
	 * @return 从A柱搬到C柱需要的步数
	 */
	public static long getSteps(int n) {
		if (n < 1)
			throw new IllegalArgumentException("Illegal Argument");
		if (n == 1) return 1;
		return 2 * getSteps(n - 1) + 1;
	}
	
	/*
	 * Solution 2 : 递推实现汉诺塔问题
	 * @param n	碟子的数目
	 * @return 从A柱搬到C柱需要的步数
	 */
	public static long getSteps2(int n) {
		int[] f = new int[n];
		f[0] = 1;
		for (int i = 1; i < n; i++) {
			f[i] = 2 * f[i - 1] + 1;
		}
		return f[n - 1];
	}
}
