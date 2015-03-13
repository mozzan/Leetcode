package com.mozzan.leetcode;

import java.util.ArrayList;

public class AddTwoSum {
	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; next = null; } }
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 0 -> 8
	 *
	 *  Input: 	{1,8}, {0}
		Output: 	{8,1}
		Expected: 	{1,8}

	 */
	public static void main(String[] args) {
		/*ListNode l1 = new ListNode(2);
		ListNode l1a = new ListNode(4);
		ListNode l1b = new ListNode(3);
		l1.next = l1a;
		l1a.next = l1b;

		ListNode l2 = new ListNode(5);
		ListNode l2a = new ListNode(6);
		ListNode l2b = new ListNode(4);
		l2.next = l2a;
		l2a.next = l2b;*/

		/*ListNode l1 = new ListNode(1);
		ListNode l1a = new ListNode(8);
		l1.next = l1a;

		ListNode l2 = new ListNode(0);*/

		/*ListNode l1 = new ListNode(5);

		ListNode l2 = new ListNode(5);*/

		ListNode l1 = new ListNode(1);
		ListNode l1a = new ListNode(8);
		l1.next = l1a;

		ListNode l2 = new ListNode(0);

		new AddTwoSum().addTwoNumbers(l1, l2);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;

		ListNode now = null;
		ListNode previous = null;
		boolean carry = false;

		while(l1 != null || l2 != null) {
			int val1 = 0;
			int val2 = 0;
			if(l1 == null)
				val1 = 0;
			else
				val1 = l1.val;

			if(l2 == null)
				val2 = 0;
			else
				val2 = l2.val;

			int out = val1 + val2 + (carry ? 1 : 0);
			carry = out > 9;

			now = new ListNode(out % 10);
			if(previous != null) {
				previous.next = now;
			} else {
				result = now;
			}
			previous = now;
			//System.out.println(out % 10);

			if(l1 != null)
				l1 = l1.next;
			if(l2 != null)
				l2 = l2.next;
		}

		if(carry) {
			ListNode carryout = new ListNode(1);
			previous.next = carryout;
		}

		return result;
    }

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
