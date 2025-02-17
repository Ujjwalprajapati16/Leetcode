public class Letter_Tile_Possibilities {
    public int backtrack(int freq[]) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            count++;
            freq[i]--;
            count += backtrack(freq);
            freq[i]++;
        }
        return count;
    }

    public int numTilePossibilities(String tiles) {
        int len = tiles.length();
        int freq[] = new int[26];
        for (int i = 0; i < len; i++) {
            freq[tiles.charAt(i) - 'A']++;
        }
        int count = backtrack(freq);
        return count;
    }

    public static void main(String[] args) {
        Letter_Tile_Possibilities obj = new Letter_Tile_Possibilities();
        String tiles = "AAB";
        System.out.println(obj.numTilePossibilities(tiles));

        tiles = "AAABBC";
        System.out.println(obj.numTilePossibilities(tiles));

        tiles = "V";
        System.out.println(obj.numTilePossibilities(tiles));
    }
}

/*
 * 1079. Letter Tile Possibilities
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You have n tiles, where each tile has one letter tiles[i] printed on it.
 * 
 * Return the number of possible non-empty sequences of letters you can make
 * using the letters printed on those tiles.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: tiles = "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB",
 * "ABA", "BAA".
 * Example 2:
 * 
 * Input: tiles = "AAABBC"
 * Output: 188
 * Example 3:
 * 
 * Input: tiles = "V"
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 */