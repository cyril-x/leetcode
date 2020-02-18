package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d-xsj on 2019/12/8.
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isDividing(i)) list.add(i);
        }
        return list;

    }

    boolean isDividing(int n) {
        int total = n;
        while (n > 0) {
            int m = n % 10;
            if (m != 0 && total % m == 0) {
                n = n / 10;
            } else {
                break;
            }
        }
        if (n == 0) {
            return true;
        } else {
            return false;
        }
    }
    // 另一种解法。。太粗暴了。。
    public boolean selfDividing(int n) {
        for (char c: String.valueOf(n).toCharArray()) {
            if (c == '0' || (n % (c - '0') > 0))
                return false;
        }
        return true;
    }
}
