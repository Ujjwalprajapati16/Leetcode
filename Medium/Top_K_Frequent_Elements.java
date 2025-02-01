import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {

        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] i1, int[] i2) -> Integer.compare(i1[1], i2[1]));

        for (int i : map.keySet()) {
            int[] arr = { i, map.get(i) };
            if (pq.size() < k) {
                pq.add(arr);
            } else if (map.get(i) > pq.peek()[1]) {
                pq.remove();
                pq.add(arr);
            }
        }

        int ans[] = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.remove()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        Top_K_Frequent_Elements obj = new Top_K_Frequent_Elements();
        int nums[] = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        int ans[] = obj.topKFrequent(nums, k);
        for (int i : ans) {
            System.out.print(i + " ");
        }

        System.out.println();

        nums = new int[] { 1 };
        k = 1;
        ans = obj.topKFrequent(nums, k);
        for (int i : ans) {
            System.out.print(i + " ");
        }

        System.out.println();

        nums = new int[] { 1, 2 };
        k = 2;
        ans = obj.topKFrequent(nums, k);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}

/*
 * 347. Top K Frequent Elements Solved Medium Topics Companies Given an integer
 * array nums and an integer k, return the k most frequent elements. You may
 * return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2] Example 2:
 * 
 * Input: nums = [1], k = 1 Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 -104 <= nums[i] <= 104 k is in the range [1, the
 * number of unique elements in the array]. It is guaranteed that the answer is
 * unique.
 * 
 * 
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 */