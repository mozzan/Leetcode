package com.mozzan.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.mozzan.leetcode.AddTwoSum.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class RemoveNthNodeFromEnd {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		//ListNode node2 = new ListNode(2);
		//ListNode node3 = new ListNode(3);
		//ListNode node4 = new ListNode(4);
		//ListNode node5 = new ListNode(5);

		//node1.next = node2;
		//node2.next = node3;
		//node3.next = node4;
		//node4.next = node5;

		ListNode result = new RemoveNthNodeFromEnd().removeNthFromEnd(node1, 1);
		ListNode tmp = result;
		do {
			System.out.println(tmp.val);
		} while((tmp = tmp.next) != null);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null)
			return null;
		Map<Integer,ListNode> map = new HashMap<Integer,ListNode>();
		int total = 0;
		ListNode next = head;

		do {
			total++;
			map.put(total, next);
		} while((next = next.next) != null);

		ListNode tmp1;
		ListNode tmp2;
		if((tmp1 = map.get(total - n)) != null) {
			tmp2 = map.get(total - n + 2);
			tmp1.next = tmp2;
		} else if(total == n) {
			return head.next;
		}
		return head;
    }

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) { val = x; }
	}
}
