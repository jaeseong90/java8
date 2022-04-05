package me.jaeseong.java8;

public interface JooI {

    void printName();

    //메소드를 추가하면 모든 구현체가 오버라이딩 해야하므로 default 메소드로 기능 제공
    //하지만 기본 구현체가 어떤 기능을 제공하는지 어떻게 구현되어있는지 사용자가 모르고 사용하면 runtime 에러가 발생할 수 있으므로 주석을
    //꼼꼼하게 남긴다.
    /**
     * @implSpec
     * 이 구현체는 getname()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     *
     */
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    String getName();

    /*
    Object 재정의 불가
    default String toString(){
        return "";
    }
    */

    static void printJaeseong(){
        System.out.println("printJaeseong");
    }

}
