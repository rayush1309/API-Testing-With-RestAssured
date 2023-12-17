package coreJava;

import org.testng.annotations.Test;

import java.util.function.Function;

public class FunctionalProgramming {
    @Test
    public void printSqrt(){
        Function<Integer,Integer> square=(x)->x*x;
        System.out.println(square.apply(5));
    }
}


//print permutation-count palindrome
//count palindromic Substring
//print subsequence
//sorting
