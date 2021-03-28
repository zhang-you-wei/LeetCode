package yowei.leetCode.array;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class Offer33PostOrderToBST {
    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    static boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;         //先找到第一个大于根节点的位置
        int m = p;
        while(postorder[p] > postorder[j]) p++;         //排除小于根节点的元素
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }


    public static void main(String[] args) {
        int[] arr = {1,6,3,2,5};
        boolean b = verifyPostorder(arr);
        System.out.println(b);
    }
}
