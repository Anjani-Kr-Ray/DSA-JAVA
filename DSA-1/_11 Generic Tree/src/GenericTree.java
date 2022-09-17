import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class GenericTree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> s = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == -1) {
                s.pop();
            } else {
                Node n = new Node();
                n.data = arr[i];

                if(s.size() > 0)
                    s.peek().children.add(n);
                else
                    root = n;
                s.push(n);
            }
        }
        return root;
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for(Node child: node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for(Node child: node.children) {
            display(child);
        }
    }

    // https://nados.io/question/size-of-generic-tree
    public static int size(Node node) {
        int s = 1;

        for(Node child: node.children) {
            s += size(child);
        }
        return s;
    }

    // https://nados.io/question/maximum-in-a-generic-tree
    public static int max(Node node) {
        int m = node.data;
        for(Node child: node.children) {
            m = Math.max(m, max(child));
        }
        return m;
    }

    // https://nados.io/question/height-of-a-generic-tree
    public static int height(Node node) {
        int h = -1;
        for(Node child: node.children) {
            int temp = height(child);
            h = Math.max(temp, h);
        }
        h += 1;
        return h;
    }

    // https://nados.io/question/generic-tree-traversals-pre-order-post-order
    public static void traversals(Node node) {
        System.out.println("Node Pre "+node.data);
        for(Node child: node.children) {
            System.out.println("Edge Pre "+node.data+"--"+child.data);
            traversals(child);
            System.out.println("Edge Post "+node.data+"--"+child.data);
        }
        System.out.println("Node Post "+node.data);
    }


    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Node root = construct(arr);
//        display(root);
//        System.out.println("Size - "+size(root));
//        System.out.println("Maximum - "+max(root));
//        System.out.println("Height - "+height(root));
//        System.out.println("Preorder - PostOrder");
//        traversals(root);

    }
}