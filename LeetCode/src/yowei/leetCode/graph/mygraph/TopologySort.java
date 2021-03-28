package yowei.leetCode.graph.mygraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologySort {

    //拓扑排序：针对有向无环图
    public static List<Node> topSort(Graph graph){
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Integer> map = new HashMap<>();       //map存储每个节点的入度数

        LinkedList<Node> res = new LinkedList<>();
        for(Node node : graph.nodes.values()){
            if(node.in_degree == 0){
                queue.add(node);            //入度为0的节点接入队列
            }else {
                map.put(node, node.in_degree);
            }
        }
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            res.add(cur);
            for (Node next: cur.next_nodes){
                if(map.get(next) - 1 == 0){         //入度为0的节点出队后，与之相连的所有后继节点的入度减一，然后判断是否加入队列
                    map.remove(next);
                    queue.add(next);
                }else {
                    map.put(next,map.get(next) - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GenerateGraph gg = new GenerateGraph();
        int[][] in = {{9,1,2},{4,1,3},{2,2,3},{1,3,4},{3,3,5},{1,5,7},{7,7,6},{4,4,6}};
        Graph graph = gg.getGraph(in);
        List<Node> nodes = topSort(graph);
        for(Node node : nodes){
            System.out.print(node.value + " ");
        }
    }
}
