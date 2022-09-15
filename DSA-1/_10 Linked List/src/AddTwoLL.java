// https://nados.io/question/add-two-linked-lists

import java.util.Scanner;

public class AddTwoLL {
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

        public void addFirst(int val) {
            Node n = new Node();
            n.data = val;
            n.next = null;

            if (size == 0) {
                head = tail = n;
            } else {
                n.next = head;
                head = n;
            }
            size++;
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        private static int addListHelper(Node one, int pv1, Node two, int pv2, LinkedList res) {
            if(one == null && two == null) {
                return 0;
            }
            int data = 0;
            if(pv1 > pv2) {
                int receivedCarry = addListHelper(one.next, pv1 - 1, two, pv2, res);
                data = one.data + receivedCarry;
            } else if(pv1 < pv2) {
                int receivedCarry = addListHelper(one, pv1, two.next, pv2 - 1, res);
                data = two.data + receivedCarry;
            } else {
                int receivedCarry = addListHelper(one.next, pv1-1, two.next, pv2-1, res);
                data = one.data + two.data + receivedCarry;
            }
            int val = data % 10;
            int newCarry = data / 10;
            res.addFirst(val);
            return newCarry;
        }

        public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
            LinkedList res = new LinkedList();
            int receivedCarry = addListHelper(one.head, one.size, two.head, two.size, res);
            if(receivedCarry > 0) {
                res.addFirst(receivedCarry);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList l1 = new LinkedList();
        for(int i=0; i<n; i++) {
            l1.addLast(sc.nextInt());
        }

        int m = sc.nextInt();

        LinkedList l2 = new LinkedList();
        for(int i=0; i<m; i++) {
            l2.addLast(sc.nextInt());
        }

        LinkedList l = LinkedList.addTwoLists(l1, l2);
        l.display();
    }

}
