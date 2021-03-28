package yowei.leetCode.graph.mygraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class graphBFS {

    //图的广度优先遍历
    public static void bfs(Node node){
        if(node == null) return;
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();        //因为可能存在环，必须使用一个set记录已经遍历过的点

        queue.add(node);
        set.add(node);

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(cur.value + " ");
            for(Node next:cur.next_nodes){
                if(!set.contains(next)){            //set中不含该节点时才加入
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        GenerateGraph gg = new GenerateGraph();
        int[][] in = {{9,1,2},{4,1,3},{2,1,4},{1,2,5},{3,2,3},{1,3,1},{7,3,2},{4,3,4},{3,3,5}};
        Graph graph = gg.getGraph(in);
        bfs(graph.nodes.get(1));
    }

}
