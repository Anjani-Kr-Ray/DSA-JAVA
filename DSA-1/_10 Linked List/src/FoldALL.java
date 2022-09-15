// https://nados.io/question/fold-a-linked-list

import java.util.Scanner;

public class FoldALL {
    static class Node {
        int data;
        Node next;
    }

    static class LinkedList {
        Node head;
        Node tail;
        int size;

        public void addLast(int val) {
            Node n = new Node();
            n.data = val;
            n.next = null;

            if (size == 0) {
                head = tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
            size++;
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }

        Node left;
        public void fold() {
            left = head;
            foldHelper(head, 0);
        }

        private void foldHelper(Node right, int floor) {
            if(right == null) {
                return;
            }
            foldHelper(right.next, floor + 1);
            if(floor > size/2) {
                right.next = left.next;
                left.next = right;
                left = right.next;
            } else if(floor == size/2) {
                tail = right;
                tail.next = null;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList l = new LinkedList();
        for(int i=0; i<n; i++) {
            l.addLast(sc.nextInt());
        }
        System.out.print("Original --> ");
        l.display();
        l.fold();
        System.out.print("After folding --> ");
        l.display();
    }
}
