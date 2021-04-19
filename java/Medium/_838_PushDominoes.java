package Medium;
/*

There are N dominoes in a line, and we place each domino vertically upright.
In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
After each second, each domino that is falling to the left pushes the adjacent domino on the left.
Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.
Return a string representing the final state. 

Example 1:
Input: ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
Example 2:

Input: "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.
*/
public class _838_PushDominoes {
    public _838_PushDominoes(){
        System.out.println(pushDominoes("..R.."));
        System.out.println(pushDominoes("RR.L"));
        System.out.println(pushDominoes(".L.R...LR..L.."));
    }

    public String pushDominoes(String dominoes) {
        
        StringBuilder sb = new StringBuilder();
        while(!dominoes.equals(sb.toString())){
            
            for(int i = 0; i<dominoes.length(); i++){
                char p = i>0?dominoes.charAt(i-1):' ';
                char c = dominoes.charAt(i);
                char n = i<dominoes.length()-1?dominoes.charAt(i+1):' ';
                if(c != '.') {
                    sb.append(c);
                    continue;
                }
    
                if(p=='R' && n == 'L') {sb.append(c);continue;}
                else if(p=='R' && n!='L') sb.append('R');
                else if(p!='R' && n=='L') sb.append('L');
                else {sb.append(c); continue;}
            }
            if(dominoes.equals(sb.toString())) return sb.toString();
            else {
                dominoes = sb.toString();
                sb = new StringBuilder();
            }
        }
        return sb.toString();
        
    }
}

