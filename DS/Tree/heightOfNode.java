import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*
     * class Node
     * int data;
     * Node left;
     * Node right;
     */
    public static int height(Node root) {
        // Write your code here.
        int left = -1;
        int right = -1;
        if (root != null) {
            if (root.left != null) {
                left = height(root.left);
            }
            if (root.right != null) {
                right = height(root.right);
            }
        }
        return left > right ? left + 1 : right + 1;

    }
}