import java.util.Scanner;

public class A3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }


    public static int lengthOfLongestSubstring(String s) {
        int start, end;
        String count = "";
        String str = "";
        for(start=0; start<s.length(); start++){
            for(end=start+1; end<=s.length(); end++){
                str = s.substring(start, end);
                if(end == s.length()){ //判断是否循环完
                    if(count.length() < str.length()){
                        count = str;
                    }
                    break;
                }else{
                    if(str.contains(s.substring(end, end+1))){//判断子字符串
                        if(count.length() < str.length()){
                            count = str;
                        }
                        break;
                    }
                }
            }
        }
        return count.length();
    }
}
