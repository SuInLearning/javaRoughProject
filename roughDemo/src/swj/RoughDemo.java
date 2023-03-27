package swj;

import java.util.Scanner;

public class RoughDemo {
    public static void main(String[] args) {
        // 非负数 金额  0.1 1.5 011 111       ！！ 1.1.1  .9  4ds5  1.
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.next();
            System.out.println(str.matches("\\d{1,}([.]\\d{1,}){0,1}"));
        }
    }
}
