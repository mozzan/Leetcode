package com.mozzan.leetcode;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		System.out.println(new RegularExpressionMatching().isMatch("aaa", "ab*a*c*a"));  //"aaa", "a*a"
	}

	public boolean isMatch(String s, String p) {
		char[] sourse = s.toCharArray();
		char[] pattern = p.toCharArray();
		int sIndex = 0;
		int pIndex = 0;
		boolean previousNotMatch = false;
		boolean matchKeepGoing = false;
		char keepGoingChar = 0;

		while (sIndex <= sourse.length - 1 || pIndex <= pattern.length - 1) {
			if (matchKeepGoing) {
				if (sIndex <= sourse.length - 1 && (keepGoingChar == '.' || sourse[sIndex] == keepGoingChar)) {
					sIndex++;
					previousNotMatch = false;
					continue;
				} else {
					int remain = 0;
					int tmp = pIndex;
					while(tmp <= pattern.length - 1) {
						if(pattern[tmp] == keepGoingChar) {
							remain++;
							tmp++;
						} else {
							break;
						}
					}
					int back = tmp - remain;
					if(remain == 0) {
						matchKeepGoing = false;
					} else {
						return isMatch(s.substring(sIndex - remain < 0 ? 0 : sIndex - remain), p.substring(back));
					}
				}
			}
			if (sIndex > sourse.length - 1 && pattern[pIndex] != '*') {
				if(previousNotMatch) {
					return false;
				} else {
					previousNotMatch = true;
				}
			} else if (pIndex > pattern.length - 1) {
				return false;
			} else if (previousNotMatch && pattern[pIndex] != '*') {
				return false;
			} else if (previousNotMatch && pattern[pIndex] == '*') {
				previousNotMatch = false;
			} else if (pattern[pIndex] == '.') {
				previousNotMatch = false;
				sIndex++;
			} else if (pattern[pIndex] == '*') {
				matchKeepGoing = true;
				previousNotMatch = false;
				keepGoingChar = pattern[pIndex - 1];
			} else if (sourse[sIndex] != pattern[pIndex]) {
				previousNotMatch = true;
			} else {
				previousNotMatch = false;
				sIndex++;
			}

			pIndex++;
		}

		return !previousNotMatch;
	}
}
