package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.testng.annotations.Test;

public class _856_ScoreofParentheses {
    public int scoreOfParentheses2(String s) {
        Stack<Integer> st = new Stack<>();
        int score = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(score);
                score = 0;
            }
            else {
                score = st.pop() + Math.max(2 * score, 1);
            }
        }
        return score;
    }

    public int scoreOfParentheses(String s) {
        int res = 0;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode root = new TreeNode(0);
        stk.push(root);
        for(char c : s.toCharArray()){
            if(c == '('){
                TreeNode node = new TreeNode(1);
                stk.peek().chldren.add(node);
                stk.push(node);
            }else{
                stk.pop();
            }
        }

        for(TreeNode c : root.chldren){
            res += getSum(c);
        }
        
        return res;
    }
    
    private int getSum(TreeNode node){
        if(node == null) return 0;
        if(node.chldren.size() == 0) return 1;
        int childrenSum = 0;
        for(TreeNode c : node.chldren){
            childrenSum += getSum(c);
        }
        return childrenSum*2;
    }

    class TreeNode{
        int val;
        List<TreeNode> chldren = new ArrayList<>();
        public TreeNode(int val){
            this.val = val;
        }
    }

    @Test
    public void test(){
        assertEquals(6, scoreOfParentheses("(()(()))"));
        assertEquals(2, scoreOfParentheses("()()"));
        assertEquals(2, scoreOfParentheses("(())"));
        assertEquals(1, scoreOfParentheses("()"));
    }
}
