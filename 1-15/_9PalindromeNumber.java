public class _9PalindromeNumber {
    public static boolean isPalindrome(int x) {
        int copy = x;
        int reversed = x;
        while (copy != 0) {
            reversed = reversed * 10 + (copy % 10);
            copy /= 10;
        }
        if(x<0) reversed = -reversed;
        return reversed == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
