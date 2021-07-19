package com.yxhuang.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 数的遍历
 */
public class TreeTraversal {

    public static void main(String[] args) {


        // 后序遍历
        afterTraversal();

        // 前序遍历
//        preTraversal();

        // 中序遍历
        middleTraversal();
    }

    private static void preTraversal() {
        System.out.println("----前序遍历 递归--- ");
        /**
         * 输入：root = [1,null,2,3]
         * 输出：[1,2,3]
         */
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        root.right.left = new TreeNode(3);
        Stack<Integer> afterStack = new Stack();
        preTraversal(root, afterStack);
        while (!afterStack.isEmpty()) {
            Integer top = afterStack.remove(0);
            if (top != null) {
                System.out.println(top);
            }
        }

        System.out.println("----前序遍历 迭代--- ");
        List<Integer> result = preTraversal2(root);
        for (Integer i : result) {
            System.out.println(i);
        }

    }

    private static void afterTraversal() {
        System.out.println("----后序遍历 start ");

        /**
         * 后序遍历 左右中
         * 输入: [1,null,2,3]
         *    1
         *     \
         *      2
         *     /
         *    3
         *
         * 输出: [3,2,1]
         */
        System.out.println("----后序遍历 递归算法 ");
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        root.right.left = new TreeNode(3);
        Stack<Integer> afterStack = new Stack();
        afterTraversal(root, afterStack);
        while (!afterStack.isEmpty()) {
            Integer top = afterStack.remove(0);
            if (top != null) {
                System.out.println(top);
            }
        }

        System.out.println("----后序遍历 迭代算法 ");

        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        root2.right.left = new TreeNode(3);
        List<Integer> result = afterTraversal2(root2);
        for (Integer i : result) {
            System.out.println(i);
        }

        System.out.println("----后序遍历end--- ");

    }


    private static void middleTraversal(){
        System.out.println("----中序遍历 start ");
        /**
         * 输入：root = [1,null,2,3]
         * 输出：[1,3,2]
         */
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        root.right.left = new TreeNode(3);
        Stack<Integer> afterStack = new Stack();
        middleTraversal(root, afterStack);
        while (!afterStack.isEmpty()) {
            Integer top = afterStack.remove(0);
            if (top != null) {
                System.out.println(top);
            }
        }

        System.out.println("----中序遍历 迭代 ");

        List<Integer> result = middleTraversal2(root);
        for (Integer i : result) {
            System.out.println(i);
        }

    }
    /**
     * 前序遍历： 中左右
     *
     * @param current
     * @param stack
     */
    private static void preTraversal(TreeNode current, Stack<Integer> stack) {
        if (current == null) {
            return;
        }

        stack.push(current.val); // 中
        preTraversal(current.left, stack);  // 左
        preTraversal(current.right, stack); // 右
    }

    /**
     * 中序遍历  左中右
     *
     * @param current
     * @param stack
     */
    private static void middleTraversal(TreeNode current, Stack<Integer> stack) {
        if (current == null) {
            return;
        }
        middleTraversal(current.left, stack);
        stack.push(current.val);
        middleTraversal(current.right, stack);
    }

    /**
     * 后序遍历  左右中
     *
     * @param current
     * @param stack
     */
    private static void afterTraversal(TreeNode current, Stack<Integer> stack) {
        if (current == null) {
            return;
        }
        afterTraversal(current.left, stack);
        afterTraversal(current.right, stack);

        stack.push(current.val);
    }


    /**
     * 迭代的 前序遍历
     * 中右左
     *
     * @param root
     */
    private static List<Integer> preTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop(); // 出栈
            result.add(node.val);  // 这里是先添加 中
            // 这里要先添加 右的，再添加左的，这样才能保证弹出的时候是 中左右
            if (node.right != null) {
                stack.push(node.right);  // 右
            }
            if (node.left != null) {  // 左
                stack.push(node.left);
            }
        }
        return result;
    }

    /**
     * 迭代遍历        中序变量， 左 中 右
     *
     * @param root
     * @return
     */
    private static List<Integer> middleTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {  // 访问到最底层
                stack.push(currentNode);  // 将反问的节点放入栈
                currentNode = currentNode.left;  // 左
            } else {
                currentNode = stack.pop(); // 从栈里弹出的数据，就是要处理的数据
                result.add(currentNode.val);  // 中
                currentNode = currentNode.right;  // 右
            }
        }
        return result;
    }

    /**
     * 迭代的 后续遍历
     * 左右中
     *
     * @param root
     */
    private static List<Integer> afterTraversal2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) { // 先将左节点入栈
                stack.push(node.left);
            }
            if (node.right != null) { // 后将右节点入栈
                stack.push(node.right);
            }
            result.addFirst(node.val);
        }
        return result;
    }
}
