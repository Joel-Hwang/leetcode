package Medium;

import org.testng.annotations.Test;

public class _558_LogicalOrOfTwoBinaryGridsRepresentedAsQuadTrees {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if(quadTree1.isLeaf) return quadTree1.val? quadTree1: quadTree2;
        if(quadTree2.isLeaf) return quadTree2.val? quadTree2: quadTree1;

            quadTree1.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            quadTree1.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            quadTree1.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            quadTree1.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

            if( 
                quadTree1.topLeft.isLeaf && quadTree1.topRight.isLeaf &&
                quadTree1.bottomLeft.isLeaf && quadTree1.bottomRight.isLeaf &&  
                quadTree1.topLeft.val == quadTree1.topRight.val &&
                quadTree1.topRight.val == quadTree1.bottomLeft.val &&
                quadTree1.bottomLeft.val == quadTree1.bottomRight.val ){
                    quadTree1.val = quadTree1.topLeft.val;
                    quadTree1.isLeaf = true;
                    quadTree1.topLeft = null;
                    quadTree1.topRight = null;
                    quadTree1.bottomLeft = null;
                    quadTree1.bottomRight = null;
                }
        
        return quadTree1;
    }
    
    @Test
    public void test(){
        Node node1 = new Node(true,false
            ,new Node(true,true,null,null,null,null)
            ,new Node(true,true,null,null,null,null)
            ,new Node(false,true,null,null,null,null)
            ,new Node(false,true,null,null,null,null)
            );
        Node node2 = new Node(true,false
            ,new Node(true,true,null,null,null,null)
            ,new Node(true,false
                ,new Node(false,true,null,null,null,null)
                ,new Node(false,true,null,null,null,null)
                ,new Node(true,true,null,null,null,null)
                ,new Node(true,true,null,null,null,null))
            ,new Node(true,true,null,null,null,null)
            ,new Node(false,true,null,null,null,null)
            );

        Node answer = intersect(node1, node2);
        System.out.println(answer);
    }

    class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}

}

