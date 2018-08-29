package cn.edu.bupt.opensource.test.jdk8.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>Title: StreamTest</p>
 * <p>Description: Stream接口</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-31 09:45</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class StreamTest {

    @Test
    public void test() {
        Stream<String> stream = Stream.of("I", "love", "you", "too", "too");
        stream.distinct()
                .map(String::toUpperCase)
                .sorted(Comparator.comparingInt(String::length)
                            .thenComparing(String::compareTo)
                            .reversed())
                //.filter(str -> str.length() == 3)
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        Stream<List<Integer>> stream= Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4, 5));
        stream.flatMap(List::stream)
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        // 寻找最长的单词
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Optional<String> longest =  stream.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        //Optional<String> longest = stream.max(Comparator.comparingInt(String::length));
        System.out.println(longest.get());
    }

    @Test
    public void test4() {
        // 求解单词长度之和
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Integer longthSum =  stream.reduce(0, (sum, str) -> sum + str.length(), (a, b) -> a+b);
        //Integer longthSum = stream.mapToInt(String::length).sum();
        System.out.println(longthSum);
    }

    @Test
    public void test5() {
        // Stream转换为容器或Map
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        List<String> list = stream.collect(Collectors.toList());
        Set<String> set =  stream.collect(Collectors.toSet());
        Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length));
    }

    @Test
    public void test6() {
        // Stream规约为List
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        List<String> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        List<String> list2 = stream.collect(Collectors.toList());

        // toCollection()指定规约容器的类型
        ArrayList<String> arrayList = stream.collect(Collectors.toCollection(ArrayList::new));
        HashSet<String> hashSet = stream.collect(Collectors.toCollection(HashSet::new));

    }








}
