// https://nados.io/question/merge-two-sorted-linked-lists

import java.util.Scanner;

public class MergeTwoSortedLinkedList {
    static class NodeL {
        int data;
        NodeL next;
    }

    static class LL {
        NodeL head;
        NodeL tail;
        int size;

        public void addLast(int val) {
            NodeL newNode = new NodeL();
            newNode.data = val;
            newNode.next = null;

            if(size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size+=1;
        }

        public void display() {
            NodeL temp = head;
            while(temp!=null) {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }

        public static LL mergeTwoList(LL l1, LL l2) {
            NodeL l1i = l1.head;
            NodeL l2j = l2.head;

            LL newll = new LL();
            while(l1i != null && l2j != null) {
                if(l1i.data < l2j.data) {
                    newll.addLast(l1i.data);
                    l1i = l1i.next;
                }
                else {
                    newll.addLast(l2j.data);
                    l2j = l2j.next;
                }
            }

            while(l1i != null) {
                newll.addLast(l1i.data);
                l1i = l1i.next;
            }

            while(l2j != null) {
                newll.addLast(l2j.data);
                l2j = l2j.next;
            }

            return newll;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LL l1 = new LL();
        for(int i=0; i<n; i++) {
            l1.addLast(sc.nextInt());
        }

        int m = sc.nextInt();
        LL l2 = new LL();
        for(int i=0; i<m; i++) {
            l2.addLast(sc.nextInt());
        }

        LL mergedList = LL.mergeTwoList(l1, l2);
        mergedList.display();
    }
}
