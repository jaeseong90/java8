package me.jaeseong.java8;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Foo {

    public static void main(String[] args) {

        //함수형 인터페이스와 람다표현식 #1
        //익명내부클래스 형태로 사용
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("hello");
                System.out.println("hello");
            }
        };
        runSomething.doIt();

        //람다표현식으로 많은 부분 생략가능 SingLine
        RunSomething runSomethingRamda = () -> System.out.println("hello");
        runSomethingRamda.doIt();

        //람다표현식으로 많은 부분 생략가능 multiLine
        RunSomething runSomethingRamda2 = () -> {
            System.out.println("hello");
            System.out.println("hello");
        };
        runSomethingRamda2.doIt();


        //함수형 프로그래밍
        //first class object
        //입력받은값이 동일한 경우 결과 값이 같아야 한다.
        //퓨어한함수 외부값사용x, 외부값변경x
        int basedNumber = 10;
        RunSomething2 runSomething2 = (number) -> {
            return number + basedNumber;
        };
        System.out.println(runSomething2.doIt(1));
        System.out.println(runSomething2.doIt(1));



        //함수형 인터페이스와 람다표현식 #2
        //자바가 제공하는 함수형 인터페이스 중 자주 사용할만한 함수 인터페이스
        //java.util.function package

        System.out.println("START OF Function구현");
        //Function 구현
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(10));
        System.out.println("END OF Function구현");


        //R/T
        System.out.println("START OF R/T");
        Function<Integer, Integer> plus = integer -> integer + 10;
        System.out.println(plus.apply(10));
        Function<Integer, Integer> muliply = integer -> integer * 2;
        System.out.println(muliply.apply(10));
        System.out.println("END OF R/T");


        //조합
        System.out.println("START OF 조합");
        plus.compose(muliply);
        System.out.println(plus.apply(10));
        plus.andThen(muliply);
        System.out.println(plus.apply(10));
        System.out.println("END OF 조합");

        //T, U, R
        BiFunction<Integer, String, Integer> integerStringIntegerBiFunction = (integer, s) -> {
            System.out.println(s);
            return integer +10;
        };

        //void
        Consumer<Integer> consumer = integer -> System.out.println(integer);
        consumer.accept(1);

        //R
        Supplier<Integer> supplier = () -> 10;

        //boolean test
        Predicate<String> stringPredicate = s -> s.startsWith("jaeseong");
        Predicate<Integer> isOdd = integer -> integer % 2 == 0;

        //T, R 같은 경우
        UnaryOperator<Integer>  integerUnaryOperator = integer -> integer +10;

        //함수형인터페이스와 람다식 #3
        // () 인자선언
        // -> 바디
        //()-> 인자의 타입은 제네릭에 써둔것으로 컴파일러가 생략가능하지만 명시할 수도 있다.
        Function<Integer, String> integerStringFunction = (Integer i) ->{
            return i.toString();
        };
        Function<Integer, String> integerStringFunction2 = (i) -> i.toString();



        //변수캡처#4
        run();

        //메소드 레퍼런스#5
        //스태틱 메소드 참조 ::
        UnaryOperator<String> stringUnaryOperator = Greeting::hi;
        Greeting greeting = new Greeting();
        System.out.println(stringUnaryOperator.apply("스태틱메소드참조"));
        
        UnaryOperator<String> stringUnaryOperator1 = greeting::hello;
        System.out.println(stringUnaryOperator1.apply("객체인스턴스메소드참조"));

        //생성자 객체를 받을 수도 있음
        Supplier<Greeting> greetingSupplier = Greeting::new;
        Greeting greeting1 = greetingSupplier.get();
        greeting.hello("생성자를 레퍼런스하여 객체 받음");
        Function<String, Greeting> stringGreetingFunction = Greeting::new;
        Greeting greeting2 = stringGreetingFunction.apply("jaeseong");
        System.out.println(greeting2.getName() + ": 문자열 생성자 메소드 참조");

        //임의의 객체의 인스턴스 메소드 참조
        String[] name = {"재성", "기억", "희정"};
        System.out.println(Arrays.toString(name));
        Arrays.sort(name, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareToIgnoreCase(o1);
            }
        });
        System.out.println(Arrays.toString(name));
        Arrays.sort(name, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(name));

        //#6 interface / default method, static method
        //제약사항으로는 Object method 는 재정의 불가
        //default 와 static 강력하지만 주의가 필요해보임
        JooI jooI = new JooImpl("jaeseong");
        jooI.printName();
        jooI.printNameUpperCase();
        JooI.printJaeseong();


        //람다의 등장으로 변한 API

        List<String> nameArr = new ArrayList<>();
        nameArr.add("재성1");
        nameArr.add("재성2");
        nameArr.add("하하1");
        nameArr.add("하하2");

        //Iterator
        //메소드 레퍼런스
        System.out.println("=======================");
        nameArr.forEach((s) -> {
            System.out.println(s);
        });
        System.out.println("=======================");
        nameArr.forEach(s -> System.out.println(s));
        System.out.println("=======================");
        nameArr.forEach(System.out::println);
        System.out.println("=======================");
        for(String s: nameArr){
            System.out.println(s);
        }
        System.out.println("=======================");
        Spliterator<String> spliterator = nameArr.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        System.out.println("=======================");
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("=======================");
        while (spliterator1.tryAdvance(System.out::println));
        System.out.println("=======================");






    }

    //변수캡처
    private static void run(){
        System.out.println("START OF 변수캡처");
        int baseNumber = 10;

        //final or Effective final 만 사용 가능 (1.8 이전에는 final 만 사용가능했음)
        // =>baseNumber++; 와 같은 값 변경하는 코드가 있으면 컴파일 오류 발생

        //로컬클래스
        class LocalClass {
            void printBasenumber(){
                //쉐도잉
                int baseNumber = 0;
                System.out.println(baseNumber);
            }
        }

        LocalClass localClass = new LocalClass();
        localClass.printBasenumber();

        //익명클래스
        IntConsumer printConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                int baseNumber = 0;
                System.out.println(baseNumber);
            }
        };
        printConsumer.accept(10);

        //람다
        IntConsumer printConsumer1 = value -> System.out.println(value + baseNumber);
        printConsumer1.accept(10);

        //쉐도잉
        //로컬클래스와 익명클래스는 쉐도잉이 되어서 같은 이름의 변수가 내부에 있으면 가려진다.
        //람다는 쉐도잉이 안되고 감싸는 메서드와 스코프가 같다.
        System.out.println("END OF 변수캡처");
    }
}
