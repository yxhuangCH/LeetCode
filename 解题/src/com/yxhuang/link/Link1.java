package com.yxhuang.link;

/**
 * 21. 合并两个有序链表
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class Link1 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode cl1 = l1;
        while (cl1 != null) {
            System.out.println("l1: " + cl1.val);
            cl1 = cl1.next;
        }

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode cl2 = l2;
        while (cl2 != null) {
            System.out.println("l2: " + cl2.val);
            cl2 = cl2.next;
        }

        System.out.println("----");

        ListNode resultNList = mergeTwoLists(l1, l2);
        ListNode clr = resultNList;
        while (clr != null) {
            System.out.println("clr: " + clr.val);
            clr = clr.next;
        }
    }


    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode node = new ListNode(-1);
        while (head1.next != null ||  head2.next != null) {
            if (head1.val < head2.val) {
                node.next = head1;
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                node.next = head2;
                head2 = head2.next;
            } else {
                node.next = head1;
                node.next.next = head2;
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        ListNode resultNode = node.next;
        node = null;
        return resultNode;
    }
}
