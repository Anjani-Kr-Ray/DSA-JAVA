// https://nados.io/question/linked-list-to-queue-adapter

import java.util.LinkedList;
import java.util.Scanner;

public class LLToQueueAdapter {
    public static class LLTSA {
        LinkedList<Integer> list;

        public LLTSA() {
            list = new LinkedList<>();
        }


        int size() {
            return list.size();
        }

        void add(int val) {
            list.addLast(val);
        }

        int remove() {
            if(size()==0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.removeFirst();
            }
        }

        int peek() {
            if(size()==0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.getFirst();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        LLTSA st = new LLTSA();

        String str = sc.nextLine();
        while(str.equals("quit") == false){
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.add(val);
            } else if(str.startsWith("remove")){
                int val = st.remove();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("peek")){
                int val = st.peek();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(st.size());
            }
            str = sc.nextLine();
        }
    }
}
