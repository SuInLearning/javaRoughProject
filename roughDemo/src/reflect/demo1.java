package reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class demo1 {
    public static void main(String[] args) throws Exception {
        // 需求：泛型擦除后，反射实现加入其他类型的元素
        ArrayList<String> lists1 = new ArrayList<>();
        ArrayList<Integer> lists2 = new ArrayList<>();
        System.out.println(lists1.getClass());
        System.out.println(lists2.getClass());
        System.out.println(lists1.getClass() == lists2.getClass());  // ArrayList.class

        System.out.println("---------------------------");
        ArrayList<Integer> lists3 = new ArrayList<>();
        lists3.add(23);
        lists3.add(22);
        // lists3.add("黑马");

        Class c = lists3.getClass(); // ArrayList.class  ===> public boolean add(E e)
        // 定位c类中的add方法
        Method add = c.getDeclaredMethod("add", Object.class);
        boolean rs = (boolean) add.invoke(lists2, "黑马");
        System.out.println(rs);
        System.out.println(lists2);
//        System.out.println(lists3);

        ArrayList list4 = lists3;
        list4.add("白马");
        list4.add(false);
        System.out.println(lists3);
    }
}
