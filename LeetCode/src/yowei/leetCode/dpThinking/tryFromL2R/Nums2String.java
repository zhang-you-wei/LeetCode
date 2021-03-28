package yowei.leetCode.dpThinking.tryFromL2R;

//给一串数字，将其翻译成26个字母
public class Nums2String {
    public int nums2str(String nums){
        char[] chars = nums.toCharArray();
        return process(chars,0);
    }

    /**
     *
     * @param chars:
     * @param i:从位置i开始往后考虑
     * @return:返回从位置i开始的子串能够翻译的字母组合的个数
     */
    private int process(char[] chars, int i) {
        //基本情况
        if(i >= chars.length){
            return 1;
        }

        //单独一个0不能翻译成任何字母,或以0开头的字符串不能翻译成任何字母组合
        if(chars[i] == '0'){
            return 0;
        }
        int res = 0;

        //取决于i位置能否和后面的组成一个字母表示，而且新字母对多样性不会产生影响
        if(chars[i] == '1'){
            res += process(chars,i+1);
            if((i + 1) < chars.length){
                res += process(chars,i+2);
            }
        }else if(chars[i] == '2'){
            res += process(chars,i+1);
            if((i + 1) < chars.length && chars[i+1]<='6' && chars[i + 1] >='0' ){
                res += process(chars,i+2);
            }
        }else{
            res += process(chars,i+1);
        }
        return res;
    }

    public int dpWays(String nums){
        char[] chars = nums.toCharArray();
        int len = chars.length;
        int[] dp = new int[len + 1];
        dp[len] = 1;
        for(int i = len-1;i>=0;i--){
            if(chars[i] == '0'){
                dp[i] = 0;          //以0开头的数字串不能翻译成任何字母组合
            }else if(chars[i] == '1'){
                dp[i] = dp[i+1];
                if(i+1 < len ){
                    dp[i] += dp[i+2];
                }
            }else if(chars[i] == '2'){
                dp[i] = dp[i+1];
                if((i+1)<len && chars[i+1] <= '6' && chars[i+1] >='0'){
                    dp[i] += dp[i+2];
                }
            }else {
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Nums2String ns = new Nums2String();
        int res = ns.dpWays("121321");
        int res2 = ns.nums2str("121623");
        System.out.println(res);
        System.out.println(res2);
    }
}
