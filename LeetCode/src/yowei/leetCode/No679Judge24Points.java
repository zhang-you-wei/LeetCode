package yowei.leetCode;

import java.util.*;
/**
    
 
*/
public class No679Judge24Points {
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;
    Deque<Double> numdeq;
    Deque<Character> opdeq;


    public boolean solve(int[] nums){
        numdeq = new ArrayDeque<>();
        opdeq = new ArrayDeque<>();

        List<Double> li = new ArrayList<>();
        for (int x:nums){
            li.add((double)x);
        }
        return calculate(li);


    }

    public boolean calculate(List<Double> li){
        if(li.size()==1 ) {
            return Math.abs(li.get(0) - TARGET) < EPSILON;   }
        int size = li.size();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i!=j){
                    List<Double> li2 = new ArrayList<>();
                    for(int k=0;k<size;k++){
                        if(k!=i && k!=j) li2.add(li.get(k));
                    }
                    for(int k=0;k<4;k++){
                        if (k < 2 && i > j) {
                            continue;
                        }
                        if(k==ADD) {
                            opdeq.addLast('+');
                            li2.add(li.get(i) + li.get(j));
                        }
                        else if(k==MULTIPLY) {
                            opdeq.addLast('*');
                            li2.add(li.get(i) * li.get(j));
                        }
                        else if(k==SUBTRACT) {
                            opdeq.addLast('-');
                            li2.add(li.get(i) - li.get(j));
                        }
                        else {
                            if(Math.abs(li.get(j))<EPSILON) continue;
                            opdeq.addLast('/');
                            li2.add(li.get(i) / li.get(j));
                        }
                        numdeq.addLast(li.get(i));
                        numdeq.addLast(li.get(j));

                        if(calculate(li2)) return true;

                        else{
                            li2.remove(li2.size() - 1);
                            numdeq.removeLast();
                            numdeq.removeLast();
                            opdeq.removeLast();
                        }

                    }
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] aa = {6,5,12,7};
        No679Judge24Points judge = new No679Judge24Points();
        StringBuilder res = new StringBuilder();
        boolean flag = judge.solve(aa);
        while (judge.opdeq.size()>0 && judge.numdeq.size()>1) {
            res.append(judge.numdeq.pollFirst());
            res.append(judge.opdeq.pollFirst());
            res.append(judge.numdeq.pollFirst()+"  ");
        }
        System.out.println(flag);

        System.out.println(res.toString());


    }
}
