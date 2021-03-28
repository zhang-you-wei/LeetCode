package yowei.leetCode.tools;

import java.util.LinkedList;

public class TreeTools {
    public static TreeNode getTree(int[] treeArr){
        if(treeArr == null) return null;

        LinkedList<TreeNode> queue = new LinkedList<>();

        int i = 0;
        TreeNode root = getNode(treeArr[i++]);
        queue.addLast(root);
        while (!queue.isEmpty() && i<treeArr.length){
            TreeNode father = queue.removeFirst();
            father.left = getNode(treeArr[i++]);
            father.right = getNode(treeArr[i++]);
            if(father.left != null) queue.addLast(father.left);
            if(father.right != null) queue.addLast(father.right);
        }
        return root;

    }

    private static TreeNode getNode(int i){
        if(i == -1) return null;
        return new TreeNode(i);
    }

    public static String printTree(TreeNode root){
        if(root == null) return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.addLast(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.removeFirst();
            if(cur == null) sb.append(-1 + " ");
            else {
                sb.append(cur.val + " ");
                queue.addLast(cur.left);
                queue.addLast(cur.right);
            }
        }
        return sb.toString();
    }
}
