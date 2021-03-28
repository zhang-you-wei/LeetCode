package yowei.leetCode.string;

import java.util.LinkedList;

/**
 *对形如 s = "3[a2[c]]"的字符串解码
 */
public class No394DecodeString {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;


        //使用两个栈分别存放系数和最近的字符串
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();

        for(Character c : s.toCharArray()) {

            //遇到'['将系数和当前字符串分别压栈
            if(c == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());

                //压栈后清空并初始化数据
                multi = 0;
                res = new StringBuilder();
            }

            //遇到']'开始出栈
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.pop();               //当前系数
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.pop() + tmp);          //加上之前压栈的字符串
            }
            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }



    public static void main(String[] args) {
        No394DecodeString ds = new No394DecodeString();
        String res1 = ds.decodeString("yt2[zb2[h2[c]bmf3[d]]]");

        System.out.println(res1);

    }
}