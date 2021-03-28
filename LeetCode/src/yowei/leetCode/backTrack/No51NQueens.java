package yowei.leetCode.backTrack;

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
        //列数从0到n
        for(int i=0;i<n;i++){
            //如果该行该位置对应的列，主对角线及副对角线都不含该元素，则可以添加下一个元素
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


    public static int bitWay(int n){
        if(n < 1 || n>32){
            return 0;
        }

        int limit = n == 32 ? -1 : (1<<n) - 1;

        //返回三种约束全为0的方案数，即初始时什么都不填
        return process(limit,0,0,0);


    }

    //返回在三种约束下可行的方案数
    private static int process(int limit, int colLmt, int mainDiaLmt,int subDiaLmt) {
        if(colLmt == limit) return 1;

        int pos = (~(colLmt | mainDiaLmt | subDiaLmt)) & limit;     //得到可填的位置

        int rightMost = 0;
        int res= 0;

        while (pos != 0){
            rightMost = pos & (~pos + 1);       //每个可填的位置试一次
            pos = pos - rightMost;              //更新可填的位置
            res += process(limit,                   //返回填完之后后续的结果
                    colLmt | rightMost,
                    (mainDiaLmt | rightMost) >>> 1,
                    (subDiaLmt | rightMost) << 1
            );
        }
        return res;
    }

    public static void main(String[] args) {
//        No51NQueens nqueens = new No51NQueens();
//        List<List<String>> ans= nqueens.solve(4);
//        String s = new String();
//        for(List<String> method:ans){
//            System.out.println("-----分隔符-----");
//            for(String str:method) System.out.println(str);
//        }
        int res = bitWay(13);
        System.out.println(res);
    }
}
