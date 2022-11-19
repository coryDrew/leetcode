package com.zcy.DFS;

public class CountBattleships419 {
    //简单岛屿问题
    public int countBattleships(char[][] board) {
        int res = 0;
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j] == 'X'){
                    dfs(board,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(char[][] board,int i,int j){
        board[i][j] = '.';
        if(i - 1>=0&&board[i - 1][j] == 'X'){
            dfs(board,i - 1,j);
        }
        if(j - 1>=0&&board[i][j - 1] == 'X'){
            dfs(board,i,j - 1);
        }
        if(i + 1 < board.length&&board[i + 1][j] == 'X'){
            dfs(board,i + 1,j);
        }
        if(j + 1<board[0].length&&board[i][j + 1] == 'X'){
            dfs(board,i,j + 1);
        }
        return;
    }
}
