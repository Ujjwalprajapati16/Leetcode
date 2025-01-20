import java.util.HashSet;

public class Contains_duplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true; // duplicate found
            }
            set.add(num); // add the element to the hashset
        }

        return false; // no duplicates found
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        boolean result = containsDuplicate(nums);

        if (result) {
            System.out.println("The array contains duplicates.");
        } else {
            System.out.println("The array does not contain duplicates.");
        }
    }
}
