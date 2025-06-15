public class Max_Difference_You_Can_Get_From_Changing_an_Integer {
    public int maxDiff(int num) {
 

      String original = Integer.toString(num);
        String maxStr = original;

        for (int i = 0; i < maxStr.length(); i++) {
            if (maxStr.charAt(i) != '9') {
                maxStr = maxStr.replace(maxStr.charAt(i), '9');
                break;
            }
        }

        String minStr = original;
        char firstChar = minStr.charAt(0);
        if (firstChar != '1') {
            minStr = minStr.replace(firstChar, '1');
        } else {
            for (int i = 1; i < minStr.length(); i++) {
                if (minStr.charAt(i) != '0' && minStr.charAt(i) != '1') {
                    minStr = minStr.replace(minStr.charAt(i), '0');
                    break;
                }
            }
        }

        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }

    public static void main(String[] args) {
        Max_Difference_You_Can_Get_From_Changing_an_Integer solution = new Max_Difference_You_Can_Get_From_Changing_an_Integer();
        System.out.println(solution.maxDiff(555)); // Output: 888
        System.out.println(solution.maxDiff(9));   // Output: 8
    }
}

/*
 * 1432. Max Difference You Can Get From Changing an Integer Solved Medium
 * Topics premium lock icon Companies Hint You are given an integer num. You
 * will apply the following steps to num two separate times:
 * 
 * Pick a digit x (0 <= x <= 9). Pick another digit y (0 <= y <= 9). Note y can
 * be equal to x. Replace all the occurrences of x in the decimal representation
 * of num by y. Let a and b be the two results from applying the operation to
 * num independently.
 * 
 * Return the max difference between a and b.
 * 
 * Note that neither a nor b may have any leading zeros, and must not be 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = 555 Output: 888 Explanation: The first time pick x = 5 and y = 9
 * and store the new integer in a. The second time pick x = 5 and y = 1 and
 * store the new integer in b. We have now a = 999 and b = 111 and max
 * difference = 888 Example 2:
 * 
 * Input: num = 9 Output: 8 Explanation: The first time pick x = 9 and y = 9 and
 * store the new integer in a. The second time pick x = 9 and y = 1 and store
 * the new integer in b. We have now a = 9 and b = 1 and max difference = 8
 * 
 * 
 * Constraints:
 * 
 * 1 <= num <= 108
 */