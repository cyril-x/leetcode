package leetCode.dp;

/**
 * Created by d-xsj on 2020/2/18.
 */
public class DivisorGame1025 {
    /**
     *
     * @param N
     * @return
     * 如果N为偶数，则坚持选择x = 1，对方得到N - 1为大于0的奇数
     * 如果N为奇数：
     *
     * 如果N > 1, 其因子必然也是奇数，所以无论选择任何x，N - x都将变为偶数
     * 由于x < N，给予对方的N - x必然是 > 0的偶数
     * 如果N = 1，直接失败。
     * 综上，N为偶数时必然大于0，只需要坚持选择x = 1，最终对方会得到N = 1而失败。
     * 所以N为偶数时返回true。
     */
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
    public static void main(String[] args) {

    }
}
