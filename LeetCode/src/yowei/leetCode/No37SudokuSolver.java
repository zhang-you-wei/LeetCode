package yowei.leetCode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class No37SudokuSolver {
    private Map<Integer,Set<Integer>> rows;
    private Map<Integer,Set<Integer>> cols;
    private Map<Integer,Set<Integer>> blanks;
    private Set<Integer> standard;
    private int[][] ini;


    public No37SudokuSolver(){
        standard = new HashSet<>();
        for(int i=1;i<=9;i++) standard.add(i);
    }


    public void solve(char[][] board){
        ini = new int[9][9];
        for(int i=0;i<=8;i++){
            for(int j=0;j<=8;j++){
                if(board[i][j]=='.') ini[i][j] = 0;
                else ini[i][j] = Integer.valueOf(board[i][j])-48;
            }
        }
        getSets(ini);
        fill(0,0);
    }



    public boolean fill(int currow,int curcol){
        if(currow > 8) return true;
        int nextrow,nextcol;
        nextrow = currow + curcol/8;
        nextcol = (curcol + 1)%9;

        if(ini[currow][curcol]!=0) {
            return fill(nextrow,nextcol);
        }

        else {
            Set<Integer> posib = posibnums(currow,curcol);
//            System.out.println("row:"+currow+" col:" + curcol+" "+posib.toString());
            if(posib.isEmpty()) return false;
            for(Integer x:posib){
                ini[currow][curcol] = x;
                rows.get(currow).add(x);
                cols.get(curcol).add(x);
                blanks.get((currow/3)*3+curcol/3).add(x);

                if(fill(nextrow,nextcol)){
                    return true;
                }
                else {
                    blanks.get((currow/3)*3+curcol/3).remove(x);
                    cols.get(curcol).remove(x);
                    rows.get(currow).remove(x);
                    ini[currow][curcol] = 0;
                }
            }
            return false;
        }

    }




    public void getSets(int[][] board){
        rows = new HashMap<>();
        cols = new HashMap<>();
        blanks = new HashMap<>();
        for(int i=0;i<=8;i++){
            blanks.put(i,new HashSet<>());
        }
        for(int i=0;i<=8;i++){
            Set<Integer> temprow = new HashSet<>();
            Set<Integer> tempcol = new HashSet<>();
            for(int j=0;j<=8;j++){
                int k = (i/3)*3 +j/3;
                int rownum = board[i][j];
                int colnum = board[j][i];
                if(rownum>=1&& rownum<=9) {
                    temprow.add(rownum);
                    blanks.get(k).add(rownum);
                }
                if(colnum>=1 && colnum<=9)
                    tempcol.add(colnum);
            }
            rows.put(i,temprow);
            cols.put(i,tempcol);
        }
    }


    public Set<Integer> posibnums(int row,int col){
        Set<Integer> posib = new HashSet<>();
        posib.addAll(standard);
        posib.removeAll(rows.get(row));
        posib.removeAll(cols.get(col));
        posib.removeAll(blanks.get((row/3)*3+col/3));
        return posib;
    }


    public static void main(String[] args) {
        char[][] input = new char[9][9];

        Scanner scan = new Scanner(System.in);

        String rep = "[1-9\\.]{9}";

        for (int i = 0; i < 9; i++) {
            System.out.printf("请数独输入第%d行,空格用.代替\n",i+1);
            String str = scan.nextLine();
            if(!str.matches(rep)) {
                System.out.println("输入有误，请重新输入");
                i--;
                continue;

            }
            for (int j = 0; j < 9; j++) {
                input[i][j] = str.charAt(j);
            }
        }

        No37SudokuSolver sudo = new No37SudokuSolver();
        sudo.solve(input);
        for(int[] yy: sudo.ini){
            System.out.println(Arrays.toString(yy));
        }

        /*No37SudokuSolver sudo = new No37SudokuSolver();
        char[][] a = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        sudo.solve(a);

        for(int[] yy: sudo.ini){
           System.out.println(Arrays.toString(yy));
           }*/
    }

}
