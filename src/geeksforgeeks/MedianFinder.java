package geeksforgeeks;

import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/submissions/
public class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
    }

    public void addNum(int num) {
        if (num < 0) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            } else {
                minHeap.add(maxHeap.poll());
            }

        }
    }

    public double findMedian() {
        if (minHeap.size() == 0) {
            return maxHeap.peek();
        }
        int n1 = maxHeap.size() >= minHeap.size() ? maxHeap.peek() : minHeap.peek();
        if ((minHeap.size() + maxHeap.size()) %2 == 0) {
            int n2 = maxHeap.size() < minHeap.size() ? maxHeap.peek() : minHeap.peek();
            return (double)(n1 + n2) /2.0;
        }

        return n1;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
    }
}
