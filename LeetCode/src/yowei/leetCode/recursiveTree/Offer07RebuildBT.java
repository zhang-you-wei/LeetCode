package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;
import yowei.leetCode.tools.TreeTools;

public class Offer07RebuildBT {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return process(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1);
    }

    private TreeNode process(int[] preorder, int[] inorder,int preL,int preR,int inL,int inR){
        if(preL > preR || inL > inR) return null;
        if(preL == preR) return new TreeNode(preorder[preL]);
        int preVal = preorder[preL];
        TreeNode root = new TreeNode(preVal);
        int i = 0;
        for(;i<preorder.length;i++){
            if(inorder[i] == preVal) break;
        }
        root.left = process(preorder,inorder,preL + 1,i,inL,i-1);
        root.right = process(preorder,inorder,i + 1,preR,i+1,inR);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,3};
        int[] in = {3,2,1};
        Offer07RebuildBT rbt = new Offer07RebuildBT();
        TreeNode res = rbt.buildTree(pre, in);
        System.out.println(TreeTools.printTree(res));
    }
}
