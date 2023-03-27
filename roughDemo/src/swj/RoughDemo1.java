package swj;

import java.util.Objects;

public class RoughDemo1 {
    public static void main(String[] args) {
        c cc = new c(5,"sfafs");
        c c2 = new c(5);
//        System.out.println(c2.getName());
        System.out.println(Objects.equals(cc, c2));
        System.out.println(cc.equals(c2));
        System.out.println(Objects.equals("sfafs", null));
//        int[] arr=new int[3];
//        System.out.println(arr[2]+1);
//
//        for (int i = 0; i < ; i++) {
//
//        }
//        switch (30){
//            case 30:
//                System.out.println("30");
//                break;
//            case 31:
//                System.out.println("30");
//                break;
//
//        }

//        int i = 10, j = 20, k = 30;
//        int max = i > j ? (i > k ? i : k) : (j > k ? j : k);
//        System.out.println(max);

//        byte a1=1,a2=1,a3;
//        a3=a1+a2;   // 报错，在表达式中，**byte、short、char** 是直接转换成int类型参与运算的

//        byte a,a1;
//        a=a1=10;
//        int b=10000000;
//        a+=b;       //隐含了强制类型转换，a1=(byte)(a1+b)
//        System.out.println(a);
//        a1=a1+b;    //报错       a1=(byte)(a1+b)
//        System.out.println(a1);

//        byte a = 10;
//        int a1=3;
//
//        System.out.println(a/a1*1.5);

//        char c = 97;
////        short i = c;  错误，需要强制转换
//        int j = c;


//        int a=10;
//        {
//            float b= 5.5F;
//            System.out.println(a);
//        }
//        System.out.println(a);
    }

    private void run() {
    }
}

class a {
    public a() {
        System.out.println("a的构造器---");
    }
}

class b extends a {
    public b() {
        System.out.println("b的构造器---");
    }
}

class c {
    private int age;
   private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public c(int age) {
        this.age = age;
    }

    public c(int age, String name) {
        this.age = age;
this.name=name;
        System.out.println("c的构造器---");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        c c = (c) o;
        return age == c.age && Objects.equals(name, c.name);
    }

}

