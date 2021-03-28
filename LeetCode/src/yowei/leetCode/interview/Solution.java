package yowei.leetCode.interview;

import java.util.Arrays;

public class Solution {
    /**
     * 将输入的十进制数字转换为对应的二进制字符串和十六进制字符串
     * @param number string字符串 十进制数字字符串
     * @return string字符串
     */
    public String changeFormatNumber (String number) {
        // write code here
        if(!number.matches("-?\\d+")){
            return "INPUTERROR";
        }
        char[] chars = new char[16];
        Integer num = Integer.valueOf(number);
        if(num > 32767 || num < -32768) return "NODATA";

        if(num < 0) Arrays.fill(chars,'1');
        else Arrays.fill(chars,'0');
        String s = Integer.toBinaryString(num);
        int k = 15,p = s.length() - 1;
        while (p >= 0 && k >= 0){
            chars[k--] = s.charAt(p--);
        }

        
        char[] sixteen = new char[4];
        for(int i = 0;i<4;i++){
            int sum = 0;
            for(int j = 4*i;j<4*(i+1);j++){
                sum = sum*2 + chars[j] - '0';
            }
            if(sum < 10){
                sixteen[i] = (char) ('0' + sum);
            }else {
                sixteen[i] = (char) ('A' + sum - 10);
            }
        }
        String binary = new String(chars);
        String sixteenBinary = new String(sixteen);

        return binary + "," + sixteenBinary;
    }

    public static void main(String[] args) {
        String number = "-655585";

        Solution sl = new Solution();
        String res = sl.changeFormatNumber("-1");
        System.out.println(res);
    }
}
