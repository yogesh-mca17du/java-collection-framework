package com.engineeringdigest.collectionframework.stream.practice;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreationOfStream {

    public static void main(String[] args) {

        // Using Constructors
        streamConstructors();

        // Primitive type Arrays: int, double and long
        streamFromPrimitiveTypeArrays();

        // String
        stringStreams();

        // Collections
        streamUsingCollectin();


    }

    private static void streamUsingCollectin() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4); // List.of(1, 2, 3, 4).stream()")
        System.out.println("Stream<Integer> integerStream = List.of(1, 2, 3, 4).stream()");
        integerStream.forEachOrdered(CreationOfStream::print);
        System.out.println("\n");

        Stream<Integer> integerStreamFromSet = Set.of(1, 2, 3, 4, 5).stream();
        System.out.println("Stream<Integer> integerStreamFromSet = Set.of(1, 2, 3, 4, 5).stream()");
        integerStreamFromSet.forEachOrdered(CreationOfStream::print);
        System.out.println("\n");


        Map<String, String> stringStringMap = Map.of("Yogesh", "Bhakhar",
                "Abhishek", "Bhardwaj",
                "Raman", "Dhawan",
                "Rahul", "Pathak"
        );

        Stream<Map.Entry<String, String>> entryStream = stringStringMap.entrySet().stream();
        System.out.println("Stream<Map.Entry<String, String>> entryStream = stringStringMap.entrySet().stream()");
        entryStream.forEachOrdered(CreationOfStream::print);
        System.out.println("\n");
        Stream<String> mapKeySetStream = stringStringMap.keySet().stream();
        System.out.println("Stream<String> mapKeySetStream = stringStringMap.keySet().stream()");
        mapKeySetStream.forEachOrdered(CreationOfStream::print);
        System.out.println("\n");
        Stream<String> mapValuesStream = stringStringMap.values().stream();
        System.out.println("Stream<String> mapValuesStream = stringStringMap.values().stream()");
        mapValuesStream.forEachOrdered(CreationOfStream::print);
        System.out.println("\n");
    }

    private static void stringStreams() {
        String string = "hello world hello java word";
        IntStream charsIntSteam = string.chars();
        System.out.println("IntStream charsIntSteam = string.chars()");
        charsIntSteam.map(v -> v - 'a' + 1).forEach(CreationOfStream::print);
        System.out.println("\n");


        String string2 = "hello world hello java word";
        Stream<String> stringStream = Arrays.stream(string.split(" "));
        System.out.println("Stream<String> stringStream = Arrays.stream(string.split(\" \"))");
        stringStream.forEach(CreationOfStream::print);
        System.out.println("\n");
    }

    private static void streamFromPrimitiveTypeArrays() {
        int[] ints = new int[]{1, 2, 3, 4, 5};
        boolean[] booleans = new boolean[]{true, false, true, false, true};
        double[] doubles = new double[]{1, 2, 3, 4, 5};
        char[] chars = new char[]{'Y', 'o', 'g', 'e', 's', 'h'};
        IntStream intStream = Arrays.stream(ints);
        System.out.println("IntStream intStream = Arrays.stream(ints)");
        intStream.forEach(CreationOfStream::print);
        System.out.println("\n");

        DoubleStream doubleStream = Arrays.stream(doubles);
        System.out.println("DoubleStream doubleStream = Arrays.stream(doubles)");
        doubleStream.forEach(CreationOfStream::print);
        System.out.println("\n");

        LongStream longStream = Arrays.stream(new long[]{1L, 2L, 500L});
        System.out.println("LongStream longStream = Arrays.stream(new long[]{1L, 2L, 500L})");
        longStream.forEach(CreationOfStream::print);
        System.out.println("\n");

        int[] ints1 = new int[]{1, 2, 3, 4, 5};
        IntStream intStream1 = Arrays.stream(ints1, 0, ints1.length);
        System.out.println("Arrays.stream(ints1, startIndex_Inclusive, endIndex_Exclusive)");
        intStream1.forEach(CreationOfStream::print);
        System.out.println("\n");
    }


    public static void streamConstructors() {
        List<Integer> integerList = List.of(1, 2, 3, 4, 25, 22, 52, 12);
        Set<Integer> integerSet = Set.of(1, 2, 3, 4, 5);

        // Steam Constructors:
        // 1. Stream.of(T ... values)
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        System.out.println("Stream.of(T ... values)");
        integerStream.forEach(CreationOfStream::print);
        System.out.println("\n");

        // 2.  Stream.of(T t)
        Stream<List<Integer>> integerListStream = Stream.of(integerList);
        System.out.println("Stream.of(List<Integer>");
        integerListStream.forEach(CreationOfStream::print);
        System.out.println("\n");
        Stream<Set<Integer>> integerSetStream = Stream.of(integerSet);
        System.out.println("Stream.of(Set<Integer>");
        integerSetStream.forEach(CreationOfStream::print);
        System.out.println("\n");

        // Returns an empty sequential Stream.
        Stream<Object> empty = Stream.empty();
        System.out.println("Empty Stream");
        empty.forEach(CreationOfStream::print);
        System.out.println("\n");

        // Stream.builder().build()
        Stream.Builder<Object> builder = Stream.builder();
        Stream<Object> builderStream = builder.add(integerList).build();
        System.out.println("Stream.builder().build() : with add");
        builderStream.forEach(CreationOfStream::print);
        System.out.println("\n");

        Stream.Builder<Object> builder1 = Stream.builder();
        builder1.accept(1);
        builder1.accept(2);
        builder1.accept(3);
        Stream<Object> builderStream1 = builder1.build();
        System.out.println("Stream.builder().build() : with accept");
        builderStream1.forEach(CreationOfStream::print);
        System.out.println("\n");


        // Stream.concat(Steam<? extends T> a , Steam<? extends T> b
        Stream<Integer> concatedSteam = Stream.concat(Stream.of(1, 2, 3, 4, 5), Stream.of(101, 102, 103, 104, 105));
        System.out.println("Stream.concat(Steam<? extends T> a , Steam<? extends T> b)");
        concatedSteam.forEach(CreationOfStream::print);
        System.out.println("\n");

        // Stream.generate(Supplier<? extends T> s)
        Stream<Integer> generateStream = Stream.generate(() -> new Random().nextInt()).limit(5);
        System.out.println("Stream.generate(Supplier<? extends T> s)");
        generateStream.forEach(CreationOfStream::print);
        System.out.println("\n");

        // iterate(final T seed, final UnaryOperator<T> f)
        Stream<Integer> iterateStream = Stream.iterate(1, x -> x + 1).limit(5);
        System.out.println("iterate(final T seed, final UnaryOperator<T> f)");
        iterateStream.forEach(CreationOfStream::print);
        System.out.println("\n");


        // iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)
        // Here predicate is breaking condition(short circuit) when false will stop iterating
        Stream<Integer> iterateSteam2 = Stream.iterate(1, x -> x <= 10, x -> x + 1);
        System.out.println("iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)");
        iterateSteam2.forEach(CreationOfStream::print);
        System.out.println("\n");
    }


    public static void print(Object o) {
        System.out.print(o + ", ");

    }
}
