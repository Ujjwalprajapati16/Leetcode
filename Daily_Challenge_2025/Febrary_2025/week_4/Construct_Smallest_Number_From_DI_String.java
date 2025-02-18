public class Construct_Smallest_Number_From_DI_String {
    private boolean isValid(int lastDigit, int currentDigit, char condition) {
        return (condition == 'I' && lastDigit < currentDigit) || (condition == 'D' && lastDigit > currentDigit);
    }

    private boolean backtrack(String pattern, int index, int[] num, boolean[] used, StringBuilder result) {
        if (index > pattern.length()) {
            for (int i = 0; i < num.length; i++) {
                result.append(num[i]);
            }
            return true;
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (!used[digit] && (index == 0 || isValid(num[index - 1], digit, pattern.charAt(index - 1)))) {
                used[digit] = true;
                num[index] = digit;
                if (backtrack(pattern, index + 1, num, used, result)) {
                    return true;
                }
                num[index] = 0;
                used[digit] = false;
            }
        }

        return false;
    }

    public String smallestNumber(String pattern) {
        int n = pattern.length();
        boolean[] used = new boolean[10];
        StringBuilder result = new StringBuilder();
        backtrack(pattern, 0, new int[n + 1], used, result);

        return result.toString();
    }

    public static void main(String[] args) {
        Construct_Smallest_Number_From_DI_String obj = new Construct_Smallest_Number_From_DI_String();
        String pattern = "IIIDIDDD";
        System.out.println(obj.smallestNumber(pattern));

        pattern = "DDD";
        System.out.println(obj.smallestNumber(pattern));
    }
}

/*
 * 2375. Construct Smallest Number From DI String Solved Medium Topics Companies
 * Hint You are given a 0-indexed string pattern of length n consisting of the
 * characters 'I' meaning increasing and 'D' meaning decreasing.
 * 
 * A 0-indexed string num of length n + 1 is created using the following
 * conditions:
 * 
 * num consists of the digits '1' to '9', where each digit is used at most once.
 * If pattern[i] == 'I', then num[i] < num[i + 1]. If pattern[i] == 'D', then
 * num[i] > num[i + 1]. Return the lexicographically smallest possible string
 * num that meets the conditions.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: pattern = "IIIDIDDD" Output: "123549876" Explanation: At indices 0, 1,
 * 2, and 4 we must have that num[i] < num[i+1]. At indices 3, 5, 6, and 7 we
 * must have that num[i] > num[i+1]. Some possible values of num are
 * "245639871", "135749862", and "123849765". It can be proven that "123549876"
 * is the smallest possible num that meets the conditions. Note that "123414321"
 * is not possible because the digit '1' is used more than once. Example 2:
 * 
 * Input: pattern = "DDD" Output: "4321" Explanation: Some possible values of
 * num are "9876", "7321", and "8742". It can be proven that "4321" is the
 * smallest possible num that meets the conditions.
 * 
 * 
 * Constraints:
 * 
 * 1 <= pattern.length <= 8 pattern consists of only the letters 'I' and 'D'.
 */