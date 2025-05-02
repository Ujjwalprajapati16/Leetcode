public class Push_Dominoes {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char last = 'L';
        for (char d : dominoes.toCharArray()) {
            if (d == '.') {
                count += 1;
            } else {
                if (d == last) {
                    append(count, last, sb);
                } else if (last == 'L') {
                    append(count, '.', sb);
                } else {
                    append(count / 2, 'R', sb);
                    if (count % 2 != 0) {
                        append(1, '.', sb);
                    }
                    append(count / 2, 'L', sb);
                }
                sb.append(d);
                last = d;
                count = 0;
            }
        }
        append(count, last == 'R' ? 'R' : '.', sb);
        return sb.toString();
    }

    private void append(int count, char last, StringBuilder sb) {
        for (int i = 0; i < count; i++) {
            sb.append(last);
        }
    }

    public static void main(String[] args) {
        Push_Dominoes pd = new Push_Dominoes();
        System.out.println(pd.pushDominoes("RR.L"));

        System.out.println(pd.pushDominoes(".L.R...LR..L.."));
    }
}

/*
 * 838. Push Dominoes Solved Medium Topics Companies There are n dominoes in a
 * line, and we place each domino vertically upright. In the beginning, we
 * simultaneously push some of the dominoes either to the left or to the right.
 * 
 * After each second, each domino that is falling to the left pushes the
 * adjacent domino on the left. Similarly, the dominoes falling to the right
 * push their adjacent dominoes standing on the right.
 * 
 * When a vertical domino has dominoes falling on it from both sides, it stays
 * still due to the balance of the forces.
 * 
 * For the purposes of this question, we will consider that a falling domino
 * expends no additional force to a falling or already fallen domino.
 * 
 * You are given a string dominoes representing the initial state where:
 * 
 * dominoes[i] = 'L', if the ith domino has been pushed to the left, dominoes[i]
 * = 'R', if the ith domino has been pushed to the right, and dominoes[i] = '.',
 * if the ith domino has not been pushed. Return a string representing the final
 * state.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: dominoes = "RR.L" Output: "RR.L" Explanation: The first domino expends
 * no additional force on the second domino.
 * 
 *  Example 2:
 *
 * Input: dominoes = ".L.R...LR..L.." Output: "LL.RR.LLRRLL.."
 * 
 * 
 * Constraints:
 * 
 * n == dominoes.length 1 <= n <= 105 dominoes[i] is either 'L', 'R', or '.'.
 */