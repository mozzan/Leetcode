package com.mozzan.leetcode;

public class ZigZagConversion {

	public static void main(String[] args) {
		String result = new ZigZagConversion().convert("PAYPALISHIRING", 500);
		System.out.println(result);
	}

	public String convert(String s, int nRows) {
		if(nRows == 1)
			return s;

		int len = s.length();
		char[] result = new char[len];
		int tmp;
		int maxGap = (nRows - 1) * 2;
		int index = 0;

		for(int i = 0; i < nRows; i++) {
			int gap = maxGap - 2 * i;
			if(gap == 0)
				gap = maxGap;
			tmp = i;
			while(tmp < len) {
				result[index++] = s.charAt(tmp);

				if((gap == 0 || gap == maxGap)) {
					tmp += gap;
				} else {
					tmp += gap;
					gap = maxGap - gap;
				}
			}
		}
		return String.valueOf(result);
	}
}
