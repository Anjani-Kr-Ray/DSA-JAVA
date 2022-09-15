// https://nados.io/question/remove-duplicates-in-a-sorted-linked-list

import java.util.Scanner;

public class RemoveDuplicatesInSortedLL {
    static class Node {
        int data;
        Node next;
    }

    static class LinkedList {
        Node head;
        Node tail;
        int size;

        public void addLast(int val) {
            Node newNode = new Node();
            newNode.data = val;
            newNode.next = null;

            if(size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            size++;
        }

        public void display() {
            Node temp = head;

            while(temp != null) {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }

        public void removeDuplicates() {
            Node i = head;
            Node j = head.next;

            while(j != null) {
                if(i.data != j.data) {
                    i.next = j;
                    i = j;
                }
                j = j.next;
            }

            i.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = Integer.parseInt(sc.nextLine());
        LinkedList l1 = new LinkedList();
        String[] values1 = sc.nextLine().split(" ");
        for (int i = 0; i < n1; i++) {
            int d = Integer.parseInt(values1[i]);
            l1.addLast(d);
        }
        l1.removeDuplicates();
        l1.display();
    }
}
