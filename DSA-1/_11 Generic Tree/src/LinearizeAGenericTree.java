import java.util.ArrayList;
import java.util.Stack;

public class LinearizeAGenericTree {
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

    // TC - O(N^2)
    public static void linearize(Node node) {
        for(Node child: node.children) {
            linearize(child);
        }

        while(node.children.size() > 1) {
            Node lastChild = node.children.remove(node.children.size()-1);
            Node secondLastChild = node.children.get(node.children.size()-1);
            Node tail = getTail(secondLastChild);
            tail.children.add(lastChild);
        }
    }

    public static Node getTail(Node node) {
        while(node.children.size() == 1) {
            node = node.children.get(0);
        }

        return node;
    }

    public static Node linearize2(Node node) {
        if(node.children.size() == 0) {
            return node;
        }
        Node lastNodeTail = linearize2(node.children.get(node.children.size()-1));

        while(node.children.size() > 1) {
            Node lstNode = node.children.remove(node.children.size()-1);
            Node scndLstNode = node.children.get(node.children.size()-1);
            Node scndLstTail = linearize2(scndLstNode);
            scndLstTail.children.add(lstNode);
        }

        return lastNodeTail;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Node root = construct(arr);
        linearize2(root);
        display(root);
    }
}
