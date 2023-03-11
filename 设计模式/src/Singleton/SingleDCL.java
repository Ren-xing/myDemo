package Singleton;

public class SingleDCL {
    private volatile static SingleDCL singleDCL;

    private SingleDCL() {
    }

    public static SingleDCL getSingleDCL() {
        if (singleDCL == null) {
            synchronized (SingleDCL.class) {
                if (singleDCL == null) {
                    singleDCL = new SingleDCL();
                }
            }
        }
        return singleDCL;
    }

}
