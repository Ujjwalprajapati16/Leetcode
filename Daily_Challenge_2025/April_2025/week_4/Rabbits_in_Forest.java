public class Rabbits_in_Forest {
    public int numRabbits(int[] answers) {
        int[] hash = new int[1001];
        for (int answer : answers) {
            hash[answer]++;
        }

        int ans = 0;
        for (int i = 0; i < 1001; i++) {
            if (hash[i] == 0) {
                continue;
            }
            ans += Math.ceil((double) hash[i] / (i + 1)) * (i + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Rabbits_in_Forest obj = new Rabbits_in_Forest();
        int[] answers = {1, 1, 2};
        System.out.println(obj.numRabbits(answers)); // Output: 5

        int[] answers2 = {10, 10, 10};
        System.out.println(obj.numRabbits(answers2)); // Output: 11
    }
}

/*781. Rabbits in Forest
Solved
Medium
Topics
Companies
There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.

Given the array answers, return the minimum number of rabbits that could be in the forest.

 

Example 1:

Input: answers = [1,1,2]
Output: 5
Explanation:
The two rabbits that answered "1" could both be the same color, say red.
The rabbit that answered "2" can't be red or the answers would be inconsistent.
Say the rabbit that answered "2" was blue.
Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
Example 2:

Input: answers = [10,10,10]
Output: 11
 

Constraints:

1 <= answers.length <= 1000
0 <= answers[i] < 1000 */