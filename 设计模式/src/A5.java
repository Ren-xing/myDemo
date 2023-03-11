import java.util.Scanner;

public class A5 {
    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    public static int fib(int N){
        if (N < 2) return 0;
        return fib(N - 1) + fib(N - 2);
    }
}
