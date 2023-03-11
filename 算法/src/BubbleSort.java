import sun.plugin.javascript.navig.ImageArray;

import javax.swing.*;
import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    static final String ASC = "ASC";
    static final String DESC = "DESC";

    public static void main(String[] args) throws Exception {
        int[] nums = {-1, 5, 0, -6, 9, 3, -5};
        int[] sort = sort(nums, ASC);
        for (int a : sort) {
            System.out.print(a + " ");
        }
    }

    private static int[] sort(int[] sourceArray, String mode) throws Exception {

        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if (mode == ASC) {
            for (int i = 1; i < arr.length; i++) {
                // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
                boolean flag = true;
                for (int j = 0; j < arr.length - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                        flag = false;
                    }
                }
                if (flag) {
                    break;
                }
            }
        } else if (mode == DESC) {
            for (int i = 1; i < arr.length; i++) {
                // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
                boolean flag = true;
                for (int j = 0; j < arr.length - i; j++) {
                    if (arr[j] < arr[j + 1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                        flag = false;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        return arr;
    }
}
