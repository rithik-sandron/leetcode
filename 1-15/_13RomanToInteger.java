import java.util.Map;

public class _13RomanToInteger {
    public static int romanToInt_efficient(String s) {
        int res = 0, i = s.length() - 1;
        int prev = 0;
        while (i > -1) {
            int n = 0;
            switch (s.charAt(i)) {
                case 'I' -> n = 1;
                case 'V' -> n = 5;
                case 'X' -> n = 10;
                case 'L' -> n = 50;
                case 'C' -> n = 100;
                case 'D' -> n = 500;
                case 'M' -> n = 1000;
            }
            res = prev > n ? res - n : res + n;
            prev = n;
            i--;
        }
        return res;
    }

    public static int romanToInt(String s) {
        var singleR = Map.of('M', 1000, 'D', 500, 'C', 100, 'L', 50, 'X', 10, 'V', 5, 'I', 1);
        var doubleR = Map.of("CM", 900, "CD", 400, "XC", 90, "XL", 40, "IX", 9, "IV", 4);
        int res = 0, i = 0;
        while (i < s.length()) {
            if (i + 1 < s.length() && doubleR.containsKey("" + s.charAt(i) + s.charAt(i + 1))) {
                res += doubleR.get(s.substring(i, i + 2));
                i += 2;
            } else if (singleR.containsKey(s.charAt(i))) {
                res += singleR.get(s.charAt(i));
                i += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt_efficient("III"));
        System.out.println(romanToInt_efficient("LVIII"));
        System.out.println(romanToInt_efficient("MCMXCIV"));

    }
}
