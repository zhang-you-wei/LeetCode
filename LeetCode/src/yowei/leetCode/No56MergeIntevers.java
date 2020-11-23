package yowei.leetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 合并区间
 * 先排序，然后挨个比较
 * 复习快排的写法
 */
public class No56MergeIntevers {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(len <= 0) return null;

        /*使用工具排序，可以通过数组元素的泛型进行比较
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });*/

        //快速排序
        quickSort(intervals,0,len - 1);


        ArrayList<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        //相邻区间挨个比较
        for (int i = 1; i < len; i++) {
            int later = res.get(res.size() - 1)[1];
            if(intervals[i][0] > later){
                res.add(intervals[i]);
            }
            res.get(res.size() - 1)[1] = Math.max(later,intervals[i][1]);
        }
        /*
        int size = res.size();
        int[][] resArr = new int[size][];
        for (int i = 0; i < size; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;*/

        //记住，转二维数组技巧
        return res.toArray(new int[0][]);
    }


    //快速排序
    public void quickSort(int[][] intervals,int lo,int hi){
        if(lo >= hi) return;

        int mid = partiton(intervals,lo,hi);

        //各部分分别排序
        quickSort(intervals,lo,mid - 1);
        quickSort(intervals,mid + 1,hi);
    }


    //快排实现
    public int partiton(int[][] intervals,int lo,int hi){

        //哨兵
        int pivot = intervals[lo][0];

        //和哨兵交换的位置
        int exchPlace = lo + 1;
        
        //向右遍历
        for (int i = lo + 1; i <= hi; i++) {
            if(intervals[i][0] < pivot){
                exch(intervals,exchPlace,i);
                exchPlace++;
            }
        }
        exch(intervals,lo,exchPlace - 1);
        return exchPlace - 1;

    }

    public void exch(int[][] intervals,int i,int j){
        int[] temp = intervals[i];
        intervals[i] = intervals[j];
        intervals[j] = temp;
    }

    public static void main(String[] args) {
        int[][] x = {{3,7},{1,5},{2,4},{6,8},{4,9}};
        No56MergeIntevers mi = new No56MergeIntevers();
        int[][] res = mi.merge(x);
        for (int[] a : res) {
            System.out.println(Arrays.toString(a));
        }
    }


}
