package yowei.leetCode.string;

public class Offer58 {
    public String reverseLeftWords(String s, int n) {
        if(n == 0) return s;
        return s.substring(n) + s.substring(0,n);

    }
}
