package com.mozzan.leetcode;

public class ReverseInteger {
	public static void main(String[] args) {
		int result = new ReverseInteger().reverse(-100000000);
		System.out.println(result);
	}

	public int reverse(int x) {
		String ori = String.valueOf(x);
		boolean isNeg;
		char[] number;

		if(isNeg = (ori.charAt(0) == '-')) {
			number = new char[ori.length() - 1];
		} else {
			number = new char[ori.length()];
		}

		// reverse
		int tmp = 0;
		int max = ori.length() - 1;
		while(tmp <= max) {
			if(isNeg && max - tmp == 0) {
				break;
			}
			number[tmp] = ori.charAt(max - tmp);
			tmp++;
		}

		String result = isNeg ? "-" + String.valueOf(number) : String.valueOf(number);

		long num = Long.parseLong(result);
		if(isNeg && num < -2147483648) {
			return 0;
		} else if(!isNeg && num > 2147483647) {
			return 0;
		}

		return (int)num;
	}
}
