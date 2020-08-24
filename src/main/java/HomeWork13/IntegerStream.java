package HomeWork13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerStream {

    public static void main(String[] args) {

        //задание 1
        System.out.println("\nзадание 1\n");

        List<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(7);
        integers.add(15);
        integers.add(4);

        OptionalDouble integerStream = integers.stream()
                .mapToInt(i -> i)
                .average();

        System.out.println(integerStream);

        //задание 2
        System.out.println("\nзадание 2\n");

        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");


        List<Pair> pairList1 = (List<Pair>) strings.stream()
                .map(String::toLowerCase)
                .map(Pair::new)
                .peek(p -> {
                        System.out.println("{" + p.getLowerElem() + ":" + p.getUpperElem()+ "}");
                })
                .collect(Collectors.toList());

        //задание 3
        System.out.println("\nзадание 3\n");

        List<String> strings1 = new ArrayList<>();
        strings1.add("QwerRt");
        strings1.add("gbgb");
        strings1.add("thrGBGnee");
        strings1.add("gg");
        strings1.add("rr");
        strings1.add("QWE");

        strings1.stream()
                .map(String::toLowerCase)
                .filter(s -> s.length()<4)
                .forEach(System.out::println);

    }

}
