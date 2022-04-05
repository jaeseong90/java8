package me.jaeseong.java8;

public class JooImpl implements JooI, Joo2 {
    //default method 충돌하는 경우 재정의 해야함

    String name;

    public JooImpl(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }
}
