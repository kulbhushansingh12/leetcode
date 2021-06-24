package leetcode;

// https://leetcode.com/problems/design-circular-queue/
public class MyCircularQueue {
    int start = 0;
    int rear = 0; // points to next element
    int size = 0;
    final int capacity;
    int[] queue;

    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (size == capacity) {
            return false;
        }
        queue[rear] = value;
        rear = getIncrementedIndex(rear);
        ++size;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        start = getIncrementedIndex(start);
        --size;
        return true;
    }

    public int Front() {
        return queue[start];
    }

    public int Rear() {
        return queue[getDecrementedIndex(rear)];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private int getIncrementedIndex(int currIndex) {
        return currIndex == queue.length - 1 ? 0 : currIndex + 1;
    }

    private int getDecrementedIndex(int currIndex) {
        return currIndex == 0 ? queue.length - 1 : currIndex - 1;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(2)); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        System.out.println(myCircularQueue.Rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        System.out.println(myCircularQueue.deQueue());  // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear());     // return 4
    }
}
