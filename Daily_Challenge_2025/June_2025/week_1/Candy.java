public class Candy {
    private int sum(int n) {
        return (n * (n + 1)) / 2;
    }

    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }

        int up = 0;
        int down = 0;
        int prevSlope = 0;
        int candies = 0;

        for (int i = 1; i < ratings.length; i++) {
            int currSlope = ratings[i] > ratings[i - 1] ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);

            if ((prevSlope < 0 && currSlope >= 0) || (prevSlope > 0 && currSlope == 0)) {
                candies = candies + sum(up) + sum(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }

            if (currSlope > 0) {
                up++;
            } else if (currSlope < 0) {
                down++;
            } else {
                candies++;
            }

            prevSlope = currSlope;
        }

        candies = candies + sum(up) + sum(down) + Math.max(up, down) + 1;

        return candies;
    }

    public static void main(String[] args) {
        Candy solution = new Candy();
        System.out.println(solution.candy(new int[] { 1, 0, 2 })); // Output: 5
        System.out.println(solution.candy(new int[] { 1, 2, 2 })); // Output: 4
        System.out.println(solution.candy(new int[] { 1, 3, 2, 2, 1 })); // Output: 9
    }
}

/*
 * 135. Candy Solved Hard Topics premium lock icon Companies There are n
 * children standing in a line. Each child is assigned a rating value given in
 * the integer array ratings.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. Return the minimum number of candies you
 * need to have to distribute the candies to the children.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ratings = [1,0,2] Output: 5 Explanation: You can allocate to the
 * first, second and third child with 2, 1, 2 candies respectively. Example 2:
 * 
 * Input: ratings = [1,2,2] Output: 4 Explanation: You can allocate to the
 * first, second and third child with 1, 2, 1 candies respectively. The third
 * child gets 1 candy because it satisfies the above two conditions.
 * 
 * 
 * Constraints:
 * 
 * n == ratings.length 1 <= n <= 2 * 104 0 <= ratings[i] <= 2 * 104
 */