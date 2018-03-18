package leetCode;

/**
 * Created by coco-xsj on 2017/9/7.
 */
public class PalindromicSubString {
    //回文计算
    /*计算思路：每次分别计算奇数个的回文，和偶数个的回文，因为每个单个都属于奇数个回文，所以不用再次计算
    * */
    public int countSubstrings(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            count += countSubstrings(s, i, i) + countSubstrings(s, i, i + 1);
        }

        return count;
    }

    private int countSubstrings(String s, int i, int j) {
        int count = 0;

        while(i >= 0 && j < s.length()) {
            if(s.charAt(i) != s.charAt(j)) {
                return count;
            }

            i--;
            j++;
            count++;
        }

        return count;
    }
    //dp思想得到回文数量，每次将0到i-01的回文数累加，到最后结果
    public boolean isPalindromic(String s){
        for(int i=0;i<(s.length()/2);i++)
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        return true;
    }
    public int countSubstringsII(String s) {
        int len=s.length();
        int[] dp=new int[len];
        for(int i=1;i<len;i++){
            int tmpNum=0;
            for(int j=0;j<i;j++)
                if(s.charAt(i)==s.charAt(j)){
                    String subStr=s.substring(j,i+1);
                    if(isPalindromic(subStr))
                        tmpNum++;
                }
            dp[i]=dp[i-1]+tmpNum;
        }
        return dp[len-1]+len;
    }
}
