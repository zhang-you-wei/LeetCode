package yowei.leetCode.interview;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ProcessTime {
    public int minimumProcessTime (int[] jobs, int k) {
        // write code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(jobs);
        for(int i = jobs.length -1 ; i>=0 ; i--){
            if(i> jobs.length - 1 - k){
                pq.add(jobs[i]);
            }else{
                pq.add(pq.poll() + jobs[i]);
            }
        }
        int res = 0;
        while(!pq.isEmpty()){
            res = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        ProcessTime pt = new ProcessTime();
        int[] arr = {1,2,4,7,8};
        int i = pt.minimumProcessTime(arr, 2);
        System.out.println(i);

    }
}
