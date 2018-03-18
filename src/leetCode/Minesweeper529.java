package leetCode;

/**
 * Created by d-xsj on 18/03/2018.
 */
public class Minesweeper529 {
    /*
    扫雷游戏
    * 先判断点击的那个是否是雷，然后深搜对其周围的进行判断
    * 如果遇到数字，或者是'B'的不用管，直接返回，只对是'E'的进行周围8个检查
    * 有矿则为数字，没矿继续深搜
    * 用vis来标注是否检查过
    * */
    int m,n;
    public char[][] updateBoard(char[][] board, int[] click) {
        n =board[0].length;
        m = board.length;
        boolean[][] vis = new boolean[m][n];
        if(click[0]>m-1&&click[1]>n-1&&click[0]<0&&click[1]<0){
            return board;
        }
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;}

        helper(board,click[0],click[1],vis);
        return board;
    }

    public void helper(char[][] board,int x,int y,boolean[][] vis){
        int mine=0;

        int[] offsetX={1,1,1,0,0,-1,-1,-1};
        int[] offsetY={1,0,-1,1,-1,1,0,-1};
        if(board[x][y]!='E'){
            return ;
        }
        vis[x][y] =true;
        for(int i=0;i<8;i++){
            int  row = x + offsetX[i];
            int  col = y + offsetY[i];
            if(col<0||row<0||col>n-1||row>m-1){
                continue;
            }
            if(board[row][col]=='M'){
                mine++;
            }
        }
        if(mine>0){
            board[x][y] = (char)(mine+48);
        }else{
            board[x][y] = 'B';
            for(int i=0;i<8;i++){
                int  row = x + offsetX[i];
                int  col = y + offsetY[i];
                if(col<0||row<0||col>n-1||row>m-1||vis[row][col]){
                    continue;
                }else{
                    helper(board,row,col,vis);
                }
            }

        }



    }
}
