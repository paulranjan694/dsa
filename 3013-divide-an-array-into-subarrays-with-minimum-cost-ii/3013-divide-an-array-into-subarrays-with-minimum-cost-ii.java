import java.util.*;

class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        // TreeSet to store (value, index) pairs
        TreeSet<int[]> kMinimum = new TreeSet<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0])
                                   : Integer.compare(a[1], b[1])
        );

        TreeSet<int[]> remaining = new TreeSet<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0])
                                   : Integer.compare(a[1], b[1])
        );

        long sum = 0; // sum of (k-1) smallest elements
        long result = Long.MAX_VALUE;

        int i = 1;

        // Build initial window
        while (i - dist < 1) {
            int[] cur = new int[]{nums[i], i};
            kMinimum.add(cur);
            sum += nums[i];

            if (kMinimum.size() > k - 1) {
                int[] largest = kMinimum.pollLast();
                sum -= largest[0];
                remaining.add(largest);
            }
            i++;
        }

        // Sliding window
        while (i < n) {
            int[] cur = new int[]{nums[i], i};
            kMinimum.add(cur);
            sum += nums[i];

            if (kMinimum.size() > k - 1) {
                int[] largest = kMinimum.pollLast();
                sum -= largest[0];
                remaining.add(largest);
            }

            result = Math.min(result, sum);

            // Remove element that goes out of window
            int removeIdx = i - dist;
            int[] toRemove = new int[]{nums[removeIdx], removeIdx};

            if (kMinimum.remove(toRemove)) {
                sum -= nums[removeIdx];

                if (!remaining.isEmpty()) {
                    int[] promote = remaining.pollFirst();
                    kMinimum.add(promote);
                    sum += promote[0];
                }
            } else {
                remaining.remove(toRemove);
            }

            i++;
        }

        return nums[0] + result;
    }
}
