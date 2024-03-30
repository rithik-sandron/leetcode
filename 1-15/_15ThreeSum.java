import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _15ThreeSum {
    public static List<List<Integer>> threeSum_efficient(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (k != j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                if (nums[j] + nums[k] + nums[i] == 0) {
                    l.add(List.of(nums[i], nums[j], nums[k]));
                }
                if (nums[j] + nums[k] > -nums[i])
                    k--;
                else
                    j++;
            }
            i++;
        }
        return l;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int j = 0;
            while (j != i && j < nums.length) {
                int r = nums[i] + nums[j];
                int k = 0;
                while (k != i && k != j && k < nums.length) {
                    if (r + nums[k] == 0) {
                        List<Integer> x = new ArrayList<>();
                        x.add(nums[i]);
                        x.add(nums[j]);
                        x.add(nums[k]);
                        Collections.sort(x);
                        if (!l.contains(x))
                            l.add(x);
                    }
                    k++;
                }
                j++;
            }
            i++;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(threeSum_efficient(new int[] { -1, 0, 1, 2, -1, -4 }));
        System.out.println(threeSum_efficient(new int[] { 0, 0, 0, 0 }));
        System.out.println(threeSum_efficient(new int[] { -1, 0, 1, 0 }));
        System.out.println(threeSum_efficient(new int[] { -2, 0, 1, 1, 2 }));
        System.out.println(threeSum_efficient(new int[] { 1, 2, -2, -1 }));
        System.out.println(threeSum_efficient(new int[] { 0, 0, 0 }));
        System.out.println(threeSum_efficient(new int[] { 3, 0, -2, -1, 1, 2 }));
    }

}