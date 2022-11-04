import java.util.ArrayList;
import java.util.Stack;

public class LowestCommonAncestor {
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

    private static int lowestCommonAncestor(Node root, int ele1, int ele2) {
        ArrayList<Integer> n1 = nodeToRootPath(root, ele1);
        ArrayList<Integer> n2 = nodeToRootPath(root, ele2);

        int i = n1.size() - 1;
        int j = n2.size() - 1;

        while(i>=0 && j>=0 && n1.get(i) == n2.get(j)) {
            i--;
            j--;
        }

        i++; j++;
        return n1.get(i);
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        System.out.println(lowestCommonAncestor(root, 110, 120));
    }
}
