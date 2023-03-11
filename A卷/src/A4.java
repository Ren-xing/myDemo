import java.util.Scanner;

public class A4 {
//    编写一个截取字符串的函数,输入为一个字符串和字节数,
//    输出为按字节截取的字符串,但要保证汉字不被截取半个,
//    如"我ABC", 4,应该截取"我AB",输入"我ABC汉DEF", 6,
//    应该输出"我ABC",而不是"我ABC+汉的半个"。
//    知识点: String中常用的方法
//            gbk中一个汉字两个字节


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = scanner.next(); //我ABC汉DEF

        System.out.println("请输入要截取的长度");
        int length = scanner.nextInt();

        byte[] bytes = s.getBytes();
        String byteString = getByteString(bytes, length);

        System.out.println(byteString);
    }

    public static String getByteString(byte[] bytes,int length){

        int num = 0;
        for (int i = length -1; i > 0; i--) {
            if (bytes[i] < 0){
                num ++;
            }else {
                break;
            }
        }
        if (num % 2 == 0){
            return new String(bytes,0,length);
        }else {
            return new String(bytes,0,length - 1);
        }
    }
}
