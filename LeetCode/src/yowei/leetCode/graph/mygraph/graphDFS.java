package yowei.leetCode.graph.mygraph;

import java.util.HashSet;
import java.util.LinkedList;

public class graphDFS {
    public static void dfs(Node node){
        if(node == null) return;
        LinkedList<Node> stack = new LinkedList<>();            //使用栈进行dfs
        HashSet<Node> set = new HashSet<>();

        stack.push(node);
        set.add(node);
        System.out.print(node.value + " ");
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            for(Node next: cur.next_nodes){
                if(!set.contains(next)){
                    stack.push(cur);            //需要将上一级节点压栈
                    stack.push(next);
                    set.add(next);
                    System.out.print(next.value + " ");
                    break;              //找到一条路径后不需要再在同一层次查找
                }
            }
        }
    }

    public static void main(String[] args) {
        GenerateGraph gg = new GenerateGraph();
        int[][] in = {{9,1,2},{4,1,3},{2,1,4},{1,2,5},{3,2,3},{1,3,1},{7,3,2},{4,3,4},{3,3,5}};
        Graph graph = gg.getGraph(in);
        dfs(graph.nodes.get(1));
    }

}
