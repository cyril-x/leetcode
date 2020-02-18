package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by d-xsj on 2019/12/8.
 */
public class FindAndReplacePattern890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        ArrayList<String> list  = new ArrayList<>();
        for (String s : words){
            if (s.length() == pattern.length()){
                // 一个思路，用两个map分别存对应的映射关系，挨个检查
                HashMap<Character, Character> sTop = new HashMap<>();
                HashMap<Character, Character> pTos = new HashMap<>();
                char[] schars = s.toCharArray();
                char[] pchars = pattern.toCharArray();
                for (int i = 0; i< schars.length; i++ ){
                    if (sTop.get(schars[i])==null && pTos.get(pchars[i])==null){
                        sTop.put(schars[i], pchars[i]);
                        pTos.put(pchars[i], schars[i]);
                    }else if (sTop.get(schars[i])!=null && pTos.get(pchars[i])!=null&& sTop.get(schars[i])==pchars[i]&&pTos.get(pchars[i])==schars[i]){

                    }else {
                        break;
                    }
                    if (i == schars.length-1){
                        list.add(s);
                    }
                }


            }
        }
        return list;
    }
    // 另一种思路，通过函数规范化，位置 -> 字母个数，最后比较两个数组是否一致
    public List<String> findAndReplacePattern2(String[] words, String pattern) {
        int[] p = F(pattern);
        List<String> res = new ArrayList<String>();
        for (String w : words)
            if (Arrays.equals(F(w), p)) res.add(w);
        return res;
    }

    public int[] F(String w) {
        HashMap<Character, Integer> m = new HashMap<>();
        int n = w.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            m.putIfAbsent(w.charAt(i), m.size());
            res[i] = m.get(w.charAt(i));
        }
        return res;
    }
}
