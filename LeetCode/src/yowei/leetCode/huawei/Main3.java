package yowei.leetCode.huawei;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        LinkedList<Integer> li = new LinkedList<>();
        for(int i = 0;i< 5;i++){
            li.add(sc.nextInt());
        }
//        while (sc.hasNextInt()){
//            li.add(sc.nextInt());
//        }
        PriorityQueue<ArrayList<Integer>> resPQ = new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int sum1 = 0,sum2 = 0;
                for(Integer x: o1){
                    sum1 += x;
                }
                for (Integer x:o2){
                    sum2 += x;
                }
                return sum1 - sum2;
            }
        });

        li.sort(Collections.reverseOrder());
        for(int i = 0;i<m;i++){
            ArrayList<Integer> resList = new ArrayList<>();
            if(!li.isEmpty()) {
                resList.add(li.removeFirst());
                resPQ.add(resList);
            }
            else break;
        }
        while (!li.isEmpty()){
            ArrayList<Integer> poll = resPQ.poll();
            poll.add(li.removeLast());
            resPQ.add(poll);
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<ArrayList<Integer>> tmp = new LinkedList<>();
        tmp.addAll(resPQ);

        int sum = 0;
        for(Integer x:tmp.getLast()){
            sum += x;
        }
        System.out.println(sum);
        for(ArrayList<Integer> x:resPQ){
            System.out.print(Arrays.toString(x.toArray()));
        }
    }
}
