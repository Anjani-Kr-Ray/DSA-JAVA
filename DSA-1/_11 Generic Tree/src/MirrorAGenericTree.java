// https://nados.io/question/mirror-a-generic-tree

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MirrorAGenericTree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }
    }

    public static Node construct(int[] arr) {
        Stack<Node> s = new Stack<>();
        Node root = null;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == -1) {
                s.pop();
            } else {
                Node n = new Node();
                n.data = arr[i];

                if(s.size() > 0) {
                    s.peek().children.add(n);
                } else {
                    root = n;
                }
                s.push(n);
            }
        }
        return root;
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for(Node child: node.children) {
            str += child.data + " ";
        }
        System.out.println(str);

        for(Node child: node.children) {
            display(child);
        }
    }

    public static void mirror(Node node) {
        for(Node child: node.children)
            mirror(child);
        Collections.reverse(node.children);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Node root = construct(arr);
        mirror(root);
        display(root);
    }


}
