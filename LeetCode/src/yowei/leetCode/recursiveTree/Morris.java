package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;
import yowei.leetCode.tools.TreeTools;

public class Morris {

    /**
     * morris算法
     * @param root：一棵树的根节点
     */
    public static void morris(TreeNode root){
        if(root == null) return;

        TreeNode cur = root;
        TreeNode mostRight = null;

        //cur为空时到达最右端节点，结束循环
        while (cur != null){

            //找到左树的最右节点
            mostRight = cur.left;

            if(mostRight != null){
                while (mostRight.right != null && mostRight.right != cur ){
                    mostRight = mostRight.right;
                }

                //第一次遇到cur，最右节点的右节点为空
                if(mostRight.right == null){
                    System.out.print(cur.val + " ");
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    //最右节点的右节点指向cur，第二次遇到cur
                    mostRight.right = null;
                }

            }
            //没有左树，直接转到右树
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    //先序遍历
    public static void preOrder(TreeNode root){
        if(root == null) return;

        TreeNode cur = root;
        TreeNode mostRight = null;

        //cur为空时到达最右端节点，结束循环
        while (cur != null){

            //找到左树的最右节点
            mostRight = cur.left;

            if(mostRight != null){
                while (mostRight.right != null && mostRight.right != cur ){
                    mostRight = mostRight.right;
                }

                //第一次遇到cur，最右节点的右节点为空
                if(mostRight.right == null){

                    //第一次遇到cur直接打印
                    System.out.print(cur.val + " ");
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    //最右节点的右节点指向cur，第二次遇到cur
                    mostRight.right = null;
                    cur = cur.right;
                    continue;           //第二次遇到时不打印开始下一轮循环
                }

            }
            //只会遇到一次的节点直接打印
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    //中序遍历
    public static void inOrder(TreeNode root){
        if(root == null) return;

        TreeNode cur = root;
        TreeNode mostRight = null;

        //cur为空时到达最右端节点，结束循环
        while (cur != null){

            //找到左树的最右节点
            mostRight = cur.left;

            if(mostRight != null){
                while (mostRight.right != null && mostRight.right != cur ){
                    mostRight = mostRight.right;
                }

                //第一次遇到cur，最右节点的右节点为空
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    //第二次达到的节点需要打印
                    mostRight.right = null;
                }
            }
            //只到达一次或者第二次到达都会走到这里，可以打印节点
            System.out.print(cur.val + " ");
            cur = cur.right;

        }
    }

    //后序遍历
    public static void lastOrder(TreeNode root){
        if(root == null) return;

        TreeNode cur = root;
        TreeNode mostRight = null;

        //cur为空时到达最右端节点，结束循环
        while (cur != null){

            //找到左树的最右节点
            mostRight = cur.left;

            if(mostRight != null){
                while (mostRight.right != null && mostRight.right != cur ){
                    mostRight = mostRight.right;
                }

                //第一次遇到cur，最右节点的右节点为空
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    //最右节点的右节点指向cur，第二次遇到cur
                    mostRight.right = null;

                    //只需在第二次遇到cur时逆序打印左树的右边界
                    TreeNode reTree = reverseTree(cur.left);        //翻转左树的右边界
                    printLinkedTree(reTree);
                    reverseTree(reTree);            //翻转回去
                }

            }
            cur = cur.right;
        }
        TreeNode rootRight = reverseTree(root);
        printLinkedTree(rootRight);
        reverseTree(rootRight);
    }

    //翻转链表树
    private static TreeNode reverseTree(TreeNode tree){
        TreeNode last = null;
        TreeNode cur = tree;
        while(cur != null){
            TreeNode right = cur.right;
            cur.right = last;
            last = cur;
            cur = right;
        }
        return last;
    }

    private static void printLinkedTree(TreeNode root){
        while(root != null){
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeTools treeTools = new TreeTools();
        int[] arr = {1,2,3,4,5,-1,7,-1,-1,6,-1,-1,-1,-1,-1};
        TreeNode tree = treeTools.getTree(arr);
        morris(tree);
        System.out.println();
        preOrder(tree);
        System.out.println();
        inOrder(tree);
        System.out.println();
        lastOrder(tree);
//        String s = treeToos.printTree(tree);
//        System.out.println(s);
    }
}
