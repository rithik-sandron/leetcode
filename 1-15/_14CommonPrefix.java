public class _14CommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        StringBuilder b = new StringBuilder();
        int i = 0, j = 0;
        outer: while (true) {
            if (j >= strs[0].length())
                break outer;
            while (i < strs.length) {
                if (j == strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j))
                    break outer;
                i++;
            }
            i = 0;
            b.append(strs[0].charAt(j));
            j++;
        }
        return b.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] { "flower", "flow",
                "flight" }));
        System.out.println(longestCommonPrefix(new String[] { "dog", "racecar", "car"
        }));
        System.out.println(longestCommonPrefix(new String[] { "" }));
        System.out.println(longestCommonPrefix(new String[] { "a" }));
        System.out.println(longestCommonPrefix(new String[] { "ab", "a" }));
    }

}
