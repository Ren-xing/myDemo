public class ArmstrongNumber {
    // 定义一个方法来检查一个数是否是水仙花数
    public static boolean isArmstrong(int num) {
        // 获取数字的位数
        int digits = 0;
        int temp = num;
        while (temp != 0) {
            digits++;
            temp /= 10;
        }
        // 计算数字的每个位上的数字的位数次幂之和
        int sum = 0;
        temp = num;
        while (temp != 0) {
            int lastDigit = temp % 10;
            sum += Math.pow(lastDigit, digits);
            temp /= 10;
        }
        // 判断数字是否等于其每个位上的数字的位数次幂之和
        return sum == num;
    }

    // 定义一个方法来打印100到999之间的所有水仙花数
    public static void printArmstrongNumbers() {
        // 遍历100到999之间的所有数字
        for (int i = 100; i <= 999; i++) {
            // 如果数字是水仙花数，就打印它
            if (isArmstrong(i)) {
                System.out.println(i);
            }
        }
    }

    // 在主方法中调用打印水仙花数的方法
    public static void main(String[] args) {
        printArmstrongNumbers();
    }
}
