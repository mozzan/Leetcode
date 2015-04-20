package com.mozzan.leetcode;


public class MergeTwoSortedList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(10);

		//node1.next = node2;
		//node2.next = node3;
		//node3.next = node4;
		//node4.next = node5;

		ListNode node6 = new ListNode(1);
		ListNode node7 = new ListNode(1);
		ListNode node8 = new ListNode(1);
		ListNode node9 = new ListNode(9);
		ListNode node10 = new ListNode(10);

		//node6.next = node7;
		//node7.next = node8;
		//node8.next = node9;
		//node9.next = node10;

		ListNode result = new MergeTwoSortedList().mergeTwoLists(null, null);
		ListNode tmp = result;
		do {
			System.out.println(tmp.val);
		} while((tmp = tmp.next) != null);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode head = null;
		ListNode real = null;

		if(l1.val < l2.val) {
			real = l1;
			head = real;
			l1 = l1.next;
		} else {
			real = l2;
			head = real;
			l2 = l2.next;
		}

		while(l1 != null || l2 != null) {
			if(l1 == null) {
				real.next = l2;
				real = real.next;
				l2 = l2.next;
				continue;
			}
			if(l2 == null) {
				real.next = l1;
				real = real.next;
				l1 = l1.next;
				continue;
			}
			if(l1.val < l2.val) {
				real.next = l1;
				real = real.next;
				l1 = l1.next;
			} else {
				real.next = l2;
				real = real.next;
				l2 = l2.next;
			}
		}

		return head;
    }

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) { val = x; }
	}
}
