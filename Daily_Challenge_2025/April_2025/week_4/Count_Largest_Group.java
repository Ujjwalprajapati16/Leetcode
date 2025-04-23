public class Count_Largest_Group {
    public int countLargestGroup(int n) {
        int[] hash = new int[40];
        int max = 0;
        for(int i=1; i<=n; i++){
            int ds = digitSum(i);
            hash[ds]++;
            if(hash[ds] > max){
                max = hash[ds];
            }
        }
        int ans = 0;
        for(int i=0; i<40; i++){
            if(hash[i] == max){
                ans++;
            }
        }

        return ans;
    }

    private int digitSum(int n){
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Count_Largest_Group obj = new Count_Largest_Group();
        int n = 13;
        System.out.println(obj.countLargestGroup(n)); // Output: 4

        n = 2;
        System.out.println(obj.countLargestGroup(n)); // Output: 2
    }
}

/*1399. Count Largest Group
Solved
Easy
Topics
Companies
Hint
You are given an integer n.

Each number from 1 to n is grouped according to the sum of its digits.

Return the number of groups that have the largest size.

 

Example 1:

Input: n = 13
Output: 4
Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
[1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
There are 4 groups with largest size.
Example 2:

Input: n = 2
Output: 2
Explanation: There are 2 groups [1], [2] of size 1.
 

Constraints:

1 <= n <= 104 */