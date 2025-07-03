public class Find_the_K_th_Character_in_String_Game_I {
    public char kthCharacter(int k) {
        int len = 1;
        while(len < k){
            len = len * 2;
        }

        int shift = 0;
        while(len > 1){
            len = len / 2;
            if(len < k){
                k = k - len;
                shift = shift + 1;
            }
        }

        return (char)((shift % 26) + 'a');
    }

    public static void main(String[] args) {
        Find_the_K_th_Character_in_String_Game_I solution = new Find_the_K_th_Character_in_String_Game_I();
        System.out.println(solution.kthCharacter(5)); // Output: "b"
        System.out.println(solution.kthCharacter(10)); // Output: "c"
        System.out.println(solution.kthCharacter(1)); // Output: "a"
        System.out.println(solution.kthCharacter(26)); // Output: "z"
    }
}

/*3304. Find the K-th Character in String Game I
Solved
Easy
Topics
premium lock icon
Companies
Hint
Alice and Bob are playing a game. Initially, Alice has a string word = "a".

You are given a positive integer k.

Now Bob will ask Alice to perform the following operation forever:

Generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word.
For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".

Return the value of the kth character in word, after enough operations have been done for word to have at least k characters.

Note that the character 'z' can be changed to 'a' in the operation.

 

Example 1:

Input: k = 5

Output: "b"

Explanation:

Initially, word = "a". We need to do the operation three times:

Generated string is "b", word becomes "ab".
Generated string is "bc", word becomes "abbc".
Generated string is "bccd", word becomes "abbcbccd".
Example 2:

Input: k = 10

Output: "c"

 

Constraints:

1 <= k <= 500 */