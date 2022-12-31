package Java;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream01 {
    @Test
    public void regular(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Ava");
        names.add("Erin");
        names.add("Allen");
        names.add("Adam");
        names.add("Wally");
        names.add("Merc");
        names.add("Kitty");
        names.add("William");
        int count =0;
        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamFilter(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Ava");
        names.add("Erin");
        names.add("Allen");
        names.add("Adam");
        names.add("Wally");
        names.add("Merc");
        names.add("Kitty");
        names.add("William");
        /**
         * Before using this filter method,
         * we have to convert the existing ArrayList in to stream by using .stream()
         * the filter is going to scan all the names(Collection) parallelly
         */
        /**
         * there is no life for intermediate operation if there is no terminal operation,
         * terminal operation will execute only if intermediate operation(filter) returns true,
         * we can create stream
         * how to use filter in stream API
         */
        long c = names.stream().filter(s -> s.startsWith("A")).count();//lambda
        System.out.println(c);
        long d=Stream.of("Ava","Aerfgvbnm","sdfghjk").filter(s ->
        {
             s.startsWith("A");
             return false; //if return false,this will not work
        }).count();
        System.out.println(d);
        //print all the names of ArrayList
        names.stream().filter(s -> s.length()>4).limit(1).forEach(s -> System.out.println(s));
    }
    @Test
    public void streamMap(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Ann");
        names.add("Millet");

        //print names which have last letter as "A" with Uppercase
        Stream.of("Ava","Erin","Allen","Adam","Wally","Merc","Kitty","William")
                .filter(s -> s.endsWith("a"))
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        //print names which starts with "A" with Uppercase and sorted
        List<String> names01 = Arrays.asList("Ava", "Erin", "Allen", "Adam", "Wally", "Merc", "Kitty", "William");
        names01.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //Merging two lists
        System.out.println(">> Merging two different lists");
        Stream<String> newString = Stream.concat(names.stream(), names01.stream());
        //newString.sorted().forEach(s -> System.out.println(s));
        boolean flag = newString.anyMatch(s -> s.equalsIgnoreCase("Adam"));
        System.out.println(flag);
        Assert.assertTrue(flag);
    }
    @Test
    public void streamCollect(){
        List<String> list = Stream.of("Ava", "Erin", "Allen", "Adam", "Wally", "Merc", "Kitty", "William")
                .filter(s -> s.endsWith("a"))
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(list.get(0));
        List<Integer> integers = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
        //print unique ubmer from this array
        //sort the array
       // integers.stream().distinct().forEach(s -> System.out.println(s));
        List<Integer> sorted = integers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(sorted.get(2));

    }
}

















