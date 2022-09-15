// https://nados.io/question/is-linked-list-a-palindrome

import java.util.Scanner;

public class PalindromeLL {
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

            if(size == 0) {
                head = tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
            size++;
        }

        public void display() {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data);
                temp = temp.next;
            }
            System.out.println();
        }

        Node left;
        private boolean checkPalindromeHelper(Node right) {
            if(right == null)
                return true;

            boolean res = checkPalindromeHelper(right.next);

            if (!res)
                return false;
            else if (right.data != left.data)
                return false;
            else {
                left = left.next;
                return true;
            }
        }
        public boolean checkPalindrome() {
            left = head;
            return checkPalindromeHelper(head);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList l = new LinkedList();
        for(int i=0; i<n; i++) {
            l.addLast(sc.nextInt());
        }

        System.out.println(l.checkPalindrome());
    }
}
