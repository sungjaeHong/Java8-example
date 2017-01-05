package com.tistory.devhong;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by devHong on 2017-01-05.
 * https://github.com/sungjaeHong
 */
public class FunctionalInterfaceExcample {
    public static void main(String[] args) {
        /**
         *  Function, The Transformer
         */
        /*
        Lambda로 변경 전
        Function<String, Integer> toInt = new Function<String, Integer>(){
            @Override
            public Integer apply(String value){
                return Integer.parseInt(value);
            }
        };
        int result = toInt.apply("100");
        System.out.println(result);
        */

        //Lambda로 변경
        //mapper, String -> Integer
        Function<String, Integer> toInt = value->Integer.parseInt(value);
        int result = toInt.apply("123");
        System.out.println(result);


        //같은 Type을 return 하면 Identity라고 한다.
        /**
         *  함수형프로그래밍에서는 함수라는것 자체가 First Class Citizen이기 때문에 parameter로만 받는게 아니라 return 값으로도 함수를 쓸 수 있다.
         */
        //Function<Integer, Integer> identity = Function.identity();    //java.util.function에 있는 기본함수
        Function<Integer, Integer> identity = t -> t;                   //Lambda를 이용해 구현한 identity function
        System.out.println(identity.apply(200));


    }
}
