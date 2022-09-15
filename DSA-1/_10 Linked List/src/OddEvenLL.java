// https://nados.io/question/odd-even-linked-list

import java.util.Scanner;

public class OddEvenLL {
    static class Node {
        int data;
        Node next;
    }

    static class LinkedList {
        Node head;
        Node tail;
        int size;

        public int size() {
            return size;
        }

        public void display() {
            Node temp = head;
            while(temp!=null) {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
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

        public int removeFirst() {
            Node temp = head;
            if(size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            if(size == 1) {
                head = tail = null;
            } else {
                head = head.next;
            }
            size--;
            temp.next = null;
            return temp.data;
        }

        public void oddEven() {
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();

            while(this.size > 0) {
                int val = this.removeFirst();

                if(val%2 == 0) {
                    even.addLast(val);
                } else {
                    odd.addLast(val);
                }
            }

            if(odd.size > 0 && even.size > 0) {
                odd.tail.next = even.head;
                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size + even.size;
            } else if(odd.size > 0) {
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            } else if(even.size > 0) {
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
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
        l.oddEven();
        l.display();
    }
}
