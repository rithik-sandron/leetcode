public class _5LongestPalindromSubString {
    public static String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        int maxL = 0, maxR = 0, maxLength = 0;
        int i = 0;
        while (i < s.length()) {
            int l = i;
            int r = i;
            int le = i;
            int re = i++ + 1;
            boolean p1 = true, p2 = true;
            while (p1 || p2) {
                if (p1 && l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                } else if (p1) {
                    p1 = false;
                    l++;
                    r--;
                }
                if (p2 && le >= 0 && re < s.length() && s.charAt(le) == s.charAt(re)) {
                    le--;
                    re++;
                } else if (p2) {
                    p2 = false;
                    le++;
                    re--;
                }
            }

            if (maxLength < (r - l) + 1) {
                maxLength = (r - l) + 1;
                maxL = l;
                maxR = r;
            }
            if (maxLength < (re - le) + 1) {
                maxLength = (re - le) + 1;
                maxL = le;
                maxR = re;
            }
        }
        return s.substring(maxL, maxR + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("cbbd"));
    }
}