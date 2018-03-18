package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by d-xsj on 18/03/2018.
 */
public class FindCircles547 {
    /*
    * 深搜递归解法
    * */
    public int findCircleNum(int[][] M) {
        if(M==null || M.length==0) return 0;
        int len = M.length;
        boolean []visited = new boolean[len];
        int count = 0;
        for(int i = 0;i<len;i++){
            if(dfs(M,i,visited)>0){
                count++;
            }
        }
        return count;

    }
    public int dfs(int [][]array,int i,boolean []visited){
        if(visited[i]){
            return 0;
        }
        visited[i] = true;
        int count = 1;
        for(int j=0;j<visited.length;j++){
            if(i!=j&&array[i][j]==1){
                count+=dfs(array,j,visited);
            }
        }
        return count;
    }
/*
*
* 也是深搜，不过没那么直观
* */
    public int findCircleNum2(int[][] M) {
        int n = M.length;
        int re = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                queue.offer(i);//将没出现过的放入队列，下面用while(!queue.Empty())完成深搜，到一个圈子最后一个数时，他所能到达的vis
                                //都为true了，所以一定会跳出
                while(!queue.isEmpty()){
                    int[] temp = M[queue.poll()];
                    for(int m=0;m<n;m++){

                        if(temp[m]==1&&vis[m]==false){
                            vis[m]=true;
                            queue.offer(m);
                        }
                    }
                }
                re++;
            }
        }
        return re;
    }
}
