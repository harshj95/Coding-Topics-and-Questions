package com.example.practice.hackerrank;
/*
For the purposes of this challenge, we define a binary search tree to be a binary tree with the following ordering properties:

The data value of every node in a node's left subtree is less than the data value of that node.
The data value of every node in a node's right subtree is greater than the data value of that node.

Constraints
0 <= data <= 10,000
*/


public class IsBinarySearchTree {

    class Node {
        int data;
        Node left;
        Node right;
    }
//MY FUNCTION. Cleared 7/13 test cases. What I was not accounting for was the data constraints [0, 10000]
    boolean checkBST(Node root) {
        if(root==null)
        {
            return false;
        }

        if(root.left==null || root.right==null)
        {
            return true;
        }

        if(root.data>root.left.data && root.data<root.right.data)
        {
            return (true & checkBST(root.left) & checkBST(root.right));
        }
        else
        {
            return false;
        }
    }

//CORRECT SOLUTION

    boolean checkBST1(Node root) {
        return check(root, -1, 10001);
    }

    boolean check(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data < min || node.data > max) {
            return false;
        }

        return check(node.left, min, node.data - 1) && check(node.right, node.data + 1, max);
    }

}
