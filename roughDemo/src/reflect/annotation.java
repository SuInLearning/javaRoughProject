package reflect;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class annotation {
    @MyTest
    public void test1(){
        System.out.println("===test1===");
    }

    @MyTest
    public void test2(){
        System.out.println("===test2===");
    }

    @MyTest
    public static void test3(){
        System.out.println("===test3===");
    }

    /**
     启动菜单：有注解的才被调用。
     */
    public static void main(String[] args) throws Exception {
        annotation t = new annotation();
        // a.获取类对象
        Class c = annotation.class;
        // b.提取全部方法
        Method[] methods = c.getDeclaredMethods();
        // c.遍历方法，看是否有MyTest注解，有就跑它
        for (Method method : methods) {
            if(method.isAnnotationPresent(MyTest.class)){
                // 跑它
                method.invoke(t);
            }
        }
    }
}

@Target({ElementType.METHOD,ElementType.FIELD}) // 元注解
@Retention(RetentionPolicy.RUNTIME) // 一直活着，在运行阶段这个注解也不消失
@interface MyTest {
}