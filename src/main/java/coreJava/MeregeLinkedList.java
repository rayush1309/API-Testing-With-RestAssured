package coreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeregeLinkedList {
    public static void main(String[] args) {
        List<List<Integer>>list= new ArrayList<>();
        list.add(Arrays.asList(1,2,3));
        list.add(Arrays.asList(2,3,4,6));
        list.add(Arrays.asList(4,5,9,6));

        List<Integer> ans = sortList(list);
       for(int k=0;k< ans.size();k++){
           System.out.println(ans.get(k));
       }


    }
    public static List<Integer>  sortList(List<List<Integer>> list){
        List<Integer> list2= new ArrayList<>();
        for(List<Integer> subList: list){
            list2.addAll(subList);
        }


        for (int i=0;i< list2.size()-1;i++){
            for(int j=0;j< list2.size()-i-1;j++){
                if (list2.get(j)>list2.get(j+1)){
                    int temp= list2.get(j);
                    list2.set(j,list2.get(j+1));
                    list2.set(j+1,temp);
                }
            }
        }
        return list2;
    }
}
