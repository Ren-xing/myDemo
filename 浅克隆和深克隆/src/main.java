public class main {
    public static void main(String[] args) throws CloneNotSupportedException {
        //浅克隆
        Dog dog = new Dog("旺财");
        Person person = new Person(11, "小明", dog);
        Person person1 = person.clone();
        System.out.println("修改前person：" + person);
        System.out.println("修改前person1：" + person1);
        dog.setName("二狗");
        System.out.println("修改后person：" + person);
        System.out.println("修改后person1：" + person1);
        System.out.println(person.getDog() == person1.getDog());

        byte a = 127;
        byte b = 127;
        //b = a + b; // 报编译错误:cannot convert from int to byte
        b = (byte) 254;
        System.out.println(b);
    }
}
