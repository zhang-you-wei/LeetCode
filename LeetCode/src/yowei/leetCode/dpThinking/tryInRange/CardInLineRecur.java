package yowei.leetCode.dpThinking.tryInRange;

public class CardInLineRecur {
    private int count;

    public int winScore(int[] card){
        if(card == null || card.length == 0){
            return 0;
        }
        return Math.max(f(card,0,card.length - 1),s(card,0,card.length - 1));

    }

    //先手选，返回L-R范围内先手选的最大收益
    private int f(int[] card, int L, int R) {
        count++;
        if(L == R){
            return card[L];
        }

        return Math.max(
                card[L] + s(card,L+1,R),            //在L-R上先手选，就必须在L+1-R上后手选
                card[R] + s(card,L,R-1)
        );

    }

    //返回i-j范围内后手选的最大收益
    private int s(int[] card, int i, int j) {
        if(i == j){
            return 0;
        }
        return Math.min(
               f(card,i+1,j),           //在i-j上后手选，等同于在i+1，j或i,j-1上先手选
               f(card,i,j-1)           // 但对手只会给你两者中较小的那个选择
        );
    }


    public static int dpWays(int[] card){

        return 0;
    }

    public static void main(String[] args) {
        CardInLineRecur cilr = new CardInLineRecur();
        int[] card = {4,5,8,7,3,6,2,9};
        int res = cilr.winScore(card);
        System.out.println(res);
        System.out.println("count:" + cilr.count);
    }


}
