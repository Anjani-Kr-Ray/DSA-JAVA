import java.util.Scanner;

public class LinkedList {

    Node head;
    Node tail;
    int size;

    class Node {
        int data;
        Node next;
    }

    // https://nados.io/question/add-last-in-linked-list
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
        size+=1;
    }

    // https://nados.io/question/display-a-linkedlist
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

    // https://nados.io/question/remove-first-in-linkedlist
    public void removeFirst(){
        if(size == 0) {
            System.out.println("List is empty");
        } else if(size == 1) {
            head = tail = null;
            size = 0;
        } else {
            head = head.next;
            size--;
        }
    }

    // https://nados.io/question/get-value-in-linked-list
    public int getFirst(){
        if(size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return head.data;
    }

    public int getLast(){
        if(size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return tail.data;
    }

    public int getAt(int idx){
        if(size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        if(idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return -1;
        }
        Node temp = head;
        for(int i=0; i<idx; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // https://nados.io/question/add-first-in-linked-list
    public void addFirst(int val) {
        Node node = new Node();
        node.data = val;
        node.next = null;

        if(size == 0) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size += 1;
    }

    // https://nados.io/question/add-at-index-in-linked-list
    public void addAt(int idx, int val) {
        if(idx < 0 || idx > size)
            System.out.println("Invalid arguments");
        else if(idx == 0)
            addFirst(val);
        else if(idx == size)
            addLast(val);
        else {
            Node temp = head;
            for(int i=0; i<idx-1; i++) {
                temp = temp.next;
            }
            Node newNode = new Node();
            newNode.data = val;
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    // https://nados.io/question/remove-last-in-linked-list
    public void removeLast() {
        if(size == 0) {
            System.out.println("List is empty");
        } else if(size == 1) {
            head = tail = null;
            size = 0;
        } else {
            Node temp = head;
            for(int i=0; i<size-2; i++) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
            size--;
        }
    }

    // https://nados.io/question/remove-at-index-in-linked-list
    public void removeAt(int idx) {
        if(idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
        } else if(idx == 0) {
            removeFirst();
        } else if(idx == size-1) {
            removeLast();
        } else {
            Node temp = head;
            for(int i=0; i<idx-1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.next = null;
            size--;
        }

    }

    // https://nados.io/question/reverse-a-linked-list-data-iterative
    private Node getNodeAt(int idx) {
        Node temp = head;
        for(int i=0; i<idx; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void reverseDI() {
        int li = 0;
        int ri = size - 1;

        while(li < ri) {
            Node left = getNodeAt(li);
            Node right = getNodeAt(ri);

            int temp = left.data;
            left.data = right.data;
            right.data = temp;

            li++;
            ri--;
        }
    }

    // https://nados.io/question/reverse-linked-list-pointer-iterative
    public void reversePI() {
        Node prev = null;
        Node curr = head;

        while(curr!=null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        Node temp = head;
        head = tail;
        tail = temp;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        String str = sc.nextLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("addLast")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            } else if (str.startsWith("size")) {
                System.out.println(list.size());
            } else if (str.startsWith("display")) {
                list.display();
            } else if (str.startsWith("removeFirst")) {
                list.removeFirst();
            } else if (str.startsWith("getFirst")) {
                int val = list.getFirst();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("getLast")) {
                int val = list.getLast();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("getAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = list.getAt(idx);
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("addFirst")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addFirst(val);
            } else if (str.startsWith("addAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = Integer.parseInt(str.split(" ")[2]);
                list.addAt(idx, val);
            } else if (str.startsWith("removeLast")) {
                list.removeLast();
            } else if (str.startsWith("removeAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                list.removeAt(idx);
            } else if(str.startsWith("reverseDI")){
                list.reverseDI();
            } else if(str.startsWith("reversePI")){
                list.reversePI();
            }
            str = sc.nextLine();
        }
    }
}
