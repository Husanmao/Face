package com.huawei.colin;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试java虚拟机内存溢出
 * @author Colin
 * @date 2017年7月26日上午12:03:33
 */
public class Mem {

	/**
	 * Empty class for oom testing
	 * @author Colin
	 * @date 2017年7月26日上午12:03:07
	 */
	static class OOMObject{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		while(true) {
			list.add(new Integer(4));
		}
	}

}
