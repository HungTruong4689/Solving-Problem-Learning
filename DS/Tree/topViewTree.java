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
     * 
     * class Node
     * int data;
     * Node left;
     * Node right;
     */
    static class Pair {
        public Node node;
        public int dist;

        public Pair(Node node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void topView(Node root) {
        if (root == null) {
            return;
        }
        Map<Integer, Integer> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            Node node = pair.node;
            int dist = pair.dist;
            if (!mp.containsKey(dist)) {
                mp.put(dist, node.data);
            }
            if (node.left != null) {
                q.add(new Pair(node.left, dist - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, dist + 1));
            }
        }
        for (Map.Entry<Integer, Integer> ent : mp.entrySet()) {
            System.out.print(ent.getValue() + " ");
        }

    }
}