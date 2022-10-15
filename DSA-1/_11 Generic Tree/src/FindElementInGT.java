import java.util.ArrayList;
import java.util.Stack;

public class FindElementInGT {
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
                Node node = new Node();
                node.data = val;

                if(s.size() != 0) {
                    s.peek().children.add(node);
                } else {
                    root = node;
                }
                s.push(node);
            }
        }
        return root;
    }
    private static boolean findElement(Node node, int ele) {
        if(node.data == ele) {
            return true;
        }

        for(Node child: node.children) {
            boolean res = findElement(child, ele);
            if(res)
                return true;
        }

        return false;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Node root = construct(arr);
        System.out.println(findElement(root, 60));
    }


}
