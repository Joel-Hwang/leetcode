package Medium;

public class _36_ValidSudoku {
    public _36_ValidSudoku(){
        char[][] board = new char[][] 
        {{'5','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};

        char[][] board2 = new char[][]
        {{'8','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku(board2));
    }

    public boolean isValidSudoku(char[][] board) {
        int[] dic = new int[]{0,0,0,0,0,0,0,0,0,0,0};
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j] == '.') continue;
                if(dic[board[i][j]-48] >0) return false;
                dic[board[i][j]-48]++;
            }
            dic = new int[]{0,0,0,0,0,0,0,0,0,0};
        }
        
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[j][i] == '.') continue;
                if(dic[board[j][i]-48] >0) return false;
                dic[board[j][i]-48]++;
            }
            dic = new int[]{0,0,0,0,0,0,0,0,0,0};
        }
        
        for(int i = 0; i<9; i++){
            int col=(i%3)*3,row=(i/3)*3;
            
            for(int j = 0+row; j<3+row; j++){
                for(int k = 0+col; k<3+col; k++){
                    if(board[j][k] == '.') continue;
                    if(dic[board[j][k]-48] >0) return false;
                    dic[board[j][k]-48]++;
                }
            }
            dic = new int[]{0,0,0,0,0,0,0,0,0,0};
        }

        return true;
    
    }
}
