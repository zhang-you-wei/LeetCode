package yowei.leetCode.sort;

import java.util.Arrays;

public class Kth {
    public int findKth(int[] a, int n, int K) {
        // write code here
        //快速排序，缩短区间，每次只用求取一段，当交换点刚好为K+1时，返回排序后的第k个元素
        quickSort(a,K,0,n-1);
        return a[K - 1];
    }

    private void quickSort(int[] a,int k,int start,int end){
        if(start >= end) return;
        int pivot = a[start];
        int exp = start + 1;
        for(int i = start+1;i<=end;i++){
            if(a[i] <= pivot) {
                swap(a,exp,i);
                exp++;
            }
        }
       swap(a,start,exp - 1);
//        quickSort(a,k,start,exp - 2);
//        quickSort(a,k,exp,end);
        if(exp == k) return;
        if(exp > k) quickSort(a,k,start,exp-2);
        else quickSort(a,k,exp,end);
    }

    private void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Kth kth = new Kth();
//        int[] x = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,
//                1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,
//                1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        int[] x = {1,3,5,2,2};
        int[] y = Arrays.copyOf(x,x.length);
        Arrays.sort(y);
        int res = kth.findKth(x, x.length, 2);
        System.out.println(y[2]);
        System.out.println(Arrays.toString(x));
        System.out.println(res);
//        System.out.println(Arrays.toString(x));
//        System.out.println(Arrays.toString(y));

    }
}
