package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 验证二叉查找树
 * 检验某个节点的值是否大于其左子孙的值并且小于右子孙的值
 * 进行中序遍历，检验某个节点值是否比该节点之前的的值小
 */
public class No98ValidateBST {

    /**
     * 递归法，中序遍历
     */
    private boolean flag = true;        //查询结果
    private boolean isFirst = true;         //是否是递归查询到的第一个节点，因为节点值可能为int类型的负的最小值
    private int last = 0;           //当前节点的前一个节点值大小

    public boolean isValidBST(TreeNode root) {
        inorderTraverse(root);
        return flag;
    }

    public void inorderTraverse(TreeNode t){
        if(t==null) return;
        inorderTraverse(t.left);        //先查询左子节点
        if(!isFirst){                   //判断是否为第一个节点，也可以赋值last为double类型的最小值，省略此步
            if(t.val <= last){
                flag = false;
            }
        }
        else isFirst = false;
        last = t.val;                   //对当前节点进行操作
        inorderTraverse(t.right);       //查询右子节点
    }


    /**
     * 中序遍历递归代码优化
     */

    private long pre = Long.MIN_VALUE;

    public boolean isValidBST3(TreeNode root) {
        return inorderTraverse2(root);
    }

    public boolean inorderTraverse2(TreeNode t){
        if(t == null) return true;
        boolean l = inorderTraverse2(t.left);
        if(!l) return false;
        if(t.val < pre) return false;
        pre = t.val;
        boolean r = inorderTraverse2(t.right);
        return r;
    }



    /**
     * 中序遍历使用非递归方式
     */
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();         //利用辅助栈保存节点遍历顺序
        double pre = Long.MIN_VALUE;

        while (!stack.isEmpty() || root!=null){         //关键的判断条件，必须带上root!=null，否则会出现栈已经空了但还有节点未遍历的情况
            while (root!=null){
                stack.push(root);           //左子节点顺序入栈
                root = root.left;
            }

            root = stack.pop();             //操作当前节点
            if(root.val <= pre) return false;
            pre = root.val;

            root = root.right;          //右子节点存入栈顶，保证当前层级的优先度
        }

        return true;
    }


}
