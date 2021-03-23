package Easy;

import java.util.LinkedList;
import java.util.List;

/*
In a string s of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".

A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group. In the above example, "xxxx" has the interval [3,6].

A group is considered large if it has 3 or more characters.

Return the intervals of every large group sorted in increasing order by start index.

 

Example 1:

Input: s = "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the only large group with start index 3 and end index 6.
Example 2:

Input: s = "abc"
Output: []
Explanation: We have groups "a", "b", and "c", none of which are large groups.
Example 3:

Input: s = "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]
Explanation: The large groups are "ddd", "eeee", and "bbb".
Example 4:

Input: s = "aba"
Output: []
*/
public class _830_Positions_of_Large_Groups {
    public _830_Positions_of_Large_Groups() {

    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        char[] arS = s.toCharArray();
        
        int start = 0;
        int cnt = 1;
        for(int i = 0; i<arS.length-1; i++){
            if(arS[i]==arS[i+1]){
                cnt++;
            }else{
                if(cnt>=3){
                    List<Integer> temp = new LinkedList<Integer>();
                    temp.add(start);
                    temp.add(start+cnt-1);
                    res.add(temp);
                }
                cnt = 1;
                start = i+1;
            }
        }

        if(cnt>=3){
            List<Integer> temp = new LinkedList<Integer>();
            temp.add(start);
            temp.add(start+cnt-1);
            res.add(temp);
        }

        return res;
    }
}