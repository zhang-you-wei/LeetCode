package yowei.leetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树层序遍历
 * 使用广度优先搜索，需要使用辅助队列
 */
public class No102BTLevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> res =  new ArrayList<>();
        if(root == null) return res;        //根节点为空直接返回

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while(!queue.isEmpty()){
            int curLayer = queue.size();        //得到上一层的节点数，是这层搜索的次数

            ArrayList<Integer> curLayerRes = new ArrayList<>();     //当前结果集
            for(int i = 0;i<curLayer;i++){
                TreeNode cur = queue.removeFirst();
                curLayerRes.add(cur.val);       //选择在出列时加入结果集
                if(cur.left != null){
                    queue.addLast(cur.left);
                }
                if(cur.right != null){
                    queue.addLast(cur.right);
                }
            }
            res.add(curLayerRes);
        }

        return res;
    }
}
