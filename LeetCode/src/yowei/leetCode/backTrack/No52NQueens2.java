package yowei.leetCode.backTrack;

public class No52NQueens2 {
    private int total=0;
    private int n;
    boolean[] cols;
    boolean[] main;
    boolean[] sub;


    public int totalNQueens(int n) {
        this.n = n;
        cols = new boolean[n];
        main = new boolean[2*n-1];
        sub = new boolean[2*n-1];
        bfs(0);
        return total;
    }


    public void bfs(int row){
        if(row==n) {
            total++;
            return;
        }

        for(int i=0;i<n;i++){
            if(!cols[i] && !main[row-i+n-1] && !sub[row+i]){
                cols[i] = true;
                main[row-i+n-1] = true;
                sub[row+i] = true;
                bfs(row+1);
                cols[i] = false;
                main[row-i+n-1] = false;
                sub[row+i] = false;

            }
        }

    }

    public static void main(String[] args) {
        No52NQueens2 nqueens = new No52NQueens2();
        System.out.print(nqueens.totalNQueens(10));
    }

}
