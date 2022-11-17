import java.util.ArrayList;
import java.util.Stack;

public class AreSymmetric {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static Node construct(int[] arr) {
        Node root = null;
        Stack<Node> s = new Stack<>();

        for(int num: arr) {
            if(num == -1) {
                s.pop();
            } else {
                Node n = new Node();
                n.data = num;

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

    private static boolean areMirror(Node n1, Node n2) {
        if(n1.children.size() != n2.children.size()) {
            return false;
        }

        for(int i=0; i<n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(n2.children.size() - i - 1);

            if(!areMirror(c1,c2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean areSymmetric(Node root) {
        return areMirror(root, root);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1};
        Node root = construct(arr);
        System.out.println(areSymmetric(root));
    }
}
