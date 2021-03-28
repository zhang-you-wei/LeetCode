package yowei.leetCode.string;

import java.util.Arrays;
import java.util.HashMap;

public class BigNumberMultipy {
    public String solve (String s, String t) {
        // write code here
        HashMap<Integer,String> map = new HashMap<>();
        String op = s.length() > t.length() ? s:t;
        String str = op == s ? t: s;
        for(int i = 0;i<10;i++){
            map.put(i,mul(op,i));
        }

        String res = "0";
        for(int i = str.length()-1;i>=0;i--){
            if(str.charAt(i)  == '0') continue;
            String temp = map.get(str.charAt(i) - '0');

            for(int j = 0;j<str.length() - 1 - i;j++){
                temp += "0";
            }

            res = add(res,temp);
        }
        return res;
    }

    private String mul(String s,int k){
        StringBuilder sb = new StringBuilder();
        int len = s.length()-1,carry = 0;
        while(len >= 0){
            int mulres = (s.charAt(len--) - '0')*k + carry;
            sb.append(mulres%10);
            carry = mulres/10;
        }
        if(carry != 0 ) sb.append(carry);
        return sb.reverse().toString();
    }

    private String add(String s1,String s2){
        StringBuilder sb = new StringBuilder();
        int i = s1.length() - 1,j = s2.length() - 1,carry = 0;
        while(i>=0 || j>=0 || carry >0){
            int x1 = i>=0 ? s1.charAt(i--) - '0' : 0;
            int x2 = j>=0 ? s2.charAt(j--) - '0' : 0;
            int sum = x1 + x2 + carry;
            sb.append(sum%10);
            carry = sum/10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        BigNumberMultipy bnm = new BigNumberMultipy();
        String res = bnm.solve("733064366","459309139");
        System.out.println(res);
    }

    public static int[] bigNumberMultiply2(int[] num1, int[] num2){
        // 分配一个空间，用来存储运算的结果，num1长的数 * num2长的数，结果不会超过num1+num2长
        int[] result = new int[num1.length + num2.length];

        // 先不考虑进位问题，根据竖式的乘法运算，num1的第i位与num2的第j位相乘，结果应该存放在结果的第i+j位上
        for (int i = 0; i < num1.length; i++){
            for (int j = 0; j < num2.length; j++){
                result[i + j + 1] += num1[i] * num2[j];	 // (因为进位的问题，最终放置到第i+j+1位)
            }
        }

        //单独处理进位
        for(int k = result.length-1; k > 0; k--){
            if(result[k] >= 10){
                result[k - 1] += result[k] / 10;
                result[k] %= 10;
            }
        }
        return result;
    }
}
