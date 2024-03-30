public class _10RegularExpression {
    static Boolean[][] mem;

    public static boolean isMatch(String s, String p, int s_i, int p_i) {
        if (p_i == p.length())
            return s_i == s.length();
        if (mem[s_i][p_i] != null)
            return mem[s_i][p_i];
        boolean charMatch = s_i < s.length() && (p.charAt(p_i) == s.charAt(s_i) || p.charAt(p_i) == '.');
        if (p_i + 1 < p.length() && p.charAt(p_i + 1) == '*')
            return mem[s_i][p_i] = isMatch(s, p, s_i, p_i + 2) || (charMatch && isMatch(s, p, s_i + 1, p_i));
        else
            return mem[s_i][p_i] = charMatch && isMatch(s, p, s_i + 1, p_i + 1);
    }

    public static boolean isMatch(String s, String p) {
        mem = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("aabc", "a*abc"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(isMatch("aaab", ".*"));
        byte[][] mem = new byte[2][2];
        System.out.println(mem[0][0]);
    }
}
