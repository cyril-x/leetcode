package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by d-xsj on 2019/12/7.
 */
public class JewelsAndStones771 {
    public static void main(String[] args) {


    }

    public static int numJewelsInStones(String J, String S) {
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < J.length(); j++) {
                if (J.charAt(j) == S.charAt(i)) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }

    public static int solution2(String J, String S) {
        Set<Character> Jset = new HashSet<>();

        for (int j = 0; j < J.length(); j++)
            Jset.add(J.charAt(j));

        int ans = 0;

        for (int i = 0; i < S.length(); i++)
            if (Jset.contains(S.charAt(i)))
                ans++;
        return ans;
    }

}
