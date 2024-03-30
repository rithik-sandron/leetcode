public class _11MaxWaterContainer {
    public static int maxArea_efficient(int[] height) {
        int min = 0, max = 0, ptr1 = 0, ptr2 = height.length - 1;
        while (ptr1 < ptr2) {
            if (height[ptr1] <= min) {
                ptr1++;
                continue;
            }
            if (height[ptr2] <= min) {
                ptr2--;
                continue;
            }
            min = Math.min(height[ptr1], height[ptr2]);
            max = Math.max(max, (ptr2 - ptr1) * min);
        }
        return max;
    }

    public static int maxArea(int[] height) {
        Integer[][] mem = new Integer[height.length][height.length];
        int max = 0, ptr1 = 0;
        while (ptr1 < height.length) {
            int ptr2 = height.length - 1;
            while (ptr2 > -1 && ptr2 != ptr1) {
                if (mem[ptr1][ptr2] != null) {
                    ptr2--;
                    continue;
                }
                int l = ptr1 < ptr2 ? ptr2 - ptr1 : ptr1 - ptr2;
                int h = Math.min(height[ptr1], height[ptr1]);
                mem[ptr1][ptr2] = l * h;
                mem[ptr2][ptr1] = mem[ptr1][ptr2];
                if (max < mem[ptr1][ptr2])
                    max = mem[ptr1][ptr2];
                ptr2--;
            }
            ptr1++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea_efficient(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        System.out.println(maxArea_efficient(new int[] { 2, 3, 4, 5, 18, 17, 6 }));
    }
}
