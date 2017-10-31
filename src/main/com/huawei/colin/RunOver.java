package com.huawei.colin;

/**
 * 递归计算
 * @author Colin
 * @date 2017年6月12日上午6:31:35
 */
public class RunOver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = new int[]{3,2,1,0,4};
		System.out.println(canJump(i));
	}

	/**
	 * 给定一个非负数组，数组中的元素代表从当前位置可以向后跳几步(可以跳的最大步数，可以之跳一步），判断能否走到数组末尾。
	 * 例如：
	 * A = [2,3,1,2,4], return true；
	 * A = [3,2,1,0,4], return false.
	 * @param nums
	 * @return
	 */
	public static boolean canJump(int[] nums) {
		int maxIndex = nums.length - 1;
		int maxJump = nums[0];
		for(int i = 0; i <= maxJump; i++) {
			maxJump = Math.max(maxJump, i + nums[i]);
			if (maxJump >= maxIndex) return true;
		}
		return false;
	}
}
