package Singleton;

public class SingleObject {

    //创建一个SingleObject的实例
    private static SingleObject singleObject = new SingleObject();

    //把构造器都设为私有，防止外面new一个实例
    private SingleObject() {
    };

    //提供一个全局访问这个实例的方法
    public static SingleObject getSingleObject() {
        return SingleObject.singleObject;
    }
}
