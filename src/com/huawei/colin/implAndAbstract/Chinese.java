package com.huawei.colin.implAndAbstract;

public abstract class Chinese implements People, Anim{
	
	private static final String LANGUAGE = "Chinese";
	
	public String getColor() {
		return "Yellow";
	}
	
	public static void speak() {
		System.out.println("I can speak " + LANGUAGE);
	}
}
