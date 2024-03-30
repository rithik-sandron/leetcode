public class _7IntegerReverse {
    public static int reverse(int x) {
        if (x == 0)
            return x;
        long res = 0;
        while (x != 0) {
            int r = x % 10;
            res = res * 10 + r;
            x /= 10;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE)
            return 0;
        return x < 0 ? (int) -res : (int) res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(-321));
    }
}
