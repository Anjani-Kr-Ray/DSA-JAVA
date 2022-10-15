// https://nados.io/question/intersection-point-of-linked-lists

import java.util.Scanner;

public class IntersectionOfTwoLL {
    static class Node {
        int data;
        Node next;
    }

    static class LinkedList {
        Node head;
        Node tail;
        int size;

        private Node getNodeAt(int idx) {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public void addLast(int val) {
            Node n = new Node();
            n.data = val;
            n.next = null;

            if(size == 0) {
                head = tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
            size++;
        }

        public static int findIntersection(LinkedList l1, LinkedList l2) {
            Node t1 = l1.head;
            Node t2 = l2.head;

            int delta = Math.abs(l1.size-l2.size);

            if(l1.size > l2.size) {
                for(int i=0; i<delta; i++)
                    t1 = t1.next;
            } else if(l1.size < l2.size){
                for(int i=0; i<delta; i++)
                    t2 = t2.next;
            }

            while(t1 != t2) {
                t1 = t1.next;
                t2 = t2.next;
            }

            return t1.data;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n1 = Integer.parseInt(sc.nextLine());
        LinkedList l1 = new LinkedList();
        String[] values1 = sc.nextLine().split(" ");
        for (int i = 0; i < n1; i++) {
            int d = Integer.parseInt(values1[i]);
            l1.addLast(d);
        }

        int n2 = Integer.parseInt(sc.nextLine());
        LinkedList l2 = new LinkedList();
        String[] values2 = sc.nextLine().split(" ");
        for (int i = 0; i < n2; i++) {
            int d = Integer.parseInt(values2[i]);
            l2.addLast(d);
        }

        int li = Integer.parseInt(sc.nextLine());
        int di = Integer.parseInt(sc.nextLine());
        if(li == 1){
            Node n = l1.getNodeAt(di);
            l2.tail.next = n;
            l2.tail = l1.tail;
            l2.size += l1.size - di;
        } else {
            Node n = l2.getNodeAt(di);
            l1.tail.next = n;
            l1.tail = l2.tail;
            l1.size += l2.size - di;
        }

        int inter = LinkedList.findIntersection(l1, l2);
        System.out.println(inter);
    }
}
