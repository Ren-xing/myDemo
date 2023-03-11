class FatherClazz implements AInter {
    static {
        System.out.println("父类静态代码块!");
    }

    {
        System.out.println("父类代码块！");
    }

    public FatherClazz() {
        System.out.println("父类构造方法!");
    }
}

public class SonClazz extends FatherClazz {
    /**
     * 类加载：静态代码块是在类加载时执行
     * 给类赋值
     */
    static FatherClazz fatherClazz = new FatherClazz();

    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类代码块");
    }

    public SonClazz() {
        System.out.println("子类构造方法");
    }

    public static void main(String[] args) {
        System.out.println(3*0.3);
    }
}
