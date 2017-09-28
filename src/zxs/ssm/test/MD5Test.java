package zxs.ssm.test;

import zxs.ssm.util.MD5Util;

public class MD5Test {

	public static void main(String[] args) {
		String abc = "1234" ;
		String pass = MD5Util.generatePassword(abc);
		System.out.println(pass);
	}	
}
