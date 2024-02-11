package Medium;
import java.util.*;

import org.testng.annotations.Test;
public class _1861_RotatingTheBox {
    public char[][] rotateTheBox(char[][] box) {
        char[][] result = new char[box[0].length][box.length];
        for(int i = 0; i<box.length; i++){
            int stoneCnt = 0;
            int emptyCnt = 0;
            for(int j = 0; j<box[0].length; j++){
                if(box[i][j]=='#') stoneCnt++;
                else if(box[i][j]=='.') emptyCnt++;
                else{
                    for(int tempIdx = stoneCnt; tempIdx>0; tempIdx--)
                        box[i][j-1-stoneCnt + tempIdx] = '#';
                    for(int tempIdx = emptyCnt; tempIdx>0; tempIdx--)
                        box[i][j-1-stoneCnt-emptyCnt+tempIdx  ] = '.';
                    stoneCnt = 0;
                    emptyCnt = 0;
                }
            }

            for(int tempIdx = stoneCnt; tempIdx>0; tempIdx--)
                box[i][box[0].length-1-stoneCnt + tempIdx] = '#';
            for(int tempIdx = emptyCnt; tempIdx>0; tempIdx--)
                box[i][box[0].length-1-stoneCnt-emptyCnt+tempIdx  ] = '.';
        }

        for(int i = 0; i<box.length; i++){
            for(int j = 0; j<box[0].length; j++)
                result[j][result[0].length-1-i] = box[i][j];
        }

        return result;
    }

    @Test
    public void test(){
        rotateTheBox(new char[][]{{'#','.','*','.'},{'#','#','*','.'}});
    }

}
