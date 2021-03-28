package yowei.leetCode.twoPointer;

import java.util.ArrayList;

//找到和为target的自然数连续子序列
public class Offer57SubSeqOfSumS {
    public int[][] findContinuousSequence(int target) {
        int end = (target + 1)/2 ;      //最大不可能超过一半值
        int left = 1,right = 1;
        ArrayList<int[]> res = new ArrayList<>();

        while(left <= right && left <= end && right <= end){
            int n = right - left + 1;
            int cur = n*(n-1)/2 + n*left;
            if(cur == target){
                int[] ans = new int[right - left + 1];
                for (int i = left; i <= right; ++i) {
                    ans[i - left] = i;
                }
                res.add(ans);
                left++;
            }
            else if(cur < target){
                right++;
            }else{
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);


    }
}
