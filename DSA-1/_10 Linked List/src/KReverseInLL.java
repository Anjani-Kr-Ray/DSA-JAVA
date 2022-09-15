// https://nados.io/question/k-reverse-in-linked-list

import java.util.Scanner;

public class KReverseInLL {
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

        public void addFirst(int val) {
            Node n = new Node();
            n.data = val;
            n.next = null;

            if(size == 0) {
                head = tail = n;
            } else {
                n.next = head;
                head = n;
            }
            size++;
        }

        public void kReverse(int k) {
            LinkedList prev = new LinkedList();

            while(this.size > 0) {
                LinkedList curr = new LinkedList();
                if(this.size >= k) {
                    for(int i=0; i<k; i++) {
                        curr.addFirst(this.removeFirst());
                    }
                } else {
                    int s = this.size();
                    for(int i=0; i<s; i++) {
                        curr.addLast(this.removeFirst());
                    }
                }
                if(prev.size == 0) {
                    prev = curr;
                } else {
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size += curr.size;
                }
            }
            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList l = new LinkedList();
        for(int i=0; i<n; i++) {
            l.addLast(sc.nextInt());
        }

        int k = sc.nextInt();
        l.kReverse(k);
        l.display();
    }

}
