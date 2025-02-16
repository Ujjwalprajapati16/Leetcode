public class Construct_the_Lexicographically_Largest_Valid_Sequence {
    public boolean backtrack(int index, boolean used[], int seq[], int n) {
        while (index < seq.length && seq[index] != 0) {
            index++;
        }
        if (index == seq.length) {
            return true;
        }

        for (int i = n; i >= 1; i--) {
            if (used[i]) {
                continue;
            }
            if (i == 1) {
                seq[index] = i;
                used[i] = true;
                if (backtrack(index + 1, used, seq, n)) {
                    return true;
                }

                seq[index] = 0;
                used[i] = false;
            } else if (index + i < seq.length && seq[index + i] == 0) {
                seq[index] = i;
                seq[index + i] = i;
                used[i] = true;

                if (backtrack(index + 1, used, seq, n)) {
                    return true;
                }

                seq[index] = 0;
                seq[index + i] = 0;
                used[i] = false;
            }
        }

        return false;
    }

    public int[] constructDistancedSequence(int n) {
        boolean used[] = new boolean[n + 1];
        int seq[] = new int[2 * n - 1];
        backtrack(0, used, seq, n);
        return seq;
    }

    public static void main(String[] args) {
        Construct_the_Lexicographically_Largest_Valid_Sequence obj = new Construct_the_Lexicographically_Largest_Valid_Sequence();
        int n = 3;
        int res[] = obj.constructDistancedSequence(n);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

        n = 5;
        res = obj.constructDistancedSequence(n);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

        n = 7;
        res = obj.constructDistancedSequence(n);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}

/*
 * 1718. Construct the Lexicographically Largest Valid Sequence Solved Medium
 * Topics Companies Hint Given an integer n, find a sequence that satisfies all
 * of the following:
 * 
 * The integer 1 occurs once in the sequence. Each integer between 2 and n
 * occurs twice in the sequence. For every integer i between 2 and n, the
 * distance between the two occurrences of i is exactly i. The distance between
 * two numbers on the sequence, a[i] and a[j], is the absolute difference of
 * their indices, |j - i|.
 * 
 * Return the lexicographically largest sequence. It is guaranteed that under
 * the given constraints, there is always a solution.
 * 
 * A sequence a is lexicographically larger than a sequence b (of the same
 * length) if in the first position where a and b differ, sequence a has a
 * number greater than the corresponding number in b. For example, [0,1,9,0] is
 * lexicographically larger than [0,1,5,6] because the first position they
 * differ is at the third number, and 9 is greater than 5.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3 Output: [3,1,2,3,2] Explanation: [2,3,2,1,3] is also a valid
 * sequence, but [3,1,2,3,2] is the lexicographically largest valid sequence.
 * Example 2:
 * 
 * Input: n = 5 Output: [5,3,1,4,3,5,2,4,2]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 20
 */