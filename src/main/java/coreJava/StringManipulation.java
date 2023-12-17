package coreJava;

public class StringManipulation {
    public static void main(String[] args) {
        String str="abcdabcde";
        String str1="ade";
        System.out.println(str+str1);
        System.out.println(str1+str);
        //Reverse
        String ans="";
        for (int i=0;i<str.length();i++){
            ans=str.charAt(i)+ans;
        }
        System.out.println(ans);

        //contains

        if(str.contains(str1)){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }



}
