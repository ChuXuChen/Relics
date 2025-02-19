/*
 * @Description:
 * 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 */

public class L2022211939_13_Test {
    public static void main(String[] args) {
        // 三种颜色，每种多个
        testSortColors(new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2});
        // 三种颜色，每种一个
        testSortColors(new int[]{2, 0, 1}, new int[]{0, 1, 2});
        // 只有红色
        testSortColors(new int[]{0}, new int[]{0});
        // 只有白色
        testSortColors(new int[]{1}, new int[]{1});
        // 好多颜色
        testSortColors(new int[]{2, 2, 2, 1, 1, 0, 0, 0}, new int[]{0, 0, 0, 1, 1, 2, 2, 2});
    }

    private static void testSortColors(int[] input, int[] expected) {
        Solution solution = new Solution();
        solution.sortColors(input);
        boolean passed = true;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != expected[i]) {
                passed = false;
                break;
            }
        }
        System.out.println("Test " + (passed ? "passed" : "failed"));
    }
}

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }
}
