package com.engineeringdigest.collectionframework.stream.practice;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindIfDuplicateExist {

    public static void main(String[] args) {
        int[] case1 = new int[]{1,2,3,1};
        int[] case2 = new int[]{1,2,3,4};
        int[] case3 = new int[]{1,1,1,3,3,4,3,2,4,2};


        System.out.printf("Contains Duplicate Case1: Expected: %b | Actual: %b%n", true, containsDuplicate(case1));
        System.out.printf("Contains Duplicate Case2: Expected: %b| Actual: %b%n", false, containsDuplicate(case2));
        System.out.printf("Contains Duplicate Case3: Expected: %b | Actual: %b%n", true, containsDuplicate(case3));
    }

    public static boolean containsDuplicate(int[] nums) {
       return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
               .values()
               .stream()
               .anyMatch(x -> x > 1);
    }
}
