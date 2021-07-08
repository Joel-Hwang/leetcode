package Medium;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.Test;

public class _79_WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean res = false;

        for(int i = 0; i<board.length; i++)
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    //checkit
                    //board[][]
                    res = check(board,word,i,j,' ');
                    if(res) return true;
                }
            }

        return res;
    }

    public boolean check(char[][] board, String subWord, int i, int j, char dir){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        if(board[i][j] != subWord.charAt(0)) return false;
        if(subWord.length() == 1 && subWord.charAt(0) == board[i][j]){
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '0';
        boolean res = false;
        if(!res && dir != 'b')
        res = res||check(board,subWord.substring(1),i-1,j,'t');
        
        if(!res && dir != 't')
        res = res||check(board,subWord.substring(1),i+1,j,'b');
        
        if(!res && dir != 'r')
        res = res||check(board,subWord.substring(1),i,j-1,'l');
        
        if(!res && dir != 'l')
        res = res||check(board,subWord.substring(1),i,j+1,'r');
        board[i][j] = temp;
        return res;
    }


    public boolean exist2(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist2(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean exist2(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist2(board, y, x+1, word, i+1)
            || exist2(board, y, x-1, word, i+1)
            || exist2(board, y+1, x, word, i+1)
            || exist2(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }

    @Test
    public void test(){
        //Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
        //Output: true
        char[][] b1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        assertTrue(exist(b1, "ABCCED"));
        assertTrue(exist(b1, "SEE"));
        assertFalse(exist(b1, "ABCB"));
        char[][] b2 = {{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}};
        assertFalse(exist(b2, "aaaaaaaaaaaaa"));
    }
}
