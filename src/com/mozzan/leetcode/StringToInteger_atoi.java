package com.mozzan.leetcode;

import java.lang.String;

public class StringToInteger_atoi {

	public static void main(String[] args) {
		System.out.println(new StringToInteger_atoi().atoi("-3.1335"));
		//BigDecimal b1 = new BigDecimal("1.2");
		//BigDecimal b2 = new BigDecimal("1.20");
		//System.out.println(b1.intValue());
	}

	public int atoi(String str) {
		float anwser =  Float.parseFloat(str);
		if(anwser < -2147483648) {
			return 0;
		} else if(anwser > 2147483647) {
			return 0;
		}

		return (int)anwser;
	}

}
