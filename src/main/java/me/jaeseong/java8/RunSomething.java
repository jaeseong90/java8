package me.jaeseong.java8;

//java가 제공하는 애노테이션
//함수형 인터페이스의 경우 추가하여 강력하게 관리
@FunctionalInterface
public interface RunSomething {

    void doIt(); //추상메서드 1개면 함수형 인터페이스  / abstract 생략 /

    //java8 public 생략 static, default 메서드 추가 가능
    static void printName(){
        System.out.println("jaeseong");
    }

    default void printAge(){
        System.out.println("33");
    }

}
