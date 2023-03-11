import java.util.*;

public class ArrayDemo {
    public static void main(String[] args) {
        // 对象 1
        ArrayList<String> objects = new ArrayList<>();
        objects.add("悟空");
        objects.add("逐步解决");
        Iterator<String> iterator = objects.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            if (iterator.next().contains("悟")) ;
            iterator.remove();
        }

        objects.forEach(item -> {
            System.out.println(item);
        });

        Persion p1 = new Persion();
        p1.setName("Java");
        p1.setAge(18);
//        System.out.println(p1.hashCode());
        // 对象 2
        Persion p2 = new Persion();
        p2.setName("Java");
        p2.setAge(18);
//        System.out.println(p2.hashCode());
//        System.out.println(p2.equals(p1));

//        HashMap<Object, Object> hashMap = new HashMap<>();
//        hashMap.put(p1,p1);
//        hashMap.put(p2,p2);

        HashSet<Object> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.forEach(s -> {
            System.out.println(s);
        });

//        System.out.println(hashMap.get(p2));
//        System.out.println(hashMap.get(p2));

    }
}

class Persion {
    private String name;
    private int age;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true; // 引用相等返回 true
//        // 如果等于 null，或者对象类型不同返回 false
//        if (o == null || getClass() != o.getClass()) return false;
//        // 强转为自定义 Persion 类型
//        Persion persion = (Persion) o;
//        // 如果 age 和 name 都相等，就返回 true
//        return age == persion.age &&
//                Objects.equals(name, persion.name);
//    }

    @Override
    public int hashCode() {
        // 对比 name 和 age 是否相等
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}