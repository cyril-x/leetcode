package leetCode;

import java.util.*;

/**
 * Created by coco-xsj on 2017/9/7.
 */
public class numberOfArithmetic {
    //判断一个数组是否为等差数列，第一个是顺序的，第二个为可能间隔几个的
    public int numberOfArithmeticSlices(int[] A) {
        int diff;
        int result = 0;
        int temp = 1;
        int count = 0;
        int len = A.length;
        if (len < 3 || A == null) {
            return 0;
        }
        diff = A[1] - A[0];
        for (int i = 0; i < len - 2; i++) {
            if (A[i + 1] - A[i] == diff && A[i + 2] - A[i + 1] == diff) {
                count++;
                result = result + temp;
                if (count > 0) {
                    temp++;
                }

            } else {
                diff = A[i + 2] - A[i + 1];
                count = 0;
                temp = 1;
            }
        }
        return result;
    }

    public int numberOfArithmeticSlicesII(int[] A) {
        int re = 0;
        HashMap<Integer, HashMap<Long, Integer>> diffMaps = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            HashMap<Long, Integer> diffMap = new HashMap<>();
            diffMaps.put(i, diffMap);
            int num = A[i];
            for (int j = 0; j < i; j++) {
                if ((long) num - A[j] > Integer.MAX_VALUE)
                    continue;
                if ((long) num - A[j] < Integer.MIN_VALUE)
                    continue;
                long diff = (long) num - A[j];
                int count = diffMaps.get(j).getOrDefault(diff, 0);
                diffMaps.get(i).put(diff, diffMaps.get(i).getOrDefault(diff, 0) + count + 1);
                re += count;
            }
        }
        return re;
    }
    //一种耗时更短的做法
    public int numberOfArithmeticSlicesIII(int[] A) {
        int n = A.length;
        if (n < 3) return 0;
        Map<Integer, List<Integer>> revertedIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!revertedIdx.containsKey(A[i])) revertedIdx.put(A[i], new ArrayList<>());
            revertedIdx.get(A[i]).add(i);
        }
        int[][] dp = new int[n][n];
        int res = 0;
        for (int cur = 1; cur < n; cur++) {
            for (int prev = 0; prev < cur; prev++) {
                long next = (long)A[cur] - A[prev] + A[cur];
                if (next < Integer.MIN_VALUE || next > Integer.MAX_VALUE) continue;
                int nextNumber = (int) next;
                List<Integer> list = revertedIdx.get(nextNumber);
                if (list == null) continue;
                int index = Collections.binarySearch(list, cur + 1);
                if (index < 0) index = -index - 1;
                while (index < list.size()) {
                    dp[cur][list.get(index)] += dp[prev][cur] + 1;
                    res += dp[prev][cur] + 1;
                    index++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}