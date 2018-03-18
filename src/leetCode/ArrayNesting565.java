package leetCode;

import java.util.HashSet;

/**
 * Created by coco-xsj on 19/12/2017.
 * A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S,
 * where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

 Suppose the first element in S starts with the selection of element A[i] of index = i,
 the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.
 *如果几个能形成闭环，那么从其中的任何一个都能到其他的几个，因此一个数只会出现在一个闭环中
 * 所以用一个set每遇到一个就检测是否已经在闭环中
 *
 */
public class ArrayNesting565 {
    HashSet<Integer> set = new HashSet();
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, check(nums, i));
        }
        return max;
    }
    private int check(int[] nums, int k) {
        int res = 0;
        while (!set.contains(k)) {
            set.add(k);
            k = nums[k];
            res++;
        }
        return res;
    }
}
