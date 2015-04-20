package com.mozzan.leetcode;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String result = new LongestCommonPrefix().longestCommonPrefix(new String[]{"aba"});
		System.out.println(result);
	}

	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		int index = 0;
		int limit = Integer.MAX_VALUE;
		for(String str : strs) {
			if(str.length() < limit) {
				limit = str.length();
			}
		}

		boolean isContinue = true;
		while(index < limit && isContinue) {
			String s = strs[0].substring(index, index + 1);
			for(int i = 1; i < strs.length; i++) {
				if(!s.equals(strs[i].substring(index, index + 1))) {
					isContinue = false;
				}
			}
			if(isContinue) {
				builder.append(s);
			}
			index++;
		}

		return builder.toString();
    }
}
