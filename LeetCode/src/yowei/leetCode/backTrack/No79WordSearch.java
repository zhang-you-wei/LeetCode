package yowei.leetCode.backTrack;


public class No79WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] flags = new boolean[rows][cols];         //二维表标记已经走过的位置
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //搜索到一个结点退出
              if(search(i,j,0,chars,board,flags,' ')) return true;
            }
        }
        return false;
    }

    public boolean search(int row,int col,int len,char[] chars,char[][] board,boolean[][] flags,char type){
        if(len >= chars.length) return true;
        int rowlen = board.length;
        int colsen = board[0].length;
        if(row <0 || row >=rowlen || col < 0 || col >= colsen) return false;  //没地方走退出
        if(flags[row][col]) return false;
        if(board[row][col] != chars[len]) return false;    //值不对此路不通
        flags[row][col] = true;         //此位置标记，开始朝下个方向走
        if(type == 'r'){
            boolean flag =  (search(row - 1,col,len + 1,chars,board,flags,'u')
                    || search(row,col + 1,len + 1,chars,board,flags,'r')
                    || search(row + 1,col,len + 1,chars,board,flags,'d'));
            flags[row][col] = false;
            return flag;
        }
        if(type == 'd'){
            boolean flag = (search(row ,col - 1,len + 1,chars,board,flags,'l')
                    || search(row,col + 1,len + 1,chars,board,flags,'r')
                    || search(row + 1,col,len + 1,chars,board,flags,'d'));
            flags[row][col] = false;
            return flag;
        }
        if(type == 'l'){
            boolean flag = (search(row - 1,col,len + 1,chars,board,flags,'u')
                    || search(row,col - 1,len + 1,chars,board,flags,'l')
                    || search(row + 1,col,len + 1,chars,board,flags,'d'));
            flags[row][col] = false;
            return flag;
        }
        if(type == 'u') {
            boolean flag = (search(row - 1,col,len + 1,chars,board,flags,'u')
                    || search(row,col + 1,len + 1,chars,board,flags,'r')
                    || search(row ,col - 1,len + 1,chars,board,flags,'l'));
            flags[row][col] = false;
            return flag;
        }
        else {
            boolean flag =  (search(row - 1,col,len + 1,chars,board,flags,'u')
                    || search(row,col + 1,len + 1,chars,board,flags,'r')
                    || search(row ,col - 1,len + 1,chars,board,flags,'l')
                    || search(row + 1 ,col,len + 1,chars,board,flags,'d'));
            flags[row][col] = false;
            return flag;
        }

    }

    public static void main(String[] args) {
        char[][] in = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','F'}};
        No79WordSearch ws = new No79WordSearch();
        boolean res = ws.exist(in, "ABCB");
        System.out.println(res);
    }
}
