import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrder {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {}
        Node(int data) {
            this.data = data;
        }
    }

    public static Node construct(int[] arr) {
        Stack<Node> s = new Stack<>();
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                s.pop();
            } else {
                Node n = new Node();
                n.data = arr[i];

                if (s.size() > 0)
                    s.peek().children.add(n);
                else
                    root = n;
                s.push(n);
            }
        }
        return root;
    }

    // https://nados.io/question/level-order-of-generic-tree
    public static void levelOrder(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        while (q.size() > 0) {
            node = q.remove();
            System.out.println(node.data + " ");
            for (Node child : node.children) {
                q.add(child);
            }
        }
    }

    // https://nados.io/question/levelorder-linewise-generic-tree
    public static void levelOrderLinewise1(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();
        q.add(node);

        while (q.size() > 0) {
            node = q.remove();
            System.out.print(node.data + " ");

            for (Node child : node.children) {
                cq.add(child);
            }

            if (q.size() == 0) {
                q = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    public static void levelOrderLinewise2(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        q.add(new Node(-1));

        while(q.size() > 0) {
            node = q.remove();

            if(node.data == -1) {
                if(q.size() != 0) {
                    q.add(new Node(-1));
                    System.out.println();
                }
            } else {
                System.out.print(node.data+" ");
                for(Node child: node.children) {
                    q.add(child);
                }
            }
        }
    }

    public static void levelOrderLinewise3(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        while(q.size() > 0) {
            int s = q.size();

            for(int i=0; i<s; i++) {
                node = q.remove();
                System.out.print(node.data+" ");

                for(Node child: node.children) {
                    q.add(child);
                }
            }
            System.out.println();
        }
    }

    private static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public static void levelOrderLinewise4(Node node) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(node, 1));

        int level = 1;

        while(q.size() > 0) {
            Pair p = q.remove();
            if(p.level > level) {
                level = p.level;
                System.out.println();
            }

            System.out.print(p.node.data+" ");
            for(Node child: p.node.children) {
                Pair cp = new Pair(child, level+1);
                q.add(cp);
            }
        }
    }

    // https://nados.io/question/levelorder-linewise-zig-zag
    public static void levelOrderLinewiseZZ(Node node) {
        Stack<Node> s = new Stack<>();
        Stack<Node> cs = new Stack<>();

        s.push(node);
        int level = 1;

        while(s.size() > 0) {
            node = s.pop();
            System.out.print(node.data+" ");
            if(level%2 == 1) {
                for(Node child: node.children)
                    cs.push(child);
            } else {
                for(int i=node.children.size()-1; i>=0; i--) {
                    cs.push(node.children.get(i));
                }
            }

            if(s.size() == 0) {
                s = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        // levelOrder(root);
        // levelOrderLinewise3(root);
        System.out.println("Level Order Linewise ZigZag");
        levelOrderLinewiseZZ(root);
    }
}