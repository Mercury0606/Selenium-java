package Java.CoreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp03 {
    public static void main(String[] args) {
//        String is an object
        String s="56789";
        String s1="tyublhnj";
        String s2="tyublhnj";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String s01="Merc is Handsome as H";
        String[] split = s01.split(" ");
        for (int i = 0; i < split.length; i++) {
            System.out.print(split[i] + " ");
        }
        System.out.println();
        System.out.println(split[1].trim());
        for (int i = 0; i < split.length; i++) {
            System.out.print(s.charAt(i));
        }
        System.out.println();
//        Print the String reversely
        for (int i = s01.length()-1; i >=0; i--) {
            System.out.print(s01.charAt(i)+" ");
        }

    }
}
