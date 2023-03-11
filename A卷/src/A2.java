
public class A2 {
    public static void main(String[] args) {
        String s = "AmanaplanacanalPanama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String str) {
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == sb.charAt(i)) {
                count++;
            }
        }
        if (count == str.length()) {
            return true;
        } else {
            return false;
        }
    }


}
