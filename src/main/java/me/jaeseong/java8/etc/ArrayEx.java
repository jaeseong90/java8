package me.jaeseong.java8.etc;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ArrayEx {

    public static void main(String[] args) {

        int size = 1500;
        int[] numArr = new int[size];
        Random random = new Random();

        IntStream.range(0,size).forEach(i->numArr[i] = random.nextInt());
        long start = System.nanoTime();
        Arrays.sort(numArr);
        System.out.println("serial sorting took : " + (System.nanoTime() - start));

        IntStream.range(0,size).forEach(i->numArr[i] = random.nextInt());
        start = System.nanoTime();
        Arrays.parallelSort(numArr);
        System.out.println("parallel sorting took : " + (System.nanoTime() - start));

    }

}
