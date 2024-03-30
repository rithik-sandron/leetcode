public class _8Atoi {
    public static int myAtoi(String s) {
        if (s == null)
            return 0;
        s = s.stripLeading();
        if (s.isEmpty())
            return 0;
        int i = 0;
        boolean isNeg = false;
        if (s.charAt(0) == 45 || s.charAt(0) == 43)
            i += 1;
        isNeg = s.charAt(0) == 45;
        double res = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i)))
            res = res * 10 + Character.getNumericValue(s.charAt(i++));
        res = isNeg ? -res : res;
        res = res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res;
        res = res < Integer.MIN_VALUE ? Integer.MIN_VALUE : res;
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("-912"));
        System.out.println(myAtoi("18446744073709551617"));
    }
}
