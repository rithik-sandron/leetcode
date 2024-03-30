import java.util.HashSet;
import java.util.Set;
class _3LongestSubstring {
    public static int lengthOfLongestSubstring_efficient(String s) {
        int[] cache = new int[Byte.MAX_VALUE + 1];
        int max = 0, start = 0;
        char[] seq = s.toCharArray();
        for (int i = 0; i < seq.length; i++) {
            start = Math.max(cache[seq[i]], start);
            max = Math.max(max, i - start + 1);
            cache[seq[i]] = i + 1;
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> sc = new HashSet<>();
        int out = 0, remove = 0;
        for (int i = 0; i < s.length(); i++) {
            while (sc.contains(s.charAt(i))) {
                sc.remove(s.charAt(remove++));
            }
            sc.add(s.charAt(i));
            if (out < i - remove + 1) {
                out = i - remove + 1;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_efficient("aaabbac"));
    }
}