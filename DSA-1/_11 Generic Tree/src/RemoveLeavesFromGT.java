import java.util.ArrayList;
import java.util.Stack;

public class RemoveLeavesFromGT {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static Node construct(int[] arr) {
        Stack<Node> s = new Stack<>();
        Node root = null;

        for(int val: arr) {
            if(val == -1) {
                s.pop();
            } else {
                Node n = new Node();
                n.data = val;

                if(s.size() != 0) {
                    s.peek().children.add(n);
                } else {
                    root = n;
                }

                s.push(n);
            }
        }
        return root;
    }

    public static void removeLeaves(Node node) {
        for(int i=node.children.size()-1; i>=0; i--) {
            if(node.children.get(i).children.size() == 0) {
                node.children.remove(i);
            }
        }

        for(Node child: node.children) {
            removeLeaves(child);
        }
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

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Node root = construct(arr);
        System.out.println("Before removal: ");
        display(root);
        System.out.println("After removal: ");
        removeLeaves(root);
        display(root);
    }
}
