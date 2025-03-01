import java.util.HashMap;
import java.util.Map;

public class Tuple_with_Same_Product {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int res = nums[i] * nums[j];
                productMap.put(res, productMap.getOrDefault(res, 0) + 1);
            }
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : productMap.entrySet()) {
            // int product = entry.getKey();
            int count = entry.getValue();
            if (count >= 2) {
                int comb = (count * (count - 1)) / 2;
                ans = ans + comb * 8;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Tuple_with_Same_Product obj = new Tuple_with_Same_Product();
        int nums[] = { 2, 3, 4, 6 };
        int ans = obj.tupleSameProduct(nums);
        System.out.println(ans);

        int nums1[] = { 1, 2, 4, 5, 10 };
        int ans1 = obj.tupleSameProduct(nums1);
        System.out.println(ans1);
    }
}

/*
 * 1726. Tuple with Same Product Solved Medium Topics Companies Hint Given an
 * array nums of distinct positive integers, return the number of tuples (a, b,
 * c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and
 * a != b != c != d.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,4,6] Output: 8 Explanation: There are 8 valid tuples:
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3) (3,4,2,6) , (4,3,2,6) ,
 * (3,4,6,2) , (4,3,6,2) Example 2:
 * 
 * Input: nums = [1,2,4,5,10] Output: 16 Explanation: There are 16 valid tuples:
 * (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2) (2,5,1,10) , (2,5,10,1) ,
 * (5,2,1,10) , (5,2,10,1) (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
 * (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 1000 1 <= nums[i] <= 104 All elements in nums are
 * distinct.
 */