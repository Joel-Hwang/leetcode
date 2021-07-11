package Hard;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _37_SudokuSolver{
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k<='9'; k++){
                        board[i][j] = k;
                        if(isValid(board,i, j) && solve(board)){
                            return true;
                        }else{
                            board[i][j] = '.';
                        }
                    }

                    return false;
                }
                    
            }
        }
        return true;
    }

   

    public boolean isValid(char[][] board, int y, int x){
        int[] dic = new int[10];
        for(int i = 0; i<board.length; i++){
            if(board[i][x]=='.') continue;
            if(dic[board[i][x]-'0']>0) return false;
            dic[board[i][x]-'0']++;
        }
 
        dic = new int[10];
        for(int i = 0; i<board.length; i++){
            if(board[y][i]=='.') continue;
            if(dic[board[y][i]-'0']>0) return false;
            dic[board[y][i]-'0']++;
        }

        dic = new int[10];
        for(int i = y/3*3; i<y/3*3+3; i++){
            for(int j = x/3*3; j<x/3*3+3; j++){
                if(board[i][j]=='.') continue;
                if(dic[board[i][j]-'0']>0) return false;
                dic[board[i][j]-'0']++;
            }
        }

        return true;
    }

    @Test
    public void test(){
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};
        /*char[][] board = {
            {'8','.','.','.','.','2','3','6','7'},
            {'2','4','3','8','7','6','5','1','9'},
            {'7','6','.','1','9','3','8','4','2'},
            {'1','8','6','3','2','9','7','5','4'},
            {'5','7','4','6','.','8','9','2','3'},
            {'3','9','2','.','4','7','6','8','1'},
            {'4','5','7','9','6','1','2','3','8'},
            {'6','.','8','7','3','4','1','9','5'},
            {'9','3','1','2','8','5','4','7','6'}};*/

             
        solveSudoku(board);

        for(char[] row : board){
            System.out.println(Arrays.toString(row));
        }

        char[][] output = {{'5','3','4','6','7','8','9','1','2'},{'6','7','2','1','9','5','3','4','8'},{'1','9','8','3','4','2','5','6','7'},{'8','5','9','7','6','1','4','2','3'},{'4','2','6','8','5','3','7','9','1'},{'7','1','3','9','2','4','8','5','6'},{'9','6','1','5','3','7','2','8','4'},{'2','8','7','4','1','9','6','3','5'},{'3','4','5','2','8','6','1','7','9'}};
    }
}