package yowei.leetCode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 会议安排
 */
public class No253MeetingRoomsII {
    /**
     * 堆方法，每次出来一个结束时间最早的会议室
     */
    public int minMeetingRooms(int[][] intervals) {
        //二维数组排序
        Arrays.sort(intervals,(v1, v2) -> v1[0] - v2[0]);
        //ArrayList<Integer> rooms = new ArrayList<>();
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        //按次序分配会议室
        for(int i = 0; i < intervals.length;i++){
            if(i==0) {
                rooms.add(intervals[0][1]);
                continue;
            }
            // boolean flag = true;
            // for(int j = 0;j<rooms.size();j++){
            //     if(intervals[i][0] >= rooms.get(j)){
            //         rooms.set(j,intervals[i][1]);
            //         flag  = false;
            //         break;
            //     }
            // }
            // if(flag) rooms.add(intervals[i][1]);

            //用结束时间标识该会议室，新来的若小于这个值，必须重开一间，否则更新结束时间，最后统计创建的元素个数
            if(rooms.peek() <= intervals[i][0]){
                rooms.poll();
            }
            rooms.add(intervals[i][1]);

        }
        return rooms.size();
    }

/*##################################################################################################*/

    /**
     * 有序化方法
     */
    public int minMeetingRooms2(int[][] intervals) {
        if (intervals.length == 0) return 0;

        //两个数组分别存储会议开始时间和结束时间，并进行排序
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0;i < intervals.length;i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int res = 0;
        int j = 0;
        //遍历数组，当开始时间小于结束时间时，需要新建一个会议室，大于时表示有空闲的会议室，并将结束时间数组后移一个表示当前的已经被占用了
        for (int k = 0;k < intervals.length;k++) {
            if (start[k] >= end[j]) {
                j++;
            }else {
                res++;
            }
        }
        return res;
    }

}
