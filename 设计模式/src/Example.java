import java.util.concurrent.Callable;

public class Example{
    static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (flag){
            }
            System.out.println("这个线程执行完成。");
        }).start();

        Thread.sleep(10);
        new Thread(()->{
            flag=false;
            System.out.println("修改了这个直"+flag);
        }).start();
    }
}
