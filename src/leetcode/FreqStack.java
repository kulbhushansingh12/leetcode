package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

// https://leetcode.com/problems/maximum-frequency-stack/
public class FreqStack {
    // frequency map
    Map<Integer, Integer> frequencyMap;//5,3
    List<Stack<Integer>> maxStack; // 0->s->5,6,4
                                    // 1 ->s -> 5,6,4
                                    // 2 -> s -> 5,4
    int maxFreq = 0;
    public FreqStack() {
        this.frequencyMap = new HashMap<>();
        this.maxStack = new ArrayList<>();
    }

    //5,7,5,7,4,5
    public void push(int x) {
        int frequency = frequencyMap.getOrDefault(x, 0) + 1;//
        frequencyMap.put(x, frequency);// 5,1
        // If it is not there, create new
        Stack<Integer> integers = (frequency - 1) < maxStack.size() ? maxStack.get(frequency - 1) : new Stack<>();
        integers.push(x);// 5
        if (maxStack.size() < frequency) {
            maxStack.add(frequency - 1, integers);
        }
        if (frequency > maxFreq) {
            maxFreq = frequency;
        }
    }

    public int pop() {
        Stack<Integer> integers = maxStack.get(maxFreq - 1);
        if (integers.size() <= 1) {
            // Reduce max frequency
            maxFreq -= 1;
        }
        int element = integers.pop();
        frequencyMap.put(element, frequencyMap.get(element) - 1);
        return element;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        // 5,7,5,7,4,5
        /*freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop()); //5
        System.out.println(freqStack.pop());//7
        System.out.println(freqStack.pop());//5
        System.out.println(freqStack.pop());//4*/

        // 4],[0],[9],[3],[4],[2
        freqStack = new FreqStack();
        freqStack.push(4);
        freqStack.push(0);
        freqStack.push(9);
        freqStack.push(3);
        freqStack.push(4);
        freqStack.push(2);
        System.out.println(freqStack.pop());//4
        freqStack.push(6);
        System.out.println(freqStack.pop());
        freqStack.push(1);
        System.out.println(freqStack.pop());
        freqStack.push(1);
        System.out.println(freqStack.pop());
        freqStack.push(4);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }

}
