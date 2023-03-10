package com.JohnZhuang.AlgorighmAtguigu;

/**
 * @author JohnZhuang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/10 10:45
 */
public class Code08_ReverseList {
    public static ListNode reverseList_Ans(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,null);
        ListNode listNode1 = new ListNode(2, listNode);
        ListNode listNode2 = new ListNode(3, listNode1);
        ListNode listNode3 = new ListNode(4, listNode2);
        System.out.println(reverseList_Ans(listNode3));
    }

}
