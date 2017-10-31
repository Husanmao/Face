package com.huawei.colin;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 各排序算法实现
 * @author Colin
 * @date 2017年7月26日上午12:04:35
 */
public class MySort {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		int num = 10000;
		Integer[] nums = new Integer[num];
		randomNums(num, nums);
		long begin = new Date().getTime();
		binary(nums);
		long end = new Date().getTime();	
		double between = end - begin;
		System.out.println("Time effect : " + between);
//		for (int k = 0; k < nums.length; k++) {
//			if (k % 20 == 0) System.out.println("");
//			System.out.print(k == nums.length - 1 || nums[k] > nums[k + 1] ? nums[k] + " > " : nums[k] + " >= ");
//		}
	}

	/**
	 * 冒泡排序
	 * @param nums
	 * @return
	 */
	public static void bubble(Integer[] nums) {
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0 ;j < length - i - 1; j++) {
				if (nums[j] < nums[j + 1]) {
					nums[j] = nums[j + 1] + nums[j];
					nums[j + 1] = nums[j] - nums[j + 1];
					nums[j] = nums[j] - nums[j + 1];
				}
			}
		}
	}
	
	/**
	 * 插入发排序
	 * @param nums
	 */
	public static void insert(Integer[] nums) {
		int len = nums.length;
		for (int i = 1; i < len; i++) {
			int temp = nums[i];
			int k = i;
			while (k > 0 && nums[k - 1] < temp) {
				nums[k] = nums[k - 1];
				k--;
			}
			nums[k] = temp;
		}
	}
	
	/**
	 * 二分排序
	 * @param nums
	 */
	public static void binary(Integer[] nums) {
		int len = nums.length;
		for (int i = 0; i <= len / 2; i++) {
			int max = i, min = i;
			for (int j = i + 1; j < len - i; j++) {
				if (nums[j] > nums[max]) {
					max = j;
				} else if (nums[j] < nums[min]) {
					min = j;
				}
			}
			int temp1 = nums[i]; nums[i] = nums[max]; nums[max] = temp1;
			int temp2 = nums[len - i - 1]; nums[len - i - 1] = nums[min]; nums[min] = temp2;
		}
	}
	
	/**
	 * 选择排序
	 * @param nums
	 */
	public static void select(Integer[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] < nums[j]) {
					nums[i] = nums[i] + nums[j];
					nums[j] = nums[i] - nums[j];
					nums[i] = nums[i] - nums[j];
				}
			}
		}
	}
	
	/**
	 * 产生n个随机数
	 * @param n
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static void randomNums(int n, Integer[] nums) throws NoSuchAlgorithmException {
		List<Integer> list = new ArrayList<Integer>();
		SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
		while (n > 0) {
			Integer temp = rand.nextInt();
			list.add(temp);
			n--;
		} 
		list.toArray(nums);
	}
}
