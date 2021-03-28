package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;
import yowei.leetCode.tools.TreeTools;

/**
 * 由前序遍历结果和中序遍历结果得出一个唯一的二叉树
 * 采用递归方法
 */
public class No105ConstructTree {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildKid(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    /**
     *
     * @param preorder：前序遍历结果
     * @param inorder：中序遍历结果
     * @param prestart；前序数组的起始点指针
     * @param preend：前序数组的结束点指针
     * @param instart：中序数组的起始点指针
     * @param inend：中序数组的起始点指针
     * @return:返回由当前数组段构成的子树
     */
    public TreeNode buildKid(int[] preorder, int[] inorder,int prestart,int preend,int instart,int inend){
        TreeNode curRoot = null;
        if(prestart <= preend) {
            curRoot = new TreeNode(preorder[prestart]);
            int inmid = instart;

            //在中序数组中查找元素的过程，可以使用hash表建立映射快速查询
            for(;inmid <= inend; inmid++){
                if(inorder[inmid]==preorder[prestart]) break;
            }
            int premid = prestart + inmid - instart;
            curRoot.left = buildKid(preorder,inorder,prestart + 1,premid,instart,inmid - 1);
            curRoot.right = buildKid(preorder,inorder,premid + 1,preend,inmid + 1,inend);
        }
        return curRoot;
    }

    public static void main(String[] args) {
        No105ConstructTree ct = new No105ConstructTree();
        int[] pre = {1,2,3};
        int[] in = {3,2,1};
        TreeNode treeNode = ct.buildTree(pre, in);
        System.out.println(TreeTools.printTree(treeNode));

    }
}
