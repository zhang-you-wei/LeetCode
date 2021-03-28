package yowei.leetCode.design;

import java.util.LinkedList;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value需要返回 -1
 *
 */
public class Offer59MaxOfQueue {
    LinkedList<Integer> queue;
    LinkedList<Integer> maxQueue ;      //存放最大值，按照非降序插如队列


    public Offer59MaxOfQueue() {
        queue  = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if(maxQueue.isEmpty()){
            return -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        if(maxQueue.isEmpty() || value <= maxQueue.peekLast()){         //如果新值小于maxQueue任何一个，直接插入到尾部
            maxQueue.add(value);
        }else{                                  //否则需要将maxQueue小于新值的先删除，再添加新值
            int k = 0;
            int size = maxQueue.size();
            for(int i = 0;i < size;i++){
                if(value > maxQueue.get(i)){
                    k = i;
                    break;
                }
            }
            for(int i = k;i<size;i++){
                maxQueue.removeLast();
            }
            maxQueue.add(value);
        }
    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        int x = queue.poll();
        if(maxQueue.peekFirst() == x){          //如果删除的是新值，则maxQueue需要更新最大值
            maxQueue.poll();
        }
        return x;
    }
}
