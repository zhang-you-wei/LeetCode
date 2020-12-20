package yowei.leetCode.linkedList;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 最近最少使用缓存机制
 * 容量有限的容器，超过容量时优先删除最先使用过的元素
 * 使用Hash表和双向链表实现
 */
public class No146LRUCache {
    private HashMap<Integer,Integer> map ;
    private LinkedList<Integer> queue ;
    private int cap ;

    public No146LRUCache(int capacity) {
        this.map = new HashMap<Integer,Integer>(capacity);
        this.queue = new LinkedList<Integer>();
        this.cap = capacity;
    }

    /**
     * 获取元素后将该元素重新排列到队尾
     */
    public int get(int key) {
        if(map.containsKey(key)) {
            queue.remove(Integer.valueOf(key));
            queue.add(key);
            return map.get(key);
        }
        return -1;

    }

    /**
     * 添加元素时若超出容量，则删除队首值所代表的元素，并将新元素添加到队尾
     */
    public void put(int key, int value) {
        if(map.containsKey(key)) queue.remove(Integer.valueOf(key));
        else{
            if(queue.size() >= cap)  map.remove(queue.poll());
        }
        queue.add(key);
        map.put(key,value);
    }
}
