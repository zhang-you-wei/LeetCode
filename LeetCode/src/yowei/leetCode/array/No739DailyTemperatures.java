package yowei.leetCode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class No739DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        //使用栈保存元素
        LinkedList<int[]> stack = new LinkedList<>();

        //每进栈一个元素，step+1,每出栈一个元素step-1
        int step = 0;
        int[] res = new int[T.length];

        //下一个元素大于栈顶元素时，出栈并输出天数，将新元素入栈
        for(int i = 0;i<T.length;i++){
            while(stack.size() >0 && T[i] > stack.peek()[0]){
                int index = stack.pop()[1];
                res[index] = i-index;
            }
            int[] cur = {T[i],i};
            stack.push(cur);
        }
        return res;
        //return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] chars = s.split(" ");
        /*int[] T = new int[chars.length];
        for (int i = 0;i< chars.length;i++) {
            T[i] = Integer.parseInt(chars[i]);
        }
        No739DailyTemperatures dt = new No739DailyTemperatures();
        int[] res = dt.dailyTemperatures(T);*/
        int a = Integer.parseInt(chars[0]);
        int b = Integer.parseInt(chars[1]);
        String c = chars[2];
        System.out.printf("a=%d,b=%d,c=%s",a,b,c);

        /*System.out.print("输入编号:");
        int a = sc.nextInt();
        System.out.print("输入年龄:");
        int b = sc.nextInt();
        System.out.print("输入姓名:");
        String c = sc.next();
        System.out.printf("a=%d,b=%d,c=%s",a,b,c);*/

    }
}
