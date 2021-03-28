package yowei.leetCode.array;

public class Offer39NumberOfHalfLength {
    public int majorityElement(int[] nums) {
        int[] map = {0,0};
        for(int i = 0;i<nums.length;i++){
            if(map[1] == 0){
                map[0] = nums[i];
                map[1] += 1;
            }
            else if(map[0] == nums[i]){
                map[1] +=1;
            }else{
                map[1] -= 1;
            }
        }
        return map[0];
    }

    public static void main(String[] args) {
        int[] arr = {6,5,5};
        Offer39NumberOfHalfLength onl = new Offer39NumberOfHalfLength();
        int res = onl.majorityElement(arr);
        System.out.println(res);
    }
}
