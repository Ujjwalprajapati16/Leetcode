public class Count_Good_Triplets_in_an_Array {
    class FenwickTree {
        int[] tree;
        int size;

        FenwickTree(int size) {
            this.size = size;
            tree = new int[size + 2]; // +2 to avoid index issues
        }

        void update(int index, int delta) {
            index++; // 1-based indexing
            while (index <= size + 1) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        int query(int index) {
            index++; // 1-based indexing
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos2 = new int[n];
        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = pos2[nums1[i]];
        }

        FenwickTree leftTree = new FenwickTree(n);
        FenwickTree rightTree = new FenwickTree(n);

        // Initialize rightTree with frequencies
        for (int i = 2; i < n; i++) {
            rightTree.update(mapped[i], 1);
        }

        long ans = 0;
        leftTree.update(mapped[0], 1);

        for (int i = 1; i < n - 1; i++) {
            int mid = mapped[i];
            int leftLess = leftTree.query(mid - 1);
            int rightGreater = rightTree.query(n - 1) - rightTree.query(mid);
            ans += (long) leftLess * rightGreater;

            leftTree.update(mid, 1);
            if (i + 1 < n) {
                rightTree.update(mapped[i + 1], -1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Count_Good_Triplets_in_an_Array obj = new Count_Good_Triplets_in_an_Array();
        int[] nums1 = { 2, 0, 1, 3 };
        int[] nums2 = { 0, 1, 2, 3 };
        System.out.println(obj.goodTriplets(nums1, nums2)); // Output: 1

        int[] nums1_2 = { 4, 0, 1, 3, 2 };
        int[] nums2_2 = { 4, 1, 0, 2, 3 };
        System.out.println(obj.goodTriplets(nums1_2, nums2_2)); // Output: 4
    }
}

/*
 * 2179. Count Good Triplets in an Array Solved Hard Topics Companies Hint You
 * are given two 0-indexed arrays nums1 and nums2 of length n, both of which are
 * permutations of [0, 1, ..., n - 1].
 * 
 * A good triplet is a set of 3 distinct values which are present in increasing
 * order by position both in nums1 and nums2. In other words, if we consider
 * pos1v as the index of the value v in nums1 and pos2v as the index of the
 * value v in nums2, then a good triplet will be a set (x, y, z) where 0 <= x,
 * y, z <= n - 1, such that pos1x < pos1y < pos1z and pos2x < pos2y < pos2z.
 * 
 * Return the total number of good triplets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [2,0,1,3], nums2 = [0,1,2,3] Output: 1 Explanation: There are
 * 4 triplets (x,y,z) such that pos1x < pos1y < pos1z. They are (2,0,1),
 * (2,0,3), (2,1,3), and (0,1,3). Out of those triplets, only the triplet
 * (0,1,3) satisfies pos2x < pos2y < pos2z. Hence, there is only 1 good triplet.
 * Example 2:
 * 
 * Input: nums1 = [4,0,1,3,2], nums2 = [4,1,0,2,3] Output: 4 Explanation: The 4
 * good triplets are (4,0,3), (4,0,2), (4,1,3), and (4,1,2).
 * 
 * 
 * Constraints:
 * 
 * n == nums1.length == nums2.length 3 <= n <= 105 0 <= nums1[i], nums2[i] <= n
 * - 1 nums1 and nums2 are permutations of [0, 1, ..., n - 1].
 */