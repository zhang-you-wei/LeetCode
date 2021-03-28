package yowei.leetCode.graph.mygraph;

public class GenerateGraph {

    public Graph getGraph(int[][] matrix){
        Graph graph = new Graph();
        for (int[] ints : matrix) {
            int weight = ints[0];
            int from = ints[1];
            int to = ints[2];

            //将新点加入graph的点集
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }

            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);

            //建立新边
            Edge newEdge = new Edge(weight, fromNode, toNode);

            //增加起始点信息
            fromNode.next_nodes.add(toNode);
            fromNode.edges.add(newEdge);
            fromNode.out_degree++;

            //增加终止点信息
            toNode.in_degree++;

            //graph中加入新边
            graph.edges.add(newEdge);
        }

        return graph;

    }

}
