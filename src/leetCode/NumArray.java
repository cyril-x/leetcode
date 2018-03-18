package leetCode;

/**
 * Created by coco-xsj on 2017/9/6.
 */
public class NumArray {
    //Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

    //Example:
    //Given nums = [-2, 0, 3, -5, 2, -1]

    //sumRange(0, 2) -> 1
    // sumRange(2, 5) -> -1
    // sumRange(0, 5) -> -3

    //二维数组超内存，1024.orz
   /* private int[][] sum;
    public NumArray(int[] nums) {

        int len = nums.length;
        int[][] sum = new int[len][len];
        for (int i=0;i<len;i++){

            sum[i][i] = nums[i];

        }

        for(int j=0;j<len-1;j++){
            for (int k=j+1;k<len;k++){
                sum[j][k]=sum[j][k-1]+nums[k];
            }
        }
        this.sum = sum;

    }

    public int sumRange(int i, int j) {
        int sum=0;
        sum = this.sum[i][j];
        return sum;
    }*/
   //听王大佬的。用一维
    private int[] dp;
    public NumArray(int[] nums) {
        int len = nums.length;

        this.dp=new int[len];
        if(len>0){
            dp[0]=nums[0];}
        if(len>1){
            for(int i=1;i<len;i++){
                dp[i] = dp[i-1]+nums[i];
            }}

    }

    public int sumRange(int i, int j) {
        int sum=0;
        if(i==0&&j<=dp.length-1){sum=dp[j];}
        else if(i!=0&&j<=dp.length-1){
            sum = dp[j]-dp[i-1];}

        return sum;
    }

}
