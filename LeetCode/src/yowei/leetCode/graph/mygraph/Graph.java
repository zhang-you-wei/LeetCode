package yowei.leetCode.graph.mygraph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer,Node> nodes;         //根据value值找到对应Node,不能使用set，因为两个value值也会new出两个不同的Node
    public HashSet<Edge> edges;           //所有的边集合

    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

}
