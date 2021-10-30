package com.yxhuang.tree;

import java.util.Arrays;

/**
 *  106. 从中序与后序遍历序列构造二叉树
 *  https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class TreeBuildTree_106 {

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};

        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println(treeNode.val);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // 第一步
        if (postorder.length == 0){
            return null;
        }

        // 第二步，后序遍历数组最后一个元素，就是当前的中间节点
        int rootValue = postorder[postorder.length -1];
        TreeNode node = new TreeNode(rootValue);

        // 叶子节点
        if (postorder.length == 1){
            return node;
        }

        // 第三步，找切割点
        int delimiterIndex;
        for (delimiterIndex = 0; delimiterIndex < inorder.length; delimiterIndex++){
            if (inorder[delimiterIndex] == rootValue){
                break;
            }
        }

        // 第四步：切割中序数组，得到 中序左数组和中序右数组
        // 左闭右开 [0, delimiterIndex]
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, delimiterIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, delimiterIndex + 1, inorder.length );

        // 去掉最后一个元素
        postorder = Arrays.copyOfRange(postorder, 0, postorder.length -1);

        // 第五步：切割后序数组，得到 后序左数组和后序右数组
        //  左闭右开， 注意这里用左中数组大小作为切割点
        int[] leftPostorder = Arrays.copyOfRange(postorder,0, leftInorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftInorder.length, postorder.length);

        // 第六步：
        node.left = buildTree(leftInorder, leftPostorder);
        node.right = buildTree(rightInorder, rightPostorder);

        return node;
    }
}
