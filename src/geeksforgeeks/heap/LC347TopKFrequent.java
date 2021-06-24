package geeksforgeeks.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

// https://leetcode.com/problems/top-k-frequent-elements/
public class LC347TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1, n2) -> numFreq.get(n1) - numFreq.get(n2));
        // least frequency element is on top as per comparator, so keep removing element from top when size is greater than k
        for (Integer key : numFreq.keySet()) {
            priorityQueue.add(key);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];
        Iterator<Integer> iterator = priorityQueue.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            result[index] = iterator.next();
            ++index;
        }
        return result;
    }

    // TreeMap sorted on values -> nlogn time complexity
    public int[] topKFrequentWithTreeMap(int[] nums, int k) {

        Map<Integer, Integer> count = new TreeMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        LinkedHashMap<Integer, Integer> sorted = count.entrySet()
                .stream()
                .sorted(Entry.comparingByValue((n1, n2) -> n2 - n1))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        int[] result = new int[k];
        int index = 1;
        for (int num : sorted.keySet()) {
            result[index - 1] = num;
            ++index;
            if (index > k) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LC347TopKFrequent topKFrequent = new LC347TopKFrequent();
        System.out.println(Arrays.toString(topKFrequent.topKFrequentWithTreeMap(new int[]{1,1,1,2,2,3}, 2)));//1,2
        //[4,1,-1,2,-1,2,3]
        System.out.println(Arrays.toString(topKFrequent.topKFrequentWithTreeMap(new int[]{4,1,-1,2,-1,2,3}, 2)));//-1,2
    }
}
