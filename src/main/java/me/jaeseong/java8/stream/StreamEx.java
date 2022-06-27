package me.jaeseong.java8.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {

    public static void main(String[] args) {

        List<String> names = new ArrayList<String>();
        names.add("jaeseong");
        names.add("heejeong");
        names.add("apple");
        names.add("haha");

        //병렬적 처리가 어려움
        names.forEach(System.out::println);
        //병렬스트림 받아처리가 가능
        //병렬 스레드로 처리가 더 느릴 수도 있음
        //대부분의 경우 메인스레드가 더 빠를 수 있고 데이터소스와 처리케이스 마다 성능 측정을 해서 처리
        List<String> collect = names.parallelStream().map(s->{
                    System.out.println(s + " " + Thread.currentThread().getName());
                    return s.toUpperCase();
                }
        )
        .collect(Collectors.toList());

        collect.forEach(System.out::println);
        System.out.println("------------------------------------------------------------");
        //스트림 API 예제
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> exArr = new ArrayList<>();
        exArr.add(springClasses);
        exArr.add(javaClasses);


        System.out.println("spring 으로 시작하는 수업");
        // TODO
        springClasses.stream().filter(s->s.getTitle().startsWith("spring"))
        .forEach(s-> System.out.println(s.getTitle()));


        System.out.println("close 되지 않은 수업");
        // TODO
        //not 은 jdk 11에 있음
        //springClasses.stream().filter(Predicate.not(OnlineClass::isClosed)).forEach(s-> System.out.println(s.getTitle()));
        springClasses.stream().filter(s -> !s.isClosed()).forEach(s-> System.out.println(s.getTitle()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        // TODO
        springClasses.stream().map(s -> s.getTitle()).forEach(System.out::println);


        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        // TODO
        exArr.stream().flatMap(Collection::stream)
                .forEach(oc -> System.out.println(oc.getId()));


        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        // TODO
         Stream.iterate(10, i -> i+1).skip(10).limit(10).forEach(System.out::println);


        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        // TODO
        boolean hasTest = javaClasses.stream().anyMatch(s-> s.getTitle().contains("Test"));
        System.out.println(hasTest);

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
        // TODO
        List<String> spring = springClasses.stream().filter(s->s.getTitle().contains("spring"))
                .map(s-> s.getTitle()).collect(Collectors.toList());
        spring.forEach(System.out::println);



    }

}
