package com.citic.jdk8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static sun.jvm.hotspot.runtime.PerfMemory.start;

/**
 * Created by gavin on 2018/4/21.
 */
public class Lambda {

    @Test
    public void test1(){
        new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

        new Thread(()->{
                    System.out.println("In Java8, Lambda expression rocks !!");
                    System.out.println("In Java8, Lambda expression rocks !!");
                }).start();

    }

    /*
    // Java 8之前：
    JButton show =  new JButton("Show");
    show.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        System.out.println("Event handling without lambda expression is boring");
        }
    });

    // Java 8方式：
    show.addActionListener((e) -> {
        System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
    });
     */



    @Test
    public void test2(){
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach( n -> System.out.println(n));
        features.forEach( n -> System.out.print("-"));
        features.forEach(System.out :: println);
    }

    private static void filter(List<String> strs, Predicate condition){
        /*for(String str : strs){
            if(condition.test(str)){
                System.out.println(str + " ");
            }
        }*/

        //strs.stream().filter((s1) -> (condition.test(s1))).forEach((s2)->System.out.println(s2 + " "));
        strs.stream().filter(condition).forEach((s2)->System.out.println(s2 + " "));

    }

    @Test
    public void test3(){
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str)->((String)str).startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->((String)str).endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->((String)str).length() > 4);

        Predicate<String> startsWithJ = (s) -> s.startsWith("J");
        Predicate<String> fourLetterLong = (s) -> s.length() == 4;
        languages.stream().filter(startsWithJ.and(fourLetterLong))
                .forEach((s)->System.out.print("Name, which starts with 'J' and four letter long is : " + s));
    }

    /**
     * Java 8中使用lambda表达式的Map和Reduce示例
     */
    @Test
    public void test4(){
        List<Double> costBeforeTax = Arrays.asList(100d, 200d, 300d, 400d, 500d);
        costBeforeTax.stream()
                .map((cost)->cost*1.12)
                .forEach(System.out::println);

        Object bill = costBeforeTax.stream()
                .map((cost) -> cost * 1.12)
                .reduce((sum,cost)-> sum + cost).get();

        System.out.println("Bill :" + bill);
    }

    //通过过滤创建一个String列表
    @Test
    public void test5(){
        List<String> strList = Arrays.asList("Java","C","C++","Python","Perl");
        List<String> filtered = strList.stream().filter((s)->s.length()>2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);

        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map( s -> s.toUpperCase() ).collect(Collectors.joining(","));
        System.out.println(G7Countries);

        // 去重
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(x -> x*x).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }

    /**
     * 计算集合元素的最大值、最小值、总和以及平均值
     */
    @Test
    public void test6(){
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt(x->x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }

    @Test
    public void test7(){
        List<String> strings = Arrays.asList("a","b","c");
        strings.stream().map((String s) -> s.toUpperCase()).forEach(System.out::println);
    }
}
