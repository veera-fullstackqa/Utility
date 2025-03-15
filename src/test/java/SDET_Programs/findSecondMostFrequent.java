package SDET_Programs;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class findSecondMostFrequent {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 4, 3, 1, 1, 3, 3, 4, 4, 4, 5, 5, 5, 5};

        System.out.println("Second most repeated element: " + findSecondMostFrequent(arr));
    }

    public static int findSecondMostFrequent(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // First Pass: Count occurrences
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Second Pass: Find the highest frequency
        int maxFreq = Collections.max(frequencyMap.values());

        // Third Pass: Find the second highest frequency
        int secondMaxFreq = Integer.MIN_VALUE;
        for (int freq : frequencyMap.values()) {
            if (freq < maxFreq && freq > secondMaxFreq) {
                secondMaxFreq = freq;
            }
        }

        // Fourth Pass: Find the element with second highest frequency
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == secondMaxFreq) {
                return entry.getKey();
            }
        }

        return -1; // If no second most frequent element exists
    }
}

