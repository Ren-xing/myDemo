import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class main {
    public static void main(String[] args) {
        Object o = new Object();
        //强引用
        String s = new String();
        //弱引用
        WeakReference<Object> wr = new WeakReference<>(o);
        System.out.println(wr.get());
        System.out.println(wr.isEnqueued());
        System.gc();
        System.out.println(wr.get());
        //软引用
        SoftReference<String> sr = new SoftReference<>("123");
        System.out.println("软引用，内存不足时会被回收：" + sr.get());
        String str = new String("123");
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<String> prf = new PhantomReference<String>(str, referenceQueue);
    }
}
