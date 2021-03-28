package yowei.leetCode.graph.mygraph;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

//并查集实现
public class UnionFind {
    private static HashMap<Node,Node> fatherMap;            //保存任意一个节点的祖先节点
    private static HashMap<Node,Integer> sizeMap;           //保存祖先节点所在集合的元素个数

    public UnionFind(){
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
    }

    public static void makSet(Collection<Node> nodes){          //开始时所有节点为一个单独的集合
        fatherMap.clear();
        sizeMap.clear();
        for(Node node:nodes){
            fatherMap.put(node,node);               //所有节点的祖先节点为其自身
            sizeMap.put(node,1);
        }
    }

    //寻找祖先节点
    public static Node findFather(Node x){
        LinkedList<Node> stack = new LinkedList<>();            //保存查找路径上的所有子孙节点
        while(x!=fatherMap.get(x)){                         //迭代直到找到祖先节点
            stack.push(x);
            x = fatherMap.get(x);
        }
        while(!stack.isEmpty()){
            fatherMap.put(stack.pop(),x);           //修改查找路径上的所有节点的祖先节点，因为如果是刚刚合并的两个集合，
                                                    // 只有较小集合的祖先节点被正确修正
        }

        return x;               //返回祖先节点
    }

    public static boolean isSameSet(Node a,Node b){
        return findFather(a)==findFather(b);
    }

    //合并算法
    public static void union(Node a,Node b){
        if(a == null || b == null) return;
        Node aDad = findFather(a);
        Node bDad = findFather(b);

        //当两个集合的祖先节点不同时，表示为两个不同的集合
        if(aDad != bDad){
            Integer aSetSize = sizeMap.get(aDad);
            Integer bSetSize = sizeMap.get(bDad);
            if(aSetSize <= bSetSize){                       //将较小的集合合并到大集合中去
                fatherMap.put(aDad,bDad);                       //更换祖先节点
                sizeMap.put(bDad,aSetSize + bSetSize);                  //更新新集合大小
                sizeMap.remove(aDad);                       //移除较小集合的记录
            }else {
                fatherMap.put(bDad,aDad);
                sizeMap.put(aDad,bSetSize + aSetSize);
                sizeMap.remove(bDad);

            }
        }

    }
}
