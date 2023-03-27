package swj;

public class ExtendsDemo {
    public static void main(String[] args) {
        // 目标：认识继承后子类构造器的特点
        // 特点：子类的全部构造器默认会先访问父类的无参数构造器再执行自己
        Dog d1 = new Dog();
        System.out.println(d1);

        System.out.println("-----");

        Dog d2 = new Dog("金毛");
        System.out.println(d2);
    }
}

class Animal {
    public Animal(){
        System.out.println("父类Animal无参数构造器被执行~");
    }
}

class Dog extends Animal{
    public Dog(){
        super(); // 写不写都有，默认找父类的无参数构造器执行
        System.out.println("子类Dog无参数构造器被执行~");
    }
    public Dog(String name){
        super(); // 写不写都有，默认找父类的无参数构造器执行
        System.out.println("子类Dog有参数构造器被执行~");
    }
}
