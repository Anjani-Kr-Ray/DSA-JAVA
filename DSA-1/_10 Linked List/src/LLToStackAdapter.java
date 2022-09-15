// https://nados.io/question/linked-list-to-stack-adapter

import java.util.LinkedList;
import java.util.Scanner;

public class LLToStackAdapter {
    public static class LLTSA {
        LinkedList<Integer> list;

        public LLTSA() {
            list = new LinkedList<>();
        }


        int size() {
            return list.size();
        }

        void push(int val) {
            list.addFirst(val);
        }

        int pop() {
            if(size()==0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return list.removeFirst();
            }
        }

        int top() {
            if(size()==0) {
                System.out.println("Stack underflow");
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
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if(str.startsWith("pop")){
                int val = st.pop();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("top")){
                int val = st.top();
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
