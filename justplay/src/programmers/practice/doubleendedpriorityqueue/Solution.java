package programmers.practice.doubleendedpriorityqueue;

import java.util.*;

import java.util.*;

//class Solution {
//
//    static class Node {
//        int id;
//        int value;
//
//        Node(int id, int value) {
//            this.id = id;
//            this.value = value;
//        }
//    }
//
//    public int[] solution(String[] operations) {
//
//        PriorityQueue<Node> minHeap = new PriorityQueue<>(
//                (a, b) -> Integer.compare(a.value, b.value)
//        );
//        PriorityQueue<Node> maxHeap = new PriorityQueue<>(
//                (a, b) -> Integer.compare(b.value, a.value)
//        );
//
//        boolean[] isDeleted = new boolean[operations.length];
//
//        for (int i = 0; i < operations.length; i++) {
//            String[] current = operations[i].split(" ");
//            String action = current[0];
//            int num = Integer.parseInt(current[1]);
//
//            if (action.equals("I")) {
//                Node node = new Node(i, num);
//                minHeap.offer(node);
//                maxHeap.offer(node);
//            } else if (action.equals("D")) {
//                PriorityQueue<Node> target = (num == 1) ? maxHeap : minHeap;
//                removeElement(target, isDeleted);
//            }
//        }
//
//        cleanQueue(maxHeap, isDeleted);
//        cleanQueue(minHeap, isDeleted);
//
//        if (maxHeap.isEmpty()) {
//            return new int[]{0, 0};
//        }
//        return new int[]{maxHeap.peek().value, minHeap.peek().value};
//
//    }
//
//    public void removeElement(PriorityQueue<Node> pq, boolean[] isDeleted) {
//        cleanQueue(pq, isDeleted);
//        if (!pq.isEmpty()) {
//            Node target = pq.poll();
//            isDeleted[target.id] = true;
//        }
//    }
//
//    public void cleanQueue(PriorityQueue<Node> pq, boolean[] isDeleted) {
//        while (!pq.isEmpty() && isDeleted[pq.peek().id]) {
//            pq.poll();
//        }
//    }
//}

class Node{
    int data;
    int id;
    public Node(int data, int id){
        this.data = data;
        this.id = id;
    }
}

public class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        String[] s = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        sol.solution(s);
    }



    public int[] solution(String[] operations) {
        int[] answer = {};
        int[] k = {1,2,3,4,5,6};
        PriorityQueue<Node> priorityQueuemin = new PriorityQueue<>((a,b) -> Integer.compare(a.data, b.data));
        PriorityQueue<Node> priorityQueuemax = new PriorityQueue<>((b,a) -> Integer.compare(a.data, b.data));
        for (int i=0; i<operations.length; i++){
            String[] cur = operations[i].split(" ");
            String operator = cur[0];
            int num = Integer.parseInt(cur[1]);

            if (operator.equals("I")){
                Node node = new Node(num, i);
                priorityQueuemin.add(node);
                priorityQueuemax.add(node);
            } else if (operator.equals("D")) {

                PriorityQueue<Node> target = (num==1) ? priorityQueuemax : priorityQueuemin;
                target.remove();
            }
            
        }

        return answer;
    }
}
