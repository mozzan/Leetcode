package com.mozzan.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ValidParentheses {

	public static void main(String[] args) {
		boolean result = new ValidParentheses().isValid("{}()[]");
		System.out.println(result);
	}

	public boolean isValid(String s) {
		byte[] symbols = s.getBytes();
		int remain1 = 0; // {
		int remain2 = 0; // [
		int remain3 = 0; // (
		LinkedList<Byte> list = new LinkedList<Byte>();

		for(int i = 0; i < symbols.length; i++) {
			if(symbols[i] == '{') {
				remain1++;
				list.add(symbols[i]);
			} else if(symbols[i] == '[') {
				remain2++;
				list.add(symbols[i]);
			} else if(symbols[i] == '(') {
				remain3++;
				list.add(symbols[i]);
			} else if(symbols[i] == '}') {
				if(list.size() == 0 || remain1 == 0) {
					return false;
				} else if(list.removeLast() == '{') {
					remain1--;
				} else {
					return false;
				}
			} else if(symbols[i] == ']') {
				if(list.size() == 0 || remain2 == 0) {
					return false;
				} else if(list.removeLast() == '[') {
					remain2--;
				} else {
					return false;
				}
			} else if(symbols[i] == ')') {
				if(list.size() == 0 || remain3 == 0) {
					return false;
				} else if(list.removeLast() == '(') {
					remain3--;
				} else {
					return false;
				}
			}
		}
		return remain1 == 0 && remain2 == 0 && remain3 == 0;
    }
}
