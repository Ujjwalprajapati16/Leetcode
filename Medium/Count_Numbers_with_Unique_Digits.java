public class Count_Numbers_with_Unique_Digits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        }

        int total = 10;
        int product = 9;
        int available = 9;

        for (int i = 2; i <= n; i++) {
            product *= available;
            total += product;
            available--;
        }

        return total;
    }

    public static void main(String[] args) {
        Count_Numbers_with_Unique_Digits obj = new Count_Numbers_with_Unique_Digits();

        System.out.println(obj.countNumbersWithUniqueDigits(2));
        System.out.println(obj.countNumbersWithUniqueDigits(0));
        System.out.println(obj.countNumbersWithUniqueDigits(1));
    }
}

/*
 * 357. Count Numbers with Unique Digits Medium Topics Companies Hint Given an
 * integer n, return the count of all numbers with unique digits, x, where 0 <=
 * x < 10n.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2 Output: 91 Explanation: The answer should be the total numbers
 * in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99 Example 2:
 * 
 * Input: n = 0 Output: 1
 * 
 * 
 * Constraints:
 * 
 * 0 <= n <= 8
 */