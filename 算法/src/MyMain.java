public class MyMain {
    private int a1 = 0;

    public static void main(String[] args) {
        int b1 = 5;
        MyMain myMain = new MyMain();
        myMain.a1 = 8;
        myMain.method(b1, myMain);
        System.out.println(b1 + "  " + myMain.a1);
    }

    private void method(int b1, MyMain myMain) {
        myMain.a1 = 9;
        this.a1 = ++b1;
        b1++;
    }
}
