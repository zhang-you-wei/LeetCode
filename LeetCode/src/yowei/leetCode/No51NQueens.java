package yowei.leetCode;

import java.util.*;

public class No51NQueens {

    private int n;
    private HashSet<Integer> col;
    private HashSet<Integer> maindia;
    private HashSet<Integer> subdia;
    private List<List<String>> res;



    public List<List<String>> solve(int n){
        this.n = n;

        res = new ArrayList<>();
        if(n==0) return res;

        maindia = new HashSet<>();
        subdia = new HashSet<>();
        col = new HashSet<>();
        Deque<Integer> path = new ArrayDeque<>();

        bfs(0,path);
        return res;
    }

    public void bfs(int row, Deque<Integer> path){
        if(row==n){
            List<String> method = convertBoard(path);
            res.add(method);
            return;
        }
        for(int i=0;i<n;i++){
            if(!col.contains(i) && !maindia.contains(row-i) && !subdia.contains(row+i)){
                path.addLast(i);
                col.add(i);
                maindia.add(row-i);
                subdia.add(row+i);
                bfs(row+1,path);
                subdia.remove(row+i);
                maindia.remove(row-i);
                col.remove(i);
                path.removeLast();
            }
        }
    }
     /*for (Integer num : path) {
        StringBuilder row = new StringBuilder();
        row.append(".".repeat(Math.max(0, n)));
        row.replace(num, num + 1, "Q");
        board.add(row.toString());
    }*/


    public List<String> convertBoard(Deque<Integer> path){
        List<String> li= new ArrayList<>();
        for(Integer num:path){
            StringBuilder row = new StringBuilder();
            int a = Math.max(0,n);
            String str = String.join("", Collections.nCopies(a, "0"));
            row.append(str);
            row.replace(num,num+1,"#");
            li.add(row.toString());
        }
        return li;

    }

    public static void main(String[] args) {
        No51NQueens nqueens = new No51NQueens();
        List<List<String>> ans= nqueens.solve(4);
        String s = new String();
        for(List<String> method:ans){
            System.out.println("-----分隔符-----");
            for(String str:method) System.out.println(str);
        }
    }
}
