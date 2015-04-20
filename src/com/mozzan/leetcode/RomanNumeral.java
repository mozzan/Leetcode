package com.mozzan.leetcode;

public class RomanNumeral {
	public static void main(String[] args) {
		int result = new RomanNumeral().romanToInt("MCMXCVI");
		System.out.println(result);
	}

	public int romanToInt(String s) {
		int result = 0;
		int length = s.length();
		int index = 0;

		while(index < length) {
			String firstAlph = s.substring(index, index + 1);
			if("I".equals(firstAlph)) {
				index++;
				if(index < length) {
					String behindAlph = s.substring(index, index + 1);
					if("V".equals(behindAlph)) {
						result += 4;
						index++;
					} else if("X".equals(behindAlph)) {
						result += 9;
						index++;
					} else {
						result += 1;
					}
				} else {
					result += 1;
				}
			} else if("V".equals(firstAlph)) {
				result += 5;
				index++;
			} else if("X".equals(firstAlph)) {
				index++;
				if(index < length) {
					String behindAlph = s.substring(index, index + 1);
					if("L".equals(behindAlph)) {
						result += 40;
						index++;
					} else if("C".equals(behindAlph)) {
						result += 90;
						index++;
					} else {
						result += 10;
					}
				} else {
					result += 10;
				}
			} else if("L".equals(firstAlph)) {
				result += 50;
				index++;
			} else if("C".equals(firstAlph)) {
				index++;
				if(index < length) {
					String behindAlph = s.substring(index, index + 1);
					if("D".equals(behindAlph)) {
						result += 400;
						index++;
					} else if("M".equals(behindAlph)) {
						result += 900;
						index++;
					} else {
						result += 100;
					}
				} else {
					result += 100;
				}
			} else if("D".equals(firstAlph)) {
				result += 500;
				index++;
			} else if("M".equals(firstAlph)) {
				result += 1000;
				index++;
			}
		}


		return result;
    }

}
