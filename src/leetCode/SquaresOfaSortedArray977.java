package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by d-xsj on 2019/12/8.
 */
public class SquaresOfaSortedArray977 {
    public int[] sortedSquares(int[] A) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i: A){
            list.add(i*i);
        }
        return list.stream().mapToInt(one -> one).sorted().toArray();
    }
// Arrays 自带排序，。。。。
    public int[] sortedSquares2(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i)
            ans[i] = A[i] * A[i];

        Arrays.sort(ans);
        return ans;
    }

}
