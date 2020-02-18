package leetCode.dp;

/**
 * Created by d-xsj on 2020/2/17.
 */
public class MatrixBlockSum1314 {
// have a bug to fix
    static public int[][] matrixBlockSum(int[][] mat, int K) {
        int l = mat.length;
        int n = mat[0].length;
        int[][] pre = new int[l][n];
        int[][] ans = new int[l][n];
        pre[0][0] = mat[0][0];
        for (int i = 1; i < l; i++) {
            pre[i][0] = pre[i - 1][0] + mat[i][0];
        }
        for (int j = 1; j < n; j++) {
            pre[0][j] = pre[0][j - 1] + mat[0][j];
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + mat[i][j];
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int i1 = Math.max(0, i - K);
                int i2 = Math.min(i + K, l - 1);
                int j1 = Math.max(0, j - K);
                int j2 = Math.min(j + K, n - 1);
                ans[i][j] = pre[i2][j2] - pre[i1][j2] - pre[i2][j1] + pre[i1][j1];
            }
        }
        return ans;
    }


    public int[][] answer(int[][] mat, int K){int l = mat.length;
        int n = mat[0].length;
        int[][] pre = new int[l + 1][n + 1];
        int[][] ans = new int[l][n];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < n; j++) {
                pre[i + 1][j + 1] = pre[i][j + 1] + pre[i + 1][j] - pre[i][j] + mat[i][j];
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int i1 = Math.max(0, i - K);
                int i2 = Math.min(i + K + 1, l);
                int j1 = Math.max(0, j - K);
                int j2 = Math.min(j + K + 1, n);
                ans[i][j] = pre[i2][j2] - pre[i1][j2] - pre[i2][j1] + pre[i1][j1];
            }
        }
        return ans;}

    public static void main(String[] args) {

    }
}
