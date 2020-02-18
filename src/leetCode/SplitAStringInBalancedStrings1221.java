package leetCode;

/**
 * Created by d-xsj on 2019/12/7.
 */
public class SplitAStringInBalancedStrings1221 {
    public static void main(String[] args) {

    }

    public int balancedStringSplit(String s) {
        int count = 0 ;
        char[] chars = s.toCharArray();
        int fir = 0; // 记录L或者R出现的次数
        char index = 'L';// 当前循环中的首字母
        for (char c: chars){
            if (fir == 0){
               index = c;
               fir ++;
            }else {
                if (c == index){
                    fir++;
                }else {
                    fir--;
                    if (fir == 0){
                        count ++;
                    }
                }
            }


        }
        return count;
    }
}
