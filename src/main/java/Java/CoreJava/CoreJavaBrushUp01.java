package Java.CoreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp01 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("456789");
        arrayList.add("452");
        arrayList.add("789");
        arrayList.add("09876543");
        arrayList.remove(3);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.println();
        for (Object string:arrayList
             ) {
            System.out.print(string+"  ");
        }
        System.out.println();


        System.out.println(arrayList.contains("789"));
//        Convert Array to ArrayList
        String[] a={"trew","ertyu","ur6d","586fsda"};
        List<String> strings = Arrays.asList(a);
        for (int i = 0; i < strings.size(); i++) {
            System.out.print(strings.get(i)+" ");
        }

    }
}
