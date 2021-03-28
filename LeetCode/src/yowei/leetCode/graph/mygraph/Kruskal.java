package yowei.leetCode.graph.mygraph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Kruskal {
    public static Set<Edge> kruskalMST(Graph graph){
        UnionFind.makSet(graph.nodes.values());
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        pq.addAll(graph.edges);
        HashSet<Edge> res = new HashSet<>();

        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            if(!UnionFind.isSameSet(edge.from,edge.to)){
                res.add(edge);
                UnionFind.union(edge.from,edge.to);
            }
        }

        return res;
    }
}
