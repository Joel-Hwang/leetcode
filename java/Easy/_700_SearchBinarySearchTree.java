package Easy;
/*
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Input: root = [4,2,7,1,3], val = 5
Output: []

*/

import Easy._111_MinimumDepthBT.TreeNode;

public class _700_SearchBinarySearchTree{
    public _700_SearchBinarySearchTree(){

    }

    // BFS logN 찾아서 서브트리 리턴
    public TreeNode searchBST(TreeNode root, int val) {
        return null;
    }
}


/**
 * Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
*/