import java.util.HashSet;
import java.util.Scanner;

public class SensitiveWordFilter {

    private static HashSet<String> sensitiveWords = new HashSet<>(); //存储敏感词的集合

    static {
        //初始化敏感词库，可以从文件或数据库中读取
        sensitiveWords.add("色情");
        sensitiveWords.add("暴力");
        sensitiveWords.add("政治");
        //...
    }

    public static String filter(String text) {
        //过滤文本中的敏感词，替换为*
        StringBuilder sb = new StringBuilder(text); //用StringBuilder来修改文本
        for (String word : sensitiveWords) { //遍历敏感词集合
            int index = sb.indexOf(word); //查找文本中是否包含该敏感词
            while (index != -1) { //如果找到了
                for (int i = 0; i < word.length(); i++) { //将该敏感词替换为*
                    sb.setCharAt(index + i, '*');
                }
                index = sb.indexOf(word, index + 1); //继续查找下一个匹配位置
            }
        }
        return sb.toString(); //返回过滤后的文本
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要过滤的文本：");
        String text = sc.nextLine();
        System.out.println("过滤后的文本为：");
        System.out.println(filter(text));
    }
}