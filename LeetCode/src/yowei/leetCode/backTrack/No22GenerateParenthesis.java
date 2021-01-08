package yowei.leetCode.backTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
    括号的产生，返回n对括号可以产生的所有的组合形式
 */


//动态规划方法:自底向上，第n对括号的形式取决于剩下n-1对括号的分配形式，即分配给中间和右边的总数为n-1
public class No22GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        ArrayList<String> zero = new ArrayList<>();
        if(n == 0) return zero;
        zero.add("");
        map.put(0,zero);

        //自底向上迭代
        for (int i = 1; i <= n; i++) {
            ArrayList<String> nstrigs = new ArrayList<>();
            for (int mid = 0; mid < i; mid++) {
                int right = i - mid - 1;
                List<String> midStrings = map.get(mid);
                List<String> rightstrings = map.get(right);
                for (String str1 : midStrings) {
                    for (String str2 : rightstrings) {
                        nstrigs.add("(" + str1 + ")" + str2);
                    }
                }
            }
            map.put(i,nstrigs);
        }
        return map.get(n);
    }


    /*
        动态规划不是本题的最优解，时间复杂度为O(4n次)
        使用回溯+剪枝效率更高
        回溯即深度搜索优先为暴力解法，在暴力解法的基础上剪枝优化
        暴力解法从左到右一个一个的填左括号或右括号，如果已填入的右括号数大于左括号数，则不符合条件直接返回，
        当右括号数等于n时产生一个解录入答案，
        剪枝实际上严格了括号生成规则，当左括号数小于n时可以填入一个左括号，当右括号数小于左括号数时可以填入一个右括号，
        这样就能保证每次填入必是有效的填入

     */
    public List<String> generateParenthesis2(int n){
        ArrayList<String> res = new ArrayList<>();
        backTrack(res,"",0,0,n);
        return  res;
    }

    /**
     * @param res：结果集
     * @param cur：当前生成的括号形式
     * @param left：左括号数量
     * @param right：右括号数量
     * @param n：括号总数
     */
    private void backTrack(List<String> res,String cur,int left,int right,int n){
        //递归结束条件
        if(right == n) {
            res.add(cur);
            return;
        }

        //当左括号数小于n时可以填一个，
        if(left < n){
            //回溯时尽量不改变中间变量的值，不然对后续操作产生影响
            //cur += "(";
            backTrack(res,cur + "(",left+1,right,n);
            //若使用cur += "(";则在一个分支执行完成后中间变量要回到原状态，即回溯，不管本次递归后面的结果如何
            //将本次递归结果一刀切开，继续进行后面的探索
        }

        if(right < left){
            backTrack(res,cur + ")",left,right+1,n);
        }
    }




    public static void main(String[] args) {
        No22GenerateParenthesis no22 = new No22GenerateParenthesis();
        int n = 3;
        //long start = System.currentTimeMillis();
        List<String> s1 = no22.generateParenthesis2(n);
        //long mid = System.currentTimeMillis();
        //List<String> s2 = no22.generateParenthesis(n);
        //long end = System.currentTimeMillis();
        System.out.println(s1.toString());

    }
}
