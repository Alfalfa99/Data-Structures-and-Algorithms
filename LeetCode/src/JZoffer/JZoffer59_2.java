package JZoffer;

import java.util.*;

public class JZoffer59_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        MaxQueue mq = new MaxQueue();
        mq.push_back(2);
        mq.push_back(3);
        System.out.println(mq.max_value());
        mq.pop_front();
        mq.push_back(1);
        System.out.println(mq.max_value());
        mq.pop_front();
        mq.pop_front();
    }

    static class MaxQueue {
        Queue<Integer> que;
        Deque<Integer> deq;

        public MaxQueue() {
            que = new LinkedList<>();  //队列：插入和删除
            deq = new LinkedList<>();  //双端队列：获取最大值
        }

        public int max_value() {
            return deq.size()>0?deq.peek():-1;  //双端队列的队首为que的最大值
        }

        public void push_back(int value) {
            que.offer(value);  //value入队
            while(deq.size()>0 && deq.peekLast()<value){
                deq.pollLast();  //将deq队尾小于value的元素删掉
            }
            deq.offerLast(value);  //将value放在deq队尾
        }

        public int pop_front() {
            int tmp = que.size()>0?que.poll():-1;  //获得队首元素
            if(deq.size()>0 && deq.peek().equals(tmp)){
                deq.poll();  //如果出队的元素是当前最大值，将deq的队首出队
            }
            return tmp;
        }
    }
}
