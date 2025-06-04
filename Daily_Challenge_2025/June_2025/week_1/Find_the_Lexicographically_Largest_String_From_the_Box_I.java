public class Find_the_Lexicographically_Largest_String_From_the_Box_I {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }

        String res = "";
        int maxLength = word.length() - numFriends + 1;
        for (int i = 0; i < word.length(); i++) {
            String curr = word.substring(i, Math.min(word.length(), i + maxLength));
            if (curr.compareTo(res) > 0) {
                res = curr;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Find_the_Lexicographically_Largest_String_From_the_Box_I solution = new Find_the_Lexicographically_Largest_String_From_the_Box_I();
        System.out.println(solution.answerString("dbca", 2)); // Output: "dbc"
        System.out.println(solution.answerString("gggg", 4)); // Output: "g"
        System.out.println(solution.answerString("abcde", 3)); // Output: "e"
    }
}

/*
 * 3403. Find the Lexicographically Largest String From the Box I Solved Medium
 * Topics premium lock icon Companies Hint You are given a string word, and an
 * integer numFriends.
 * 
 * Alice is organizing a game for her numFriends friends. There are multiple
 * rounds in the game, where in each round:
 * 
 * word is split into numFriends non-empty strings, such that no previous round
 * has had the exact same split. All the split words are put into a box. Find
 * the lexicographically largest string from the box after all the rounds are
 * finished.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: word = "dbca", numFriends = 2
 * 
 * Output: "dbc"
 * 
 * Explanation:
 * 
 * All possible splits are:
 * 
 * "d" and "bca". "db" and "ca". "dbc" and "a". Example 2:
 * 
 * Input: word = "gggg", numFriends = 4
 * 
 * Output: "g"
 * 
 * Explanation:
 * 
 * The only possible split is: "g", "g", "g", and "g".
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= word.length <= 5 * 103 word consists only of lowercase English letters.
 * 1 <= numFriends <= word.length
 */