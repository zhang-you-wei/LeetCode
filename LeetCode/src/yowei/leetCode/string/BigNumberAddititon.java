package yowei.leetCode.string;

public class BigNumberAddititon {
    public String add(String s1,String s2){
        StringBuilder sb = new StringBuilder();
        int i = s1.length() - 1,j = s2.length() - 1,carry = 0;

        while(i >=0 || j >= 0 || carry == 1){
            int a1 = i >= 0 ? s1.charAt(i--) - '0' : 0;
            int a2 = j >= 0 ? s2.charAt(j--) - '0' : 0;
            sb.append((a1 + a2 + carry)%10);
            carry = (a1 + a2 + carry)/10;
        }

        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        BigNumberAddititon bna = new BigNumberAddititon();
        String res = bna.add("99999", "199999999999999999");
        System.out.println(res);
        //System.out.println(Math.max(2,2));
    }
}
