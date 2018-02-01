package com.example.base.util;

import com.example.base.domain.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * jdk8 stream新特性test():
 * 包括筛选、切片、映射、查找、匹配、归约等等
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamTests {

    /**
     * list 转 map
     */
    @Test
    public void toMapTest() {
        List<Example> examples = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Example example = Example.builder()
                    .id(i)
                    .name("A" + i)
                    .build();
            examples.add(example);
        }

        Map<Integer, Example> exampleMap = examples.stream().collect(Collectors.toMap(Example::getId, example -> example));
        System.out.println("get map result is :" + exampleMap);
    }

    @Test
    public void filterTest() {
        List<Integer> list = Arrays.asList(1, 4, 3, 6, 2, 8, 7, 4, 6);

        list.stream()
                .skip(1) //跳过n
                .distinct() //去重
                .limit(3) //截取
                .sorted(Comparator.reverseOrder())
                .filter(x -> x > 3) //过滤
                .forEach(System.out::println);
    }

    @Test
    public void sortTest() {
        List<Example> examples = new ArrayList<>();
        examples.add(new Example(1, "大毛"));
        examples.add(new Example(4, "四毛"));
        examples.add(new Example(2, "二毛"));
        examples.add(new Example(7, "七毛"));
        examples.add(new Example(5, "五毛"));

        //升序
        List<Example> sortList1 = examples.stream()
                .sorted(Comparator.comparing(Example::getId)).collect(Collectors.toList());
        System.out.println("list 升序方法一 result is :" + sortList1);

        //降序
        List<Example> sortList2 = examples.stream()
                .sorted((e1, e2) -> e2.getId() - e1.getId()).collect(Collectors.toList());
        System.out.println("list 降序方法一 result is :" + sortList2);

        //降序
        List<Example> sortList3 = examples.stream()
                .sorted(Comparator.comparing(Example::getId).reversed()).collect(Collectors.toList());
        System.out.println("list 降序方法二 result is :" + sortList3);
    }

    /**
     * 重新组装list元素
     */
    @Test
    public void mapTest() {
        List<Example> examples = new ArrayList<>();
        examples.add(new Example(1, "大毛"));
        examples.add(new Example(4, "四毛"));
        examples.add(new Example(2, "二毛"));
        examples.add(new Example(7, "七毛"));
        examples.add(new Example(5, "五毛"));

        List<String> newList = examples.stream()
                .map(Example::getName).collect(Collectors.toList());
        System.out.println("get new result is :" + newList);
    }

    @Test
    public void numTest() {
        List<Integer> list = Arrays.asList(1, 4, 3, 6, 2, 8, 7, 4, 6);
        List<Example> examples = new ArrayList<>();
        examples.add(new Example(1, "大毛"));
        examples.add(new Example(4, "四毛"));
        examples.add(new Example(2, "二毛"));
        examples.add(new Example(7, "七毛"));
        examples.add(new Example(5, "五毛"));
        OptionalInt max = list.stream().mapToInt(Integer::intValue).max();
        Integer sum = list.stream().reduce(0, (Integer::sum));
        int objectSum = examples.stream().mapToInt(Example::getId).sum();
        System.out.println("get new result is :" + max);
        System.out.println("get sum result is :" + sum);
        System.out.println("get object sum result is :" + objectSum);
        //reduce
        List<String> list1 = Arrays.asList("1", "2", "4", "3");
//        Optional<String> reOptional = list1.stream().reduce(Example::getName);
        Optional<String> reOptional = list1.stream().reduce((str1,str2) -> str1 + "-->" + str2);
        reOptional.ifPresent(System.out::println); //1-->2-->3-->3-->follow-->wind-->followwwind
//        Stream<String> stringStream = examples.stream().map(example -> example.getName() + "-->");
//        System.out.println("get map;:::"+stringStream);

    }

    @Test
    public void matchTest() {
        List<Integer> list = Arrays.asList(1, 4, 3, 6, 2, 8, 7, 4, 6);
        //match 流匹配,终结操作
        System.out.println(list.stream().allMatch(str -> str == 3));// false
        System.out.println(list.stream().anyMatch(str -> str > 5));// true
        System.out.println(list.stream().noneMatch(str -> str > 5));// false
    }

}
