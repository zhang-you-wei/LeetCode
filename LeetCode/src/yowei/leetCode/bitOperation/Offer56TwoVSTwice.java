package yowei.leetCode.bitOperation;

import java.util.ArrayList;
import java.util.Arrays;

public class Offer56TwoVSTwice {
    public static int[] singleNumbers(int[] nums) {
        int two = 0;
        for(int num:nums){
            two ^= num;
        }

        int point = 0;
        for(int i = 0;i<32;i++){
            if((two & 1) == 1){
                point = i;
                break;
            }
            two >>>= 1;
        }
        int p = (1 << point);

        ArrayList<Integer> setOne = new ArrayList<>();
        ArrayList<Integer> setTwo = new ArrayList<>();
        for(int num:nums){
            if((num & p) == 0){
                setOne.add(num);
            }else{
                setTwo.add(num);
            }
        }
        int res1 = 0,res2 = 0;
        for(Integer i:setOne){
            res1 ^= i;
        }
        for(Integer i:setTwo){
            res2 ^= i;
        }
        return new int[]{res1,res2};

    }

    public static void main(String[] args) {
        int[] arr = {1,2,10,4,1,4,3,3};
        int[] res = singleNumbers(arr);
        System.out.println(Arrays.toString(res));

    }
}
