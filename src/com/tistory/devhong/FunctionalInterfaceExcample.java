package com.tistory.devhong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by devHong on 2017-01-05.
 * https://github.com/sungjaeHong
 */
public class FunctionalInterfaceExcample {
    public static void main(String[] args) {
        /**
         *  Function, The Transformer
         *  function consumer predicate supplier
         */
        /*
        //abstract class instance
        Function<String, Integer> toInt = new Function<String, Integer>(){
            @Override
            public Integer apply(String value){
                return Integer.parseInt(value);
            }
        };
        int result = toInt.apply("100");
        System.out.println(result);
        */


        //mapper, String -> Integer
        //T타입을 받아 R타입을 return하는게 apply
        Function<String, Integer> toInt = value->Integer.parseInt(value);   //Lambda Expression
        int result = toInt.apply("123");
        System.out.println(result);//output : 123


        //같은 Type을 return 하면 Identity라고 한다.
        /**
         *  함수형프로그래밍에서는 함수라는것 자체가 First Class Citizen이기 때문에
         *  parameter로만 받는게 아니라 return 값으로도 함수를 쓸 수 있다.
         */
        //Function<Integer, Integer> identity = Function.identity();    //java.util.function에 있는 기본함수
        Function<Integer, Integer> identity = t -> t;                   //Lambda를 이용해 구현한 identity function
        System.out.println(identity.apply(200));//output:200

        System.out.println();


        /**
         *  Consumer
         */
        /*
        //abstract class instance
        Consumer<String> print = new Consumer<String>(){
            @Override
            public void accept(String value) {
                System.out.println(value);
            }
        };
        print.accept("Hello");
        */

        Consumer<String> print = value -> System.out.println(value);    //Lambda Expression
        Consumer<String> printHello = str -> System.out.println("Hello " + str);
        //print.accept("Hello");
        printHello.accept("Java");
        printHello.accept("World");
        System.out.println();

        /**
         *  Predicate
         */
        Predicate<Integer> isPositive = i -> i>0;
        Predicate<Integer> lessThan3 = i -> i<3;

        System.out.println(isPositive.test(1));
        System.out.println(isPositive.test(0));
        System.out.println(isPositive.test(-1));

        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
        List<Integer> positiveNumbers = new ArrayList<Integer>();
        List<Integer> lessThan3Numbers = new ArrayList<Integer>();

        for(Integer i: numbers){
            if(isPositive.test(i)){
                positiveNumbers.add(i);
            }
            if(lessThan3.test(i)){
                lessThan3Numbers.add(i);
            }
        }
        System.out.println("positive integers : " + positiveNumbers);
        System.out.println("filter integers : " + filter(numbers, isPositive));

        System.out.println("less than 3 : " + lessThan3Numbers);
        System.out.println("filter less than 3 : " + filter(numbers, lessThan3));
        System.out.println();
        /**
         *  Supplier
         */
        Supplier<String> helloSupplier = () -> "Hello ";
        System.out.println(helloSupplier.get() + "world");  //왜 supplier를 쓰느냐... 바로 value가 비용이 큰 method를 통해 넘어 올때를 위해.

        long start = System.currentTimeMillis();
        /*printIfValidIndex(0, "SungJae Hong");
        printIfValidIndex(1, getVeryExpensiveValue());
        printIfValidIndex(-1, "SungJae Hong");
        printIfValidIndex(-2, "SungJae Hong");*/
        printIfValidIndex(0, ()->getVeryExpensiveValue());
        printIfValidIndex(-1, ()->getVeryExpensiveValue());
        printIfValidIndex(-2, ()->getVeryExpensiveValue());
        System.out.println("It took " + ((System.currentTimeMillis()-start)/1000) + " seconds");

    }

    //엄청난 연산이 걸리는 method라고 가정
    private static String getVeryExpensiveValue(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SungJae Hong";
    }
    //이럴 경우 의미없는 number가 들어와도 String value를 받기 위해 자원낭비가 생긴다.
    /*private static void printIfValidIndex(int number, String value){
        if(number >= 0){
            System.out.println("The value is " + value);
        } else {
            System.out.println("Invalid");
        }
    }*/
    private static void printIfValidIndex(int number, Supplier<String> valueSupplier){
        if(number >= 0){
            System.out.println("The value is " + valueSupplier.get());
        } else {
            System.out.println("Invalid");
        }
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> filter){
        List<T> result = new ArrayList<>();
        for(T input : list){
            if(filter.test(input)){
                result.add(input);
            }
        }
        return result;
    }
}
