package coreJava;

import static java.util.Collections.reverse;

public class ReverseWord {
    public static void main(String[] args) {
        String str="Australia won the world cup match";
        char [] ch= str.toCharArray();
        String ans="";
        for (int i = 0; i < ch.length ; i++) {
            if (ch[i]!=' '){
                ans+=ch[i];
            }else {
                ans= reverse(ans);
                System.out.print(ans+" ");
                ans="";
            }


        }
        System.out.println(reverse(ans));
    }
    public static String reverse(String ans){
        String s="";
        for(int i=ans.length()-1;i>=0;i--){
            s+=ans.charAt(i);
        }
        return s;


    }
}
