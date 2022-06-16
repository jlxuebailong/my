package org.my.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class NewStream {

    public static void main(String[] args) {
        Stream s1 = Stream.of("a", "ab", "c");
        Object result = s1.filter((s)->((String)s).startsWith("a")).collect(joining(", "));
        System.out.println(result);

        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");

        // 2. Arrays
        String [] strArray = new String[] {"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);

        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();

    }
}
