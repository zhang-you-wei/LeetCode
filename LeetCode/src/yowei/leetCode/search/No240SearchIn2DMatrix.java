package yowei.leetCode.search;

/**
 * 在有序的二维矩阵中搜索目标值
 */
public class No240SearchIn2DMatrix {

    /**
     * 分割矩阵方法：将矩阵分为以中间点分割的四部分，然后递归分别进行判断
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        return slice(matrix,target,0,0,matrix.length -1,matrix[0].length - 1);
    }

    private boolean slice(int[][] matrix, int target,int x1,int y1,int x2,int y2){
        if(matrix[x1][y1] == target || matrix[x2][y2] == target) return true;
        if(matrix[x2][y2] < target || matrix[x1][y1] > target) return false;

        //小于等于4的小矩阵单独列出判断
        if(x2 - x1 <= 1 && y2 - y1 <=1) {
            if(x2 > x1 && y2 > y1){
                return matrix[x2][y1] == target || matrix[x1][y2] == target;
            }
            return false;
        }
        int i = (x1 + x2)/2;
        int j = (y1 + y2)/2;

        return slice(matrix,target,x1,y1,i,j) || slice(matrix,target,i,j,x2,y2) || slice(matrix,target,x1,j,i,y2) || slice(matrix,target,i,y1,x2,j);
    }

    /*#######################################################################################*/

    /**
     * 开挂解法：从左下角开始移动，大于目标值就想上移动一行，否则向右移动一列
     */
    public boolean searchMatrix2(int[][] matrix, int target) {

        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }

    /*#######################################################################################*/
    /**
     *二分查找：对每行(列)都进行二分查找
     */

}
