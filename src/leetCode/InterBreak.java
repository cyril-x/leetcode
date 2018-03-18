package leetCode;

/**
 * Created by coco-xsj on 2017/9/7.
 */
public class InterBreak {
    //343给一个数将这个数分解成多个数，并使乘绩最大
    //f(x)=x^(n/x),求导后f′(x)=(n/x2)  *  x(n/x)  * (1-lnx)，当2<x<3的时候得到最大值，所以%2的为2*，%1的为2*2*
    public int integerBreak(int n) {
        String s=null;
        char[] m=s.toCharArray();

        if(n<2||n>58){
            return 0 ;
        }
        if(n==2){
            return 1;
        }else if(n==3){
            return 2;
        }else if(n!=3&&n%3==0){
            return (int)Math.pow(3,n/3);
        }else if(n%3==1){
            return 2*2*(int)Math.pow(3,(n-4)/3);
        }else{
            return 2*(int)Math.pow(3,n/3);
        }

    }



}
