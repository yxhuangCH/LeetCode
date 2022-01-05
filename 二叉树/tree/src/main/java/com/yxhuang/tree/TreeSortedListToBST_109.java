package com.yxhuang.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class TreeSortedListToBST_109 {


    public static void main(String[] args) {

    }


    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> linkList = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            linkList.add(node.val);
            node = node.next;
        }


    }

    private static TreeNode toBST(List<Integer> list) {



    }


    static class ListNode {
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
}

