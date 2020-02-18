package leetCode;

/**
 * Created by d-xsj on 2019/12/7.
 */
public class MinimumTimeVisitingAllPoints1266 {
    public static void main(String[] args) {

    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int ans=0;
        for (int i = 1; i < points.length; i++) {
            ans+=shortestWay(points[i-1], points[i]);
        }
        return ans;
    }

    public int shortestWay(int[] start, int[] end) {
        int rows = Math.abs(end[1] - start[1]);
        int cols = Math.abs(end[0] - start[0]);

        return (rows > cols) ? rows : cols;
    }
}
