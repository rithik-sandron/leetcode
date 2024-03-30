import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int i = 0;
        Map<Integer, Integer> m = new HashMap<>();
        while (i < nums.length) {
            int r = target - nums[i];
            Integer q = m.get(r);
            if (q != null)
                return new int[] { q, i };
            m.put(nums[i], i);
        i++;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] { 4, 3, 3 }, 6)));
    }

}