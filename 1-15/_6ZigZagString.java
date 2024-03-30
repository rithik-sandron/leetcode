public class _6ZigZagString {
    public static String convert_optimized(String s, int numRows) {
        if (numRows == 1)
            return s;
        int i = 0;
        int j = 0;
        StringBuilder b = new StringBuilder();
        while (j < numRows) {
            int skip = 2 * (numRows - 1);
            i = j;
            while (i < s.length()) {
                b.append(s.charAt(i));
                if (j > 0 && j < numRows - 1 && i + skip - (2 * j) < s.length())
                    b.append(s.charAt(i + skip - (2 * j)));
                i += skip;
            }
            j++;
        }
        return b.toString();
    }

    public static String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows <= 1) {
            return s;
        }

        char[][] c = new char[numRows][s.length() / 2 + 1];
        int i = 0;
        int row = -1, col = 0;
        int pointer = 0, oddPointer = 0;
        int k = numRows - 2;
        boolean isOdd = false;
        while (i < s.length() && row < numRows && col < s.length() / 2 + 1) {
            if (!isOdd && pointer < numRows) {
                c[++row][col] = s.charAt(i++);
                pointer++;
            } else {
                if (oddPointer == k) {
                    pointer = 0;
                    isOdd = false;
                    col++;
                    row = -1;
                    oddPointer = 0;
                } else {
                    oddPointer++;
                    isOdd = true;
                    c[--row][++col] = s.charAt(i++);
                    pointer--;
                }
            }
        }
        StringBuilder b = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            b.append(c[r]);
        }
        return b.toString().replace("\u0000", "");
    }

    public static void main(String[] args) {
        String s = convert_optimized("PAYPALISHIRING", 3);
        System.out.println(s);
    }
}
