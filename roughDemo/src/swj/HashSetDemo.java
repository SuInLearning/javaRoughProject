package swj;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetDemo {
    public static void main(String[] args) {
        String str1="sdafa";
        String str2="sdafa";
        String str3="sdafa3";
//        boolean i=str1.equals("2");
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        Set<Dog> hashSet = new LinkedHashSet<>();
    }
}
