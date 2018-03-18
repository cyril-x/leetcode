package leetCode;

import java.util.Arrays;

/**
 * Created by coco-xsj on 2017/9/7.
 */
public class MaximumLengthChain {
    //646
    //解析。这道题有一个既定顺序，即pair内，第一个数小于第二个数，所以只对第一个数进行排序无法判断第二个数大小
    //而对第二个数排序则可以直接不使用dp
    //按照第二个数进行排序，自定义交换和快排，之后判断下一个的第一个值是否比上一个的第二个值大就行了
    private void swap(int []a,int []b) {
        int tmp=a[0];
        a[0]=b[0];
        b[0]=tmp;

        tmp=a[1];
        a[1]=b[1];
        b[1]=tmp;
    }

    private void quickSort(int a[][],int p,int r) {
        if (p >= r) return;
        int i=p,j=r+1;
        while(true) {
            // while(a[++i][1]<a[p][1] && i<r);
            // while(a[--j][1]>a[p][1] && j>p);
            do{i++;} while(!(i==r || a[i][1]>=a[p][1]));
            do{j--;} while(!(j==p || a[j][1]<=a[p][1]));;
            if(i>=j) {break;}
            else {swap(a[i],a[j]);}
        }
        swap(a[p],a[j]);
        quickSort(a,p,j-1);
        quickSort(a,j+1,r);
    }

    public int findLongestChain(int[][] pairs) {
        quickSort(pairs, 0, pairs.length - 1);
        int count = 0, end = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > end) {
                count++;
                end = pair[1];
            }
        }
        return count;
    }
    //对第一个数进行排序，得到排序后的数组只需要得到dp[i]之前，第二个数小于i的第一个数的最大的dp值
    public int findLongestChainII(int[][] pairs) {
        if(pairs == null||pairs.length==0){
            return 0;
        }
        //按照第一个数进行排序
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int len = pairs.length;
        int[] dp = new int[len];
        int max=0;
        for(int i=0;i<len;i++){
            int tempmax =0;
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    if(dp[j]>tempmax){
                        tempmax =dp[j];
                    }

                }
            }
            String s="23232323";

            Integer.parseInt(s);
            dp[i]=tempmax+1;
            if(dp[i]>max){
                max =dp[i];
            }
        }

        return max;

    }

}
