package yowei.leetCode.sharpBrain;

import java.util.Arrays;


/**
 * 旋转矩阵，直接方法是先将矩阵装置然后将列对称变换
 * 参考魔方的转法，依次交换对应位置
 */
public class No48RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //外层循环，表示矩阵的圈数len/2
        for (int i = 0; i < (len/2); i++) {
            //内层循环表示每圈的需要交换的个数为len - 1
            for (int j = i; j < len - i - 1; j++) {
                //i表示第几圈
                swap(matrix,i,j,j,len - i - 1);
                swap(matrix,i,j,len - i - 1,len - j - 1);
                swap(matrix,i,j,len - j - 1,i);
            }
        }
    }

    public void swap(int[][] matrix,int i1,int j1,int i2,int j2){
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    public static void main(String[] args) {
        int[][] ma = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        No48RotateImage ri = new No48RotateImage();
        ri.rotate(ma);
        System.out.println(Arrays.toString(ma[0]));
        System.out.println(Arrays.toString(ma[1]));
        System.out.println(Arrays.toString(ma[2]));
        System.out.println(Arrays.toString(ma[3]));
    }

}
