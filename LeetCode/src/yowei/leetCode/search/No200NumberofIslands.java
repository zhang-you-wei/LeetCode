package yowei.leetCode.search;

/**
 * 二维平面上进行搜索
 * 每个岛屿就是一棵多叉树
 * 对没个树进行dfs或bfs
 */
public class No200NumberofIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        //将每个点作为根节点开始遍历
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                //判断是否是岛屿
                if(grid[i][j] == '1'){
                    //进行dfs遍历
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid,int row,int col){
        //终止条件
        if(!inArea(grid,row,col)) return;
        if(grid[row][col] == '0') return;
        //进行递归
        //遍历过的岛屿修改为0，避免重复遍历和循环遍历
        grid[row][col] = '0';
        dfs(grid,row - 1,col);
        dfs(grid,row + 1,col);
        dfs(grid,row,col - 1);
        dfs(grid,row,col + 1);

    }

    private boolean inArea(char[][] grid,int row,int col){
        return row >=0 && row < grid.length && col >=0 && col < grid[0].length;
    }
}
