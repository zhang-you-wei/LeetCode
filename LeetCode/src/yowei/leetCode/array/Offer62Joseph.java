package yowei.leetCode.array;

import java.util.ArrayList;

public class Offer62Joseph {

    //暴力搜索1
    public int lastRemaining(int n, int m) {
        boolean[] flag = new boolean[n];
        int size = n;

        for(int i = 0;;){
            int times = m % (size) == 0 ? size : m % (size);
            for(int j = 0;j < times;){
                i = i%(n);
                if(!flag[i++]){
                    j++;
                }
            }
            i = (i-1)%n;
            flag[i] = true;
            size--;
            if(size == 1) break;
            i++;
        }
        for(int i = 0;i<n;i++){
            if(!flag[i]) return i;
        }
        return -1;
    }

    //可变数组，还是很慢
    public int lastRemaining2(int n, int m) {
        ArrayList<Integer> rest = new ArrayList<>();
        for(int i = 0;i < n;i++){
            rest.add(i);
        }
        int start = 0;
        while(rest.size() > 1){
            int size = rest.size();
            int times = m % size == 0 ? size : m % size;            //叫号的次数
            int target = (start + times - 1) % size ;               //找到叫到m的那个人
            rest.remove(target);
            start = Math.min(target, rest.size());              //下一轮叫号开始的那个人，即死掉的人的下一个
        }
        return rest.get(0);
    }

    //递归，堆栈深度太高
    //返回n个人叫号最后存活的那一个人（下标）
    public int lastRemaining3(int n, int m) {
        if(n == 1) return 0;
        int x = lastRemaining3(n-1,m);          //n - 1个人叫号最后存活的那一个编号
        return (m + x) % n;                     //以m%n作为起点考察n-1个人的存活的人的位置
    }


    //将递归改为迭代
    public int lastRemaining4(int n, int m) {
        int target = 0;
        for(int i = 2;i<=n;i++){
            target = (m + target) % i;
        }
        return target;
    }


    public static void main(String[] args) {
        Offer62Joseph jos = new Offer62Joseph();
        int res = jos.lastRemaining4(70866,116922);
        System.out.println(res);

    }
}
