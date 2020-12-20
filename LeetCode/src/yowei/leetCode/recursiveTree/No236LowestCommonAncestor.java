package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;

import java.util.LinkedList;

/**寻找二叉树中两个指定节点的最近公共祖先
 *
 */
public class No236LowestCommonAncestor {

    TreeNode second;
    LinkedList<TreeNode> stack;

    /**
     * 先找到其中一个元素，用一个栈记录其路径，然后依次出栈作为根节点判断能否找到第二个元素
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> path = new LinkedList<TreeNode>();
        TreeNode second = findfirst(root,p,q,path);
        TreeNode curroot = stack.pop();
        if(isfound(curroot,second)) return curroot;
        while(!stack.isEmpty()){
            curroot = stack.pop();
            if(isfound(curroot.right,second)) return curroot;
        }
        return null;
    }

    private TreeNode findfirst(TreeNode root,TreeNode p,TreeNode q,LinkedList<TreeNode> path){
        if(root == null) return null;
        if(root == p || root == q){
            path.push(root);
            stack = new LinkedList<>(path);
            second = root==p?q:p;
            return second;
        }
        path.push(root);
        second = findfirst(root.left,p,q,path);
        if(second != null) return second;
        second =  findfirst(root.right,p,q,path);
        path.pop();
        return second;
    }

    private boolean isfound(TreeNode curroot,TreeNode second){
        if(curroot == null) return false;
        if(curroot == second) return true;
        return isfound(curroot.left,second) || isfound(curroot.right,second);
    }


    /*#####################################################################################*/
     private TreeNode ans = null;

    /**
     * 自底向上递归，判断左右子树是否包含指定元素
     * 两种情况：1、左右子树各含一个元素，则返回根节点 2、根节点为一个元素且左右子树中有一个含有另一个元素，直接返回根节点
     */
     private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
         if (root == null) return false;
         boolean lson = dfs(root.left, p, q);
         boolean rson = dfs(root.right, p, q);
         if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
             ans = root;
         }
         return lson || rson || (root.val == p.val || root.val == q.val);
     }

     public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
         this.dfs(root, p, q);
         return this.ans;
     }


    /*#####################################################################################*/

    /**
     * 后序遍历方法：分四种情况：
     * 1.当 leftleft 和 rightright 同时为空 ：说明 rootroot 的左 / 右子树中都不包含 p,返回 nullnull ；
     * 2.当 leftleft 和 rightright 同时不为空 ：说明 p, q分列在 rootroot 的 异侧 （分别在 左 / 右子树），因此 rootroot 为最近公共祖先，返回 rootroot ；
     * 3.当 leftleft 为空 ，rightright 不为空 ：p,q都不在 rootroot 的左子树中，直接返回 rightright 。具体可分为两种情况：
     *      p,q其中一个在 rootroot 的 右子树 中，此时 rightright 指向 p（假设为 p ）；
     *      p,q 两节点都在 rootroot 的 右子树 中，此时的 rightright 指向 最近公共祖先节点 ；
     * 4.当 leftleft 不为空 ， rightright 为空 ：与情况 3. 同理；
     */
     public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
         if(root == null || root == p || root == q) return root;
         TreeNode left = lowestCommonAncestor(root.left, p, q);
         TreeNode right = lowestCommonAncestor(root.right, p, q);
         if(left == null && right == null) return null; // 1.
         if(left == null) return right; // 3.
         if(right == null) return left; // 4.
         return root; // 2. if(left != null and right != null)
     }
}
