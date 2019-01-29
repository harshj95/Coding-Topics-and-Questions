package geeksforgeeks;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int key) {
        this.key = key;
        left = right = null;
    }
}

class TopViewOfTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            TreeNode root = null;
            if (n == 0) {
                System.out.println();
                continue;
            }
            for (int i = 0; i < n; i++) {
                int a1 = sc.nextInt();
                int a2 = sc.nextInt();
                char ch = sc.next().charAt(0);
                if (root == null) {
                    root = new TreeNode(a1);
                    switch (ch) {
                        case 'L':
                            root.left = new TreeNode(a2);
                            break;
                        case 'R':
                            root.right = new TreeNode(a2);
                            break;
                    }
                } else {
                    insert(root, a1, a2, ch);
                }
            }
            GfG g = new GfG();
            g.printTopView(root);
            System.out.println();
        }
    }

    public static void insert(TreeNode root, int a1, int a2, char ch) {
        if (root == null)
            return;
        if (root.key == a1) {
            switch (ch) {
                case 'L':
                    root.left = new TreeNode(a2);
                    break;
                case 'R':
                    root.right = new TreeNode(a2);
                    break;
            }
        } else {
            insert(root.left, a1, a2, ch);
            insert(root.right, a1, a2, ch);
        }
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below
Node is as follows
class TreeNode
{
    int key;
    TreeNode left, right;
    public TreeNode(int key)
    {
        this.key = key;
        left = right = null;
    }
}*/
class GfG {
    public void printTopView(TreeNode root) {
        if (root == null)
            return;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        HashSet<Integer> map = new HashSet<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode temp = pair.getKey();
            int hd = pair.getValue();

            if (!map.contains(hd)) {
                map.add(hd);
                System.out.print(temp.key + " ");
            }

            if (temp.left != null) {
                q.add(new Pair(temp.left, hd - 1));
            }

            if (temp.right != null) {
                q.add(new Pair(temp.right, hd + 1));
            }
        }
    }
}