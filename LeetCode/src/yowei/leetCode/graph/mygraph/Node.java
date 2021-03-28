package yowei.leetCode.graph.mygraph;

import java.util.ArrayList;

public class Node {
    public int value;       //节点值
    public int in_degree;           //入度数
    public int out_degree;          //出度数
    public ArrayList<Node> next_nodes;           //直接相邻的顶点集合
    public ArrayList<Edge> edges;           //该节点引出的边集合

    public Node(int value){
        this.value = value;
        in_degree = 0;
        out_degree = 0;
        next_nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

}
