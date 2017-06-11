package com.huawei.colin;

public class BitCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 101111;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(bitCount1(a));
		System.out.println(bitCount2(a));
	}
	
	/**
	 * Solution 1 : 通过将int类型转化成二进制byte[]，遍历获取1的个数
	 * @param a Num to search
	 * @return Num of 1
	 */
	public static int bitCount1(int a) {
		int sum = 0;
		byte[] b = Integer.toBinaryString(a).getBytes();
		for(int i = 0; i < b.length; i++) {
			if (b[i] == '1') sum++;
		}
		return sum;
	}
	
	/**
	 * Solution 2 : 通过不断的向右移位(>>>补0法以为，防止负数移位时的补1操作影响)并和1做&操作,统计1的个数
	 * @param a
	 * @return
	 */
	public static int bitCount2(int a) {
		int sum = 0;
		while (a != 0) {
			if ((a & 1) != 0) sum++;
			a >>>= 1;
		}
		return sum;
	}
	
	
}
