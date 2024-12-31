
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Find_Score_of_an_Array_After_Marking_All_Elements {

    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            }
            return Integer.compare(a[1], b[1]);
        });

        Set<Integer> marked = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
        }
        long score = 0;
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && marked.contains(pq.peek()[1])) {
                pq.remove();
            }
            if (pq.isEmpty()) {
                break;
            }
            int current[] = pq.remove();
            score += current[0];
            marked.add(current[1]);
            if (current[1] - 1 >= 0) {
                marked.add(current[1] - 1);
            }
            if (current[1] + 1 < nums.length) {
                marked.add(current[1] + 1);
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Find_Score_of_an_Array_After_Marking_All_Elements solution = new Find_Score_of_an_Array_After_Marking_All_Elements();
        int[] nums = {2, 1, 3, 4, 5, 2};
        System.out.println(solution.findScore(nums));

        int[] nums1 = {2, 3, 5, 1, 3, 2};
        System.out.println(solution.findScore(nums1));
    }
}

/*
 2593. Find Score of an Array After Marking All Elements
Solved
Medium
Topics
Companies
Hint
You are given an array nums consisting of positive integers.

Starting with score = 0, apply the following algorithm:

Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.
Add the value of the chosen integer to score.
Mark the chosen element and its two adjacent elements if they exist.
Repeat until all the array elements are marked.
Return the score you get after applying the above algorithm.

 

Example 1:

Input: nums = [2,1,3,4,5,2]
Output: 7
Explanation: We mark the elements as follows:
- 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,1,3,4,5,2].
- 2 is the smallest unmarked element, so we mark it and its left adjacent element: [2,1,3,4,5,2].
- 4 is the only remaining unmarked element, so we mark it: [2,1,3,4,5,2].
Our score is 1 + 2 + 4 = 7.
Example 2:

Input: nums = [2,3,5,1,3,2]
Output: 5
Explanation: We mark the elements as follows:
- 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,3,5,1,3,2].
- 2 is the smallest unmarked element, since there are two of them, we choose the left-most one, so we mark the one at index 0 and its right adjacent element: [2,3,5,1,3,2].
- 2 is the only remaining unmarked element, so we mark it: [2,3,5,1,3,2].
Our score is 1 + 2 + 2 = 5.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 106
 */
