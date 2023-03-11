/**
 * 二分查找法：查找数组中指定元素的下标
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,7,9,10};
        int index = search(nums, 8);
        System.out.println(index);
    }

    /**
     *
     * @param nums 一个升序数组
     * @param target 查找的元素
     * @return 该元素对应的下标
     */
    public static int search(int[] nums, int target) {
        // 因为是升序数组，避免查找的元素大于数组中最小的元素和最大的元素
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        //第一次查找，定义头下标和尾下标（也就行查找的左右区间）
        int left = 0, right = nums.length - 1;
        //只要还存在正确的区间，就一直查找下去
        while (left <= right) {
            //mid: 该区间的中间下标
            int mid = left + ((right - left) >> 1);
            //如果查找的值等于该下标对应值，就直接返回该下标
            if (nums[mid] == target)
                return mid;
            //如果查找的值大于区间中间值，则下次查找丢掉中间值左边的元素
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                //如果查找的值小于区间中间值，则下次查找丢掉中间值右边的元素
                right = mid - 1;
        }
        return -1;
    }
}
