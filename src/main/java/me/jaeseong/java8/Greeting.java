package me.jaeseong.java8;

public class Greeting {
    private String name;
    public Greeting(){
    }
    public String getName() {
        return name;
    }
    public Greeting(String name){
        this.name = name;
    }
    public String hello(String s){
        return "hello" + s;
    }
    public static String hi(String s){
        return "hi" + s;
    }
}