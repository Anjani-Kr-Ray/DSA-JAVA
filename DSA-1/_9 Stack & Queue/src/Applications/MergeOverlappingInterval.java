// https://nados.io/question/merge-overlapping-interval

package Applications;

import java.util.*;

public class MergeOverlappingInterval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++)
            for(int j=0; j<2; j++)
                arr[i][j] = sc.nextInt();
        mergeOverlappingIntervalsUsingClass(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        Stack<ArrayList<Integer>> intervals = new Stack<>();
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        for(int i=0; i<arr.length; i++) {
            if (intervals.size() != 0) {
                ArrayList<Integer> temp = intervals.peek();
                if (arr[i][0] <= temp.get(1)) {
                    intervals.pop();
                    if (arr[i][1] > temp.get(1))
                        intervals.push(new ArrayList<>(Arrays.asList(temp.get(0), arr[i][1])));
                    else
                        intervals.push(new ArrayList<>(Arrays.asList(temp.get(0), temp.get(1))));
                } else {
                    intervals.push(new ArrayList<>(Arrays.asList(arr[i][0], arr[i][1])));
                }
            } else {
                intervals.push(new ArrayList<>(Arrays.asList(arr[i][0], arr[i][1])));
            }
        }

        printStackReverse(intervals);
    }

    private static void printStackReverse(Stack<ArrayList<Integer>> intervals) {
        if (intervals.isEmpty())
            return;
        ArrayList<Integer> temp = intervals.peek();

        intervals.pop();
        printStackReverse(intervals);
        System.out.println(temp.get(0)+" "+temp.get(1));
        intervals.push(temp);

    }

    public static void mergeOverlappingIntervalsUsingClass(int[][] arr) {
        Pair[] pairs = new Pair[arr.length];
        for(int i=0; i<arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(pairs);
        Stack<Pair> intervals = new Stack<>();

        for(int i=0; i<pairs.length; i++) {
            if(i==0) {
                intervals.push(pairs[i]);
            } else {
                Pair tp = intervals.peek();
                if(pairs[i].st > tp.et) {
                    intervals.push(pairs[i]);
                } else {
                    tp.et = Math.max(tp.et, pairs[i].et);
                }
            }
        }

        Stack<Pair> rs = new Stack<>();
        while(intervals.size()!=0) {
            rs.push(intervals.pop());
        }

        while(rs.size()!=0) {
            Pair p = rs.pop();
            System.out.println(p.st+" "+p.et);
        }
    }

    private static class Pair implements Comparable<Pair> {
        int st;
        int et;

        Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.st!=o.st) {
                return this.st - o.st;
            } else {
                return this.et - o.et;
            }

        }
    }
}
