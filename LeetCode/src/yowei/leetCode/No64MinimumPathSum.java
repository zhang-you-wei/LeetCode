package yowei.leetCode;

public class No64MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int rowlen = grid.length;
        int collen = grid[0].length;
        for (int i = collen-2; i >= 0 ; i--) {
            grid[rowlen - 1][i] += grid[rowlen - 1][i+1];
        }
        for (int i = rowlen - 2; i >= 0; i--) {
            grid[i][collen - 1] += grid[i+1][collen - 1];
        }

        for (int col = collen - 2; col >=0; col--) {
            for (int row = rowlen - 2; row >= 0; row--) {
                grid[row][col] += Math.min(grid[row+1][col],grid[row][col+1]);
            }

        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        int[][] x = {{1,3,1},{1,5,1},{4,2,1}};
        No64MinimumPathSum mps = new No64MinimumPathSum();
        System.out.println(mps.minPathSum(x));
    }
}
