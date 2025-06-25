public class Kth_Smallest_Product_of_Two_Sorted_Arrays {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10000000000L;
        long high = 10000000000L;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countPairs(mid, nums1, nums2) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private long countPairs(long target, int[] nums1, int[] nums2) {
        int n2 = nums2.length;

        long count = 0;

        for (int num : nums1) {
            if (num == 0) {
                if (target >= 0) {
                    count += n2;
                }
            } else if (num > 0) {
                int low = 0, high = n2 - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;

                    long prod = (long) num * nums2[mid];
                    if (prod <= target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                count += low;
            } else {
                int low = 0, high = n2 - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    long prod = (long) num * nums2[mid];
                    if (prod <= target) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }

                count += (n2 - low);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Kth_Smallest_Product_of_Two_Sorted_Arrays solution = new Kth_Smallest_Product_of_Two_Sorted_Arrays();
        int[] nums1 = { 2, 5 };
        int[] nums2 = { 3, 4 };
        long k = 2;
        long result = solution.kthSmallestProduct(nums1, nums2, k);
        System.out.println(result); // Output: 8

        int[] nums3 = { -4, -2, 0, 3 };
        int[] nums4 = { 2, 4 };
        long k2 = 6;
        long result2 = solution.kthSmallestProduct(nums3, nums4, k2);
        System.out.println(result2); // Output: 0
    }
}

/*
 * 2040. Kth Smallest Product of Two Sorted Arrays Solved Hard Topics premium
 * lock icon Companies Hint Given two sorted 0-indexed integer arrays nums1 and
 * nums2 as well as an integer k, return the kth (1-based) smallest product of
 * nums1[i] * nums2[j] where 0 <= i < nums1.length and 0 <= j < nums2.length.
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [2,5], nums2 = [3,4], k = 2 Output: 8 Explanation: The 2
 * smallest products are: - nums1[0] * nums2[0] = 2 * 3 = 6 - nums1[0] *
 * nums2[1] = 2 * 4 = 8 The 2nd smallest product is 8. Example 2:
 * 
 * Input: nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6 Output: 0 Explanation: The 6
 * smallest products are: - nums1[0] * nums2[1] = (-4) * 4 = -16 - nums1[0] *
 * nums2[0] = (-4) * 2 = -8 - nums1[1] * nums2[1] = (-2) * 4 = -8 - nums1[1] *
 * nums2[0] = (-2) * 2 = -4 - nums1[2] * nums2[0] = 0 * 2 = 0 - nums1[2] *
 * nums2[1] = 0 * 4 = 0 The 6th smallest product is 0. Example 3:
 * 
 * Input: nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3 Output: -6
 * Explanation: The 3 smallest products are: - nums1[0] * nums2[4] = (-2) * 5 =
 * -10 - nums1[0] * nums2[3] = (-2) * 4 = -8 - nums1[4] * nums2[0] = 2 * (-3) =
 * -6 The 3rd smallest product is -6.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums1.length, nums2.length <= 5 * 104 -105 <= nums1[i], nums2[j] <= 105
 * 1 <= k <= nums1.length * nums2.length nums1 and nums2 are sorted.
 */