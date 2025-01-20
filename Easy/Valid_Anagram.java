public class Valid_Anagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false; // not anagram
            }
        }

        return true; // anagram
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));

        s = "rat";
        t = "car";
        System.out.println(isAnagram(s, t));
    }
}
