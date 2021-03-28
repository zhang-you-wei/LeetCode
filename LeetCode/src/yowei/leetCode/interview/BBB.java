package yowei.leetCode.interview;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class BBB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[][] games = new int[m][2];
        LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
        for(int i = 0;i<n;i++){
            graph.add(i,new LinkedList<>());
        }

        for(int i = 0;i< m;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from - 1).add(to);
        }

        HashSet<Integer> set = new HashSet<>();

        while (graph.get(p-1).size() > 0){
            for(int i = 0;i<n;i++){
                if(graph.get(i) != null && graph.get(i).size() == 0){
                    set.add(i);
                }
            }
            for(Integer x:set){
                for(int i=0;i<n;i++){
                    graph.get(i).remove(Integer.valueOf(x));
                }
            }
        }





    }
}
