package datastructures;

import java.util.HashMap;

public class BinarySearchTree {

    TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        insert(data, root);
    }

    private void insert(int data, TreeNode root) {

        if (root == null) {
            this.root = new TreeNode(data);
            return;
        }


        if (data < root.data) {
            if (root.left == null) {
                root.left = new TreeNode(data);
            } else {
                insert(data, root.left);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(data);
            } else {
                insert(data, root.right);
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);

        System.out.print(root.data + " ");

        inOrder(root.right);
    }

    public boolean contains(int data) {
        return contains(data, root);
    }

    private boolean contains(int data, TreeNode root) {
        if (root.data == data)
            return true;
        else if (data > root.data) {
            if (root.right == null)
                return false;
            else
                return contains(data, root.right);
        } else {
            if (root.left == null)
                return false;
            else
                return contains(data, root.left);
        }
    }
}
