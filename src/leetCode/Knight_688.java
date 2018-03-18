package leetCode;

/**
 * Created by coco-xsj on 2017/11/1.
 */
public class Knight_688 {
    public static void main(String[] args) {
        double re = knightProbability(3,2,0,0);
        System.out.println(re);
    }

    public static double knightProbability(int N, int K,int r,int c){
        double dp[][] =new double[N][N];
        int[] dr = new int[]{2,2,1,1,-1,-1,-2,-2};
        int[] dc = new int[]{1,-1,2,-2,2,-2,1,-1};

        dp[r][c] =1;
        for (;K>0;K--){
            double[][] dp2 = new double[N][N];
            for (int x=0;x<N;x++) {
                for (int y=0; y<N;y++){
                    for(int k =0; k<8;k++){
                        int cr = x + dr[k];
                        int cc = y + dc[k];
                        if (0<=cr&&cr<N&&0<=cc&&cc<N){
                            dp2[cr][cc]+= dp[x][y]/8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }

        double ans = 0.0;
        for (double[] row:dp) {
            for (double x:row) {
                ans+=x;
            }

        }
        return ans;

    }
   /* static int ok =0;

    public static double knightProbability(int N, int K, int r, int c) {

        getok(N,K,r,c);
        return (double)ok/Math.pow(8,K);
    }

    public static void getok(int N, int K , int r,int c){
        if(K==0&&0<=r&&r<N&&0<=c&&c<N){
            ok++;
        }
        else if(K!=0&&0<=r&&r<N&&0<=c&&c<N){
            getok(N,K-1,r-2,c+1);
            getok(N,K-1,r-2,c-1);
            getok(N,K-1,r+2,c-1);
            getok(N,K-1,r+2,c+1);
            getok(N,K-1,r-1,c-2);
            getok(N,K-1,r-1,c+2);
            getok(N,K-1,r+1,c-2);
            getok(N,K-1,r+1,c+2);
        }
        return;
    }*/
}
