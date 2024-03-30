import java.util.Arrays;

public class _4MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays_efficient(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n)
            return findMedianSortedArrays_efficient(nums2, nums1);
        int start = 0;
        int end = m;
        while (start <= end) {
            int partitionX = (start + end) / 2;
            int partitionY = ((m + n + 1) / 2) - partitionX;
            int maxl_X = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minr_X = partitionX == m ? Integer.MAX_VALUE : nums1[partitionX];
            int maxl_Y = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minr_Y = partitionY == n ? Integer.MAX_VALUE : nums2[partitionY];
            if (maxl_X <= minr_Y && maxl_Y <= minr_X) {
                if ((m + n) % 2 == 0)
                    return (Math.max(maxl_X, maxl_Y) + Math.min(minr_X, minr_Y)) / 2.0;
                else
                    return Math.max(maxl_X, maxl_Y);
            } else if (maxl_X > minr_Y)
                end = partitionX - 1;
            else
                start = partitionX + 1;
        }
        return 1.0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] r = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums2.length; i++)
            Arrays.binarySearch(nums1, nums2[i]);
        System.arraycopy(nums1, 0, r, 0, nums1.length);
        System.arraycopy(nums2, 0, r, nums1.length, nums2.length);
        Arrays.sort(r);
        if (r.length % 2 == 0)
            return (r[r.length / 2 - 1] + r[r.length / 2]) / 2.0;
        else
            return r[r.length / 2];
    }

    public static void main(String[] args) {
        double r = findMedianSortedArrays_efficient(new int[] { 1, 2 }, new int[] { 3, 4 });
        System.out.println(r);
    }
}
