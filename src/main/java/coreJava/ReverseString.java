package coreJava;

public class ReverseString {
    public static void main(String[] args) {
        String name= "ayush Raj";
        String rev="";
        for (int i=0;i<name.length() ;i++){
            rev= name.charAt(i)+rev;
        }
        System.out.println(rev);
    }
}
