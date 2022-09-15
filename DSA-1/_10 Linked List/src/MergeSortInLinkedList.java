// https://nados.io/question/merge-sort-a-linked-list

import java.util.Scanner;

public class MergeSortInLinkedList {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            LinkedList ml = new LinkedList();

            Node one = l1.head;
            Node two = l2.head;
            while (one != null && two != null) {
                if (one.data < two.data) {
                    ml.addLast(one.data);
                    one = one.next;
                } else {
                    ml.addLast(two.data);
                    two = two.next;
                }
            }

            while (one != null) {
                ml.addLast(one.data);
                one = one.next;
            }

            while (two != null) {
                ml.addLast(two.data);
                two = two.next;
            }

            return ml;
        }

        public static Node midNode(Node head, Node tail) {
            Node slow = head;
            Node fast = head;

            while(fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        public static LinkedList mergeSort(Node head, Node tail) {
            if(head == tail) {
                LinkedList res = new LinkedList();
                res.addLast(head.data);
                return res;
            }
            Node mid = midNode(head, tail);
            LinkedList fsh = mergeSort(head, mid);
            LinkedList ssh = mergeSort(mid.next, tail);
            LinkedList res = LinkedList.mergeTwoSortedLists(fsh, ssh);

            return res;
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

        LinkedList sorted = LinkedList.mergeSort(l1.head, l1.tail);
        sorted.display();
    }
}