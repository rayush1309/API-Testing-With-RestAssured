package coreJava;

import java.util.Arrays;

public class sorting {
    public static void main(String[] args) {
        int [] arr ={3,4,4,2,1,6,9};
        for (int i=0;i< arr.length-1;i++){
            if (arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
