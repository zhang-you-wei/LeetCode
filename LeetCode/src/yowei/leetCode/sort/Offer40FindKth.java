package yowei.leetCode.sort;

import java.util.Arrays;

public class Offer40FindKth {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        process(arr,0,arr.length -1,k - 1);
        if (k >= 0) System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    private void process(int[] arr,int L,int R,int k){
        int mid = partion(arr,L,R);
        if(mid == k){
            return;
        }
        else if(mid > k){
            process(arr,L,mid - 1,k);
        }else{
            process(arr,mid + 1,R,k);
        }
    }

    private int partion(int[] arr,int L,int R){
        if(L == R) return L;
        int pivot = arr[L];
        int exp = L + 1;
        for(int i = L + 1;i<=R;i++){
            if(arr[i] <= pivot){
                swap(arr,i,exp++);
            }
        }
        swap(arr,L,exp -1);
        return exp - 1;
    }

    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Offer40FindKth fk = new Offer40FindKth();
        int[] in = {3,2,4,1,8,6,7};
        int[] res = fk.getLeastNumbers(in, 5);
        System.out.println(Arrays.toString(res));
    }
}
