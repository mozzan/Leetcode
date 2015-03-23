package com.mozzan.leetcode;

public class IsPalindrome {

	public static void main(String[] args) {
		System.out.println(new IsPalindrome().isPalindrome(123321));
	}

	public boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		int front = 0;
		int last = s.length() - 1;

		while(front < last) {
			if(s.charAt(front++) != s.charAt(last--))
				return false;
		}
		return true;
    }

}
