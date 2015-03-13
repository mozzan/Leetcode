package com.mozzan.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		int result = new LengthOfLongestSubstring().lengthOfLongestSubstring("abcdcef");
	}

	public int lengthOfLongestSubstring(String s) {

		int index = 0;
		int tmp = -1;
		int length = s.length();

		int maxLength = 0;

		Set<Character> set = new HashSet<Character>();

		while (index < length) {
			if (index > 0)
				set.remove(s.charAt(index - 1));
			int start = index;
			if (tmp == -1 || tmp >= 0 - 2 || tmp == start) {
				tmp = start;
				set.clear();
			}
			while (tmp < length && !set.contains(s.charAt(tmp))) {
				set.add(s.charAt(tmp));
				// System.out.print(s.charAt(tmp));
				if (tmp - start + 1 > maxLength) {
					maxLength = tmp - start + 1;
				}

				tmp++;
			}
			// System.out.println();
			// System.out.println(maxLength);
			index++;
		}

		return maxLength;
	}
}
