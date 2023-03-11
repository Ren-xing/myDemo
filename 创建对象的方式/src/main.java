import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, NoSuchMethodException, InvocationTargetException {
        Person person = new Person(10, "朱元璋");
        System.out.println(person.toString());

        //利用反射机制 class.newInstance()
        Person person1 = Person.class.newInstance();
        System.out.println(person1);

        //利用反射机制 construct.newInstance()
        Class[] classes = {Integer.class, String.class};
        Person construct = Person.class.getConstructor(classes).newInstance(11, "朱标");
        System.out.println(construct);

        Person dConstruct = Person.class.getDeclaredConstructor(classes).newInstance(15, "朱棣");
        System.out.println(dConstruct.toString());

        //利用clone克隆
        Person clone = person.clone();
        System.out.println(clone.toString().equals(person.toString()));

        //利用反序列化
        byte[] serialize = SerializationUtils.serialize(person); //模拟一个序列化的数组

        Object deserialize = SerializationUtils.deserialize(serialize);
        System.out.println(deserialize);
    }
}
