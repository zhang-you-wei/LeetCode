package yowei.leetCode.recursiveTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class FindLeafOfBST {
    public int[] findLeaf(int[] bst){
        ArrayList<Integer> ans = new ArrayList<>();
        process(bst,0, bst.length- 1,ans);
        int[] res = new int[ans.size()];
        for(int i = 0;i< ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    private void process(int[] bst,int L, int R, ArrayList<Integer> result){

        if(L == R){
            result.add(bst[L]);
            return;
        }

        int father = bst[L];

        if(bst[L+1] > father || bst[R] <= father){          //只有一侧有子树
            process(bst,L + 1,R,result);
        }
        else {
            int pos = -1;
            for(int i = L;i<=R;i++){
                if(bst[i] > father){        //找到右子树位置
                    pos = i;
                    break;
                }
            }
            process(bst,L+1,pos-1,result);      //递归处理左子树
            process(bst,pos,R,result);                  //递归处理右子树
        }
    }

    public static void main(String[] args) {
        int[] input = {8,6,3,4,7,13,10,15};
        FindLeafOfBST flob = new FindLeafOfBST();
        int[] res = flob.findLeaf(input);
        System.out.println(Arrays.toString(res));
    }
}
