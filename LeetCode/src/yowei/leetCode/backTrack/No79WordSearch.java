package yowei.leetCode.backTrack;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径.
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）
 */
public class No79WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] flags = new boolean[rows][cols];         //二维表标记已经走过的位置
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //搜索到一个结点退出
                boolean res = dfs(board,flags,chars,i,j,0);
                if(res) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,boolean[][] flags,char[] chars,int i,int j,int k){
        if(i<0 || i>=board.length || j < 0 || j>=board[0].length || flags[i][j] || board[i][j]!=chars[k]) return false;
        if(k == chars.length - 1) return true;
        flags[i][j] = true;
        boolean res = dfs(board,flags,chars,i-1,j,k+1) || dfs(board,flags,chars,i,j-1,k+1)
                || dfs(board,flags,chars,i+1,j,k+1) || dfs(board,flags,chars,i,j+1,k+1);
        flags[i][j] = false;                //回溯
        return res;
    }

    public static void main(String[] args) {
        char[][] in = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','F'}};
        No79WordSearch ws = new No79WordSearch();
        boolean res = ws.exist(in, "ABCCED");
        System.out.println(res);
    }
}
