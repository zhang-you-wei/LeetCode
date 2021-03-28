package yowei.leetCode.array;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Offer29PrintMatrixClockwise {
    public int[] spiralOrder(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        int[] res = new int[width*height];
        int l = 0,r = width - 1,t = 0,b = height - 1,x = 0;
        while(l <= r && t <= b){
            for(int i = l;i <= r;i++){
                res[x++] = matrix[t][i];
                if(++t > b) break;
            }
            for(int i = t;i <= b;i++){
                res[x++] = matrix[i][r];
                if(--r < l) break;
            }
            for(int i = r;i >=l ;i--){
                res[x++] = matrix[b][i];
                if(--b < t) break;
            }
            for(int i = b;i >= t;i--){
                res[x++] = matrix[i][l];
                if(++l > r) break;
            }
        }
        return res;
    }
}
