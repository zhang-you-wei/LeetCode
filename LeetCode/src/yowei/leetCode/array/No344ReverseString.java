package yowei.leetCode.array;

public class No344ReverseString {
    public void reverseString(char[] s) {
        int size = s.length;
        if(size <= 1) return;
        int head=0,tail=size-1;
        while (head<tail){
            char temp = s[head];
            s[head] = s[tail];
            s[tail] = temp;
            ++head;
            --tail;
        }
    }

}
