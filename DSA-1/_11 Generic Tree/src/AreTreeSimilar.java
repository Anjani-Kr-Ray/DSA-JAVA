import java.util.ArrayList;
import java.util.Stack;

public class AreTreeSimilar {
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

    private static boolean areSimilar(Node n1, Node n2) {
        if(n1.children.size() != n2.children.size()) {
            return false;
        }

        for(int i=0; i<n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);

            if(areSimilar(c1, c2) == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root1 = construct(arr);
        Node root2 = construct(arr);

        System.out.println(areSimilar(root1, root2));
    }
}
