import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;

public class main {
    public static void main(String[] args) {
        ArrayList nums = new ArrayList();
        nums.add(8);
        nums.add(-3);
        nums.add(2);
        nums.add(9);
        nums.add(-2);
        System.out.println("初始顺序：" + nums);
        Collections.sort(nums);
        System.out.println("大小排序：" + nums);
        Collections.shuffle(nums);
        System.out.println("乱序：" + nums);
    }
}
