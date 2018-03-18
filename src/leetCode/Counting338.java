package leetCode;

/**
 * Created by coco-xsj on 2017/11/2.
 */
public class Counting338 {
    public static void main(String[] args) {
        for (int i:
             countBits(5)) {
            System.out.println(i);
        }
    }
    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i=0;i<=num;i++)
            res[i] = res[i/2]+i%2;
        return res;
    }
}
