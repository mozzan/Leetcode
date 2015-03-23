package com.mozzan.leetcode;

import java.lang.String;

public class StringToInteger_atoi {

	public static void main(String[] args) {
		System.out.println(new StringToInteger_atoi().atoi("-222"));
		//BigDecimal b1 = new BigDecimal("1.2");
		//BigDecimal b2 = new BigDecimal("1.20");
		//System.out.println(b1.intValue());
	}

	public int atoi(String str) {
		int len = str.length();
		char[] number = str.toCharArray();
		boolean isStart = false;
		boolean isNeg = false;
		int index = 0;
		long total = 0;

		while(index < len) {
			if(!isStart) {
				if(number[index] == ' ') {
					isStart = false;
				} else if(number[index] == '-') {
					isNeg = true;
					isStart = true;
					index++;
					continue;
				} else if(number[index] == '+') {
					isNeg = false;
					isStart = true;
					index++;
					continue;
				} else if(number[index] >= '0' && number[index] <= '9') {
					isStart = true;
				} else {
					return 0;
				}
			}

			if(!isStart) {
				index++;
				continue;
			}
			if(number[index] >= '0' && number[index] <= '9') {
				total = total * 10 + (isNeg ? 0 - (number[index] - '0') : number[index] - '0');
				if(isNeg && total > 0) {
					total *= -1;
				}
				if(total < -2147483648) {
					return -2147483648;
				} else if(total > 2147483647) {
					return 2147483647;
				}
			} else {
				break;
			}
			index++;
		}

		return (int)total;
	}
}
