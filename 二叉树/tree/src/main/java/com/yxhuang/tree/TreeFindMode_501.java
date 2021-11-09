package com.yxhuang.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class TreeFindMode_501 {

    /**
     * 501. 二叉搜索树中的众数
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     * <p>
     * 假定 BST 有如下定义：
     * <p>
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     * 例如：
     * 给定 BST [1,null,2,2],
     * <p>
     * 1
     * \
     * 2
     * /
     * 2
     * 返回[2].
     * <p>
     * 提示：如果众数超过1个，不需考虑输出顺序
     * <p>
     * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
     *
     * @param args
     */
    private TreeNode mPreNode = null;
    private int mCount = 0;
    private int mMaxCount = 0;
    private List<Integer> mResultList = new ArrayList<>();

    public static void main(String[] args) {


    }


    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        findNodeTraversal(root);
        int[] result = new int[mResultList.size()];
        for (int i = 0; i < mResultList.size(); i++) {
            result[i] = mResultList.get(i);
        }
        return result;
    }

    // [1, 2, 2, 2, 3, 4, 4, 4, 5, 6]
    private void findNodeTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // 中序遍历
        findMode(node.left);

        // 处理节点，二叉搜索树是一个递增的数组
        if (mPreNode == null) {  // 第一个节点
            mCount = 1;
        } else if (mPreNode.val == node.val) { // 与前一个节点相同则 count + 1，例如 mPreNode = 2, node = 2
            mCount++;
        } else { // 不同节点，则将 mCount = 1， 即新节点的数量,例如 mPreNode = 2, node = 3
            mCount = 1;
        }

        mPreNode = node; // 更新前一个节点

        // mMaxCount 在  mMaxCount = mCount 之前，它一直代表着是 之前数量最多 node 的个数
        if (mCount == mMaxCount) { // 例如 node = 4, 的 mCount  = 3, 于 node =2 的 mMaxCount 相同，则将 4 加入结果列表
            mResultList.add(node.val);
        }
        // 如果统计到当前 node 的数量已经大于前一个 Node 的 mMaxCount, 则说明新 Node 的数量大于之前的
        if (mCount > mMaxCount) {
            mMaxCount = mCount; // 新的 Node 的数量就是最大的
            mResultList.clear(); // 清除原来的结果
            mResultList.add(node.val); // 将新的 Node 加入结果列表
        }
        findMode(node.right);
    }
}
