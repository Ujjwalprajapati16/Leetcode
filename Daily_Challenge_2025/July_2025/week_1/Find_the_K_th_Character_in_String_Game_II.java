public class Find_the_K_th_Character_in_String_Game_II {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        long len[] = new long[n + 1];
        len[0] = 1;

        int idx = 0;
        for (int i = 1; i <= n; i++) {
            len[i] = len[i - 1] * 2;
            idx = i;
            if (len[i] > k) {
                break;
            }
        }

        int shift = 0;
        for (int i = idx; i >= 0; i--) {
            if (k > len[i]) {
                k = k - len[i];
                if (operations[i] == 1) {
                    shift += 1;
                }
            }

            if (k == 1) {
                break;
            }
        }

        return (char) ((shift % 26) + 'a');
    }

    public static void main(String[] args) {
        Find_the_K_th_Character_in_String_Game_II solution = new Find_the_K_th_Character_in_String_Game_II();
        System.out.println(solution.kthCharacter(5, new int[] { 0, 0, 0 })); // Output: "a"
        System.out.println(solution.kthCharacter(10, new int[] { 0, 1, 0, 1 })); // Output: "b"
        System.out.println(solution.kthCharacter(1, new int[] { 1 })); // Output: "a"
    }
}

/*
 * 3307. Find the K-th Character in String Game II Solved Hard Topics premium
 * lock icon Companies Hint Alice and Bob are playing a game. Initially, Alice
 * has a string word = "a".
 * 
 * You are given a positive integer k. You are also given an integer array
 * operations, where operations[i] represents the type of the ith operation.
 * 
 * Now Bob will ask Alice to perform all operations in sequence:
 * 
 * If operations[i] == 0, append a copy of word to itself. If operations[i] ==
 * 1, generate a new string by changing each character in word to its next
 * character in the English alphabet, and append it to the original word. For
 * example, performing the operation on "c" generates "cd" and performing the
 * operation on "zb" generates "zbac". Return the value of the kth character in
 * word after performing all the operations.
 * 
 * Note that the character 'z' can be changed to 'a' in the second type of
 * operation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: k = 5, operations = [0,0,0]
 * 
 * Output: "a"
 * 
 * Explanation:
 * 
 * Initially, word == "a". Alice performs the three operations as follows:
 * 
 * Appends "a" to "a", word becomes "aa". Appends "aa" to "aa", word becomes
 * "aaaa". Appends "aaaa" to "aaaa", word becomes "aaaaaaaa". Example 2:
 * 
 * Input: k = 10, operations = [0,1,0,1]
 * 
 * Output: "b"
 * 
 * Explanation:
 * 
 * Initially, word == "a". Alice performs the four operations as follows:
 * 
 * Appends "a" to "a", word becomes "aa". Appends "bb" to "aa", word becomes
 * "aabb". Appends "aabb" to "aabb", word becomes "aabbaabb". Appends "bbccbbcc"
 * to "aabbaabb", word becomes "aabbaabbbbccbbcc".
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= 1014 1 <= operations.length <= 100 operations[i] is either 0 or 1.
 * The input is generated such that word has at least k characters after all
 * operations.
 */