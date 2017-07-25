package com.huawei.colin.implAndAbstract;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chinese tom = new Chinese() {

			@Override
			public int getAge() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getKind() {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
		System.out.println(tom.getColor());
		
	}

}
