package yowei.leetCode.graph.mygraph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {
    public static Set<Edge> primMST(Graph graph){

        HashSet<Node> nodeSet = new HashSet<>();        //已解锁的点的集合
        HashSet<Edge> edgeSet = new HashSet<>();        //已解锁的边的集合

        //用于找到所有边中的最小值
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        HashSet<Edge> res = new HashSet<>();            //保存结果

        //随便选一个节点
        for(Node node:graph.nodes.values()){

            //判断是否有森林
            if(!nodeSet.contains(node)){
                nodeSet.add(node);

                //解锁其所有的边
                for (Edge edge: node.edges){
                    if(!edgeSet.contains(edge)){
                        edgeSet.add(edge);
                        pq.add(edge);
                    }
                }

                //所有边中找到一条路径最短的
                while (!pq.isEmpty()){
                    Edge edge = pq.poll();
                    Node toNode = edge.to;

                    //若另一头在点集中，表示存在环或者重复使用了，跳过
                    if(!nodeSet.contains(toNode)){
                        nodeSet.add(toNode);
                        res.add(edge);
                        //继续解锁其他边
                        for(Edge nextEdge: toNode.edges){
                            if(!edgeSet.contains(nextEdge)){
                                edgeSet.add(nextEdge);
                                pq.add(nextEdge);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

}
