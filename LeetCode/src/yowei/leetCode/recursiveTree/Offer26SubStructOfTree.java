package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class Offer26SubStructOfTree {
    public boolean isSubStructure(TreeNode A, TreeNode B){
        return (A!= null && B!=null) && (judge(A,B)             //判断A，B是否完全相同
                || isSubStructure(A.left,B)                     //判断B是否左子树的子结构
                || isSubStructure(A.right,B));                  //判断B是否右子树的子结构

    }
    private boolean judge(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return judge(A.left,B.left) && judge(A.right,B.right);
    }

}
