package yowei.leetCode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class No406QReconbyHeight {
     public int[][] reconstructQueue(int[][] people) {
         //将初始数组排序，身高从高到低，身高相同时k小的排在前面
         Arrays.sort(people,(a1,a2) ->{
             if(a1[0] == a2[0]){
                 return a1[1] - a2[1];
             }
             return a2[0] - a1[0];
         });

         //从前到后插队
         for(int i = 1;i<people.length;i++){
             int index = people[i][1];

             //插入排序，index开始的位置向后挪
             int[] cur = people[i];
             for(int j = i;j>index;j--){
                 people[j] = people[j - 1];
             }
             people[index] = cur;
         }

         return people;
     }

    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);                 //add方法直接插入到指定位置并将其他元素后移
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
