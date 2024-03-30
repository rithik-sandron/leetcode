public class _12IntToRoman {
    public static String intToRoman_efficient(int num) {
        final int[] VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        final String[] SYMBOLS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder b = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (VALUES[i] <= num) {
                b.append(SYMBOLS[i]);
                num -= VALUES[i];
                continue;
            }
            i++;
        }
        return b.toString();
    }

    public static String intToRoman(int num) {
        StringBuilder b = new StringBuilder();
        int digits = (int) (Math.log10(num));
        while (num > 0) {
            int n = (int) (num / (int) Math.pow(10, digits));
            switch (digits + 1) {
                case 4 -> b.append("M".repeat(n));
                case 3 -> {
                    if (n == 9)
                        b.append("CM");
                    else if (n == 4)
                        b.append("CD");
                    else if (n < 4)
                        b.append("C".repeat(n));
                    else if (n == 5)
                        b.append("D");
                    else if (n > 5 && n < 9) {
                        b.append("D");
                        b.append("C".repeat(n - 5));
                    }
                }
                case 2 -> {
                    if (n == 9)
                        b.append("XC");
                    else if (n == 4)
                        b.append("XL");
                    else if (n < 4)
                        b.append("X".repeat(n));
                    else if (n == 5)
                        b.append("L");
                    else if (n > 5 && n < 9) {
                        b.append("L");
                        b.append("X".repeat(n - 5));
                    }
                }
                case 1 -> {
                    if (n == 9)
                        b.append("IX");
                    else if (n == 4)
                        b.append("IV");
                    else if (n < 4)
                        b.append("I".repeat(n));
                    else if (n == 5)
                        b.append("V");
                    else if (n > 5 && n < 9) {
                        b.append("V");
                        b.append("I".repeat(n - 5));
                    }
                }
            }
            num = num - n * (int) (Math.pow(10, digits));
            digits -= 1;
        }
        return b.toString();
    }

    public static void main(String[] args) {
        // System.out.println(intToRoman_efficient(123));
        // System.out.println(intToRoman_efficient(3));
        // System.out.println(intToRoman_efficient(58));
        System.out.println(intToRoman_efficient(1994));
    }
}
