import java.util.ArrayList;
import java.util.Stack;

public class NodeToRootPath {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static Node construct(int[] arr) {
        Stack<Node> s = new Stack<>();
        Node root = null;

        for(int val: arr) {
            if(val == -1)
                s.pop();
            else {
                Node n = new Node();
                n.data = val;

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

    private static ArrayList<Integer> nodeToRootPath(Node root, int ele) {
        if(root.data == ele) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            return list;
        }

        for(Node child: root.children) {
            ArrayList<Integer> list = nodeToRootPath(child, ele);
            if(list.size() != 0) {
                list.add(root.data);
                return list;
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        System.out.println(nodeToRootPath(root, 110));
    }

}
