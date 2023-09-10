package problems.leetpr00023;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution st = new Solution();
        ListNode[] ln;
        ListNode ret, temp;
        List<int[]> intList;
        int arrlength;

        System.out.println("1 | [1,1,2,3,4,4,5,6] | ==================================");
        int[][] arr1 = {{1,4,5},{1,3,4},{2,6}};
        intList = Arrays.asList(arr1);

        // 결과 출력
//        System.out.println(intList.size()); // 3
//        System.out.println(intList.get(0)); // I@71bb301
//        System.out.println(Arrays.toString(intList.get(0)));  // [1, 4, 5]
//        System.out.println(Arrays.toString(intList.get(1)));  // [1, 3, 4]

        ln = new ListNode[intList.size()];
        for (int i = 0; i < intList.size(); ++i) {
            temp = null;
            ListNode nxt = temp;
            for (int j = 0; j < intList.get(i).length; ++j) {
                if (temp == null) {
                    temp = new ListNode();
                    nxt = temp;
                } else {
                    nxt.next = new ListNode();
                    nxt = nxt.next;
                }
                nxt.val = arr1[i][j];
            }
            ln[i] = temp;
        }
        for (int i = 0; i < ln.length; ++i) {
            temp = ln[i];
            System.out.print("[");
            while(temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.print("]\n");
        }
        ret = st.mergeKLists(ln);
        temp = ret;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

        System.out.println("2 | [1 4 5] | ==================================");
        int[][] arr2 = {{1,4,5}};
        intList = Arrays.asList(arr2);
        arrlength = arr2.length;
        ln = new ListNode[arrlength];
        ln = new ListNode[intList.size()];
        for (int i = 0; i < intList.size(); ++i) {
            temp = null;
            ListNode nxt = temp;
            for (int j = 0; j < intList.get(i).length; ++j) {
                if (temp == null) {
                    temp = new ListNode();
                    nxt = temp;
                } else {
                    nxt.next = new ListNode();
                    nxt = nxt.next;
                }
                nxt.val = arr1[i][j];
            }
            ln[i] = temp;
        }
        for (int i = 0; i < ln.length; ++i) {
            temp = ln[i];
            System.out.print("[");
            while(temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.print("]\n");
        }
        ret = st.mergeKLists(ln);
        temp = ret;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

        System.out.println("3 | [] | ==================================");
        int[][] arr3 = {{}};
        intList = Arrays.asList(arr3);
        ln = new ListNode[intList.size()];
        for (int i = 0; i < intList.size(); ++i) {
            temp = null;
            ListNode nxt = temp;
            for (int j = 0; j < intList.get(i).length; ++j) {
                if (temp == null) {
                    temp = new ListNode();
                    nxt = temp;
                } else {
                    nxt.next = new ListNode();
                    nxt = nxt.next;
                }
                nxt.val = arr1[i][j];
            }
            ln[i] = temp;
        }
        for (int i = 0; i < ln.length; ++i) {
            temp = ln[i];
            System.out.print("[");
            while(temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.print("]\n");
        }
        ret = st.mergeKLists(ln);
        temp = ret;
        if (temp == null) System.out.println("Return is null !");
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

        System.out.println("4 | [] | ==================================");
        int[][] arr4 = {};
        intList = Arrays.asList(arr4);
//        System.out.println(intList.size()); // 0
        ln = new ListNode[intList.size()];
        for (int i = 0; i < intList.size(); ++i) {
            temp = null;
            ListNode nxt = temp;
            for (int j = 0; j < intList.get(i).length; ++j) {
                if (temp == null) {
                    temp = new ListNode();
                    nxt = temp;
                } else {
                    nxt.next = new ListNode();
                    nxt = nxt.next;
                }
                nxt.val = arr1[i][j];
            }
            ln[i] = temp;
        }
        for (int i = 0; i < ln.length; ++i) {
            temp = ln[i];
            System.out.print("[");
            while(temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.print("]\n");
        }
        ret = st.mergeKLists(ln);
        temp = ret;
        if (temp == null) System.out.println("Return is null !");
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode p1, ListNode p2) {
                return p1.val >= p2.val ? 1 : -1;
            }
        });

        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) pq.add(lists[i]);
        }

        ListNode ret = null;
        ListNode temp = new ListNode();
        ListNode qtemp;
        while (!pq.isEmpty()) {
            if (ret == null) {
                ret = new ListNode();
                temp = ret;
            } else {
                temp.next = new ListNode();
                temp = temp.next;
            }
            qtemp = pq.poll();
            temp.val = qtemp.val;
            if (qtemp.next != null) {
                ListNode qtemp2 = qtemp;
                qtemp = qtemp.next;
                qtemp2.next = null;
                pq.add(qtemp);
            }
        }

        return ret;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

