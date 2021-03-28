package yowei.leetCode.interview;


import java.util.*;


class Node {
    public int value;

    public ArrayList<Node> next_nodes;
    public ArrayList<MyEdge> edges;

    public Node(int value){
        this.value = value;
        next_nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

}

class MyEdge {
    public Node from;
    public Node to;

    public MyEdge( Node from, Node to){
        this.from = from;
        this.to = to;
    }
}

class Graph {
    public HashMap<Integer, Node> nodes;        
    public HashSet<MyEdge> edges;           

    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

}





public class Main1 {
    public static int  bfs(Node node){
        if(node == null) return 0 ;
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();

        int res = 0;
        queue.add(node);
        set.add(node);

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            res++;
            System.out.print(cur.value + " ");
            for(Node next:cur.next_nodes){
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0;i<T;i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            Graph graph = new Graph();
            for(int j = 0;j<M;j++) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                if (!graph.nodes.containsKey(from)) {
                    graph.nodes.put(from, new Node(from));
                }

                if (!graph.nodes.containsKey(to)) {
                    graph.nodes.put(to, new Node(to));
                }

                Node fromNode = graph.nodes.get(from);
                Node toNode = graph.nodes.get(to);

                MyEdge newEdge = new MyEdge(fromNode, toNode);

                fromNode.next_nodes.add(toNode);
                fromNode.edges.add(newEdge);

                graph.edges.add(newEdge);
            }

            for(MyEdge edge: graph.edges){
                HashSet<MyEdge> myEdges = new HashSet<>();
                for(MyEdge outedge: graph.edges){
                    if(outedge == edge) continue;
                    myEdges.add(outedge);
                }
                int nums = bfs(graph.nodes.get(1));
                if(nums != N) {
                    System.out.println("No");
                    break;
                }
                else {
                    System.out.println("Yes");
                    break;
                }
            }
            
        }
    }
}
