package me.jaeseong.java8.optional;


import me.jaeseong.java8.stream.OnlineClass;

import javax.swing.text.html.Option;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionEx {

    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        /*
        -- null 처리하여 받아오기
        OnlineClass spring_boot = new OnlineClass(1,"springboot",true);
        Optional<Progress> progress = spring_boot.getProgress();
        progress.ifPresent(s-> System.out.println(s.getStudyDuration()));
        */

        Optional<OnlineClass> spring = springClasses.stream().filter(s->s.getTitle().startsWith("jpa")).findFirst();
        boolean present = spring.isPresent();
        System.out.println(present);

        OnlineClass onlineClass;

        //if 문으로 상태체크하여 받아오기
        if(spring.isPresent()){
            onlineClass = spring.get();
        }

        //optional 함수 이용하여 받아오기
        onlineClass = spring.orElse(createNewClass()); //빈값 여부와 관계없이 실행
        System.out.println(onlineClass.getTitle());
        onlineClass = spring.orElseGet(()->createNewClass()); //값이 없을때만 실행
        System.out.println(onlineClass.getTitle());

        //만들 수 없는 경우
        //NoSuchElementException 런타임 에러 던지기
        //OnlineClass onlineClass1 = spring.orElseThrow();

        try{
            onlineClass = spring.orElseThrow(()->{
                return new RuntimeException("커스텀 에러도 가능");
            });
        }catch(RuntimeException ex){
            ex.printStackTrace();
        }

        //계속 참조값 사용 하지 않고 처리만 하는 경우
        spring.ifPresent(s->{
            System.out.println(s.getTitle());
        });

        //filter Predicate
        Optional<OnlineClass> filterOnline = springClasses.stream().filter(s->s.getTitle().startsWith("spring")).findFirst();

        //map Function
        Optional<String> titles = filterOnline.map( s-> s.getTitle());
        titles.ifPresent(System.out::println);

        //flatMap
        //Optional 안에 Optional 인 경우 사용하여 편리하게 꺼내기
        Optional<Progress> progress = filterOnline.flatMap(OnlineClass::getProgress);



    }

    private static OnlineClass createNewClass(){
        return new OnlineClass(10,"New Class",false);
    }



}
