package com.tistory.devhong;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 * Created by devHong on 2016-12-28.
 * https://github.com/sungjaeHong
 */
public class WhyJava8 {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //1 : 2 : 3 : 4 : 5 ... : 10
        StringBuilder stringBuilder = new StringBuilder();
        /*
        1 way
        for(Integer number : numbers){
            stringBuilder.append(number).append(" : ");
        }
        */
        /*
        2 way
        int size = numbers.size();
        for(int i = 0; i < size; i++){
            stringBuilder.append(numbers.get(i));
            if(i != size-1){
                stringBuilder.append(" : ");
            }
        }
        */
        /*
        3 way
        for(Integer number : numbers){
            stringBuilder.append(number).append(" : ");
        }
        if(stringBuilder.length() > 0){
            stringBuilder.delete(stringBuilder.length() -3 , stringBuilder.length());
        }
        */
        //System.out.println(stringBuilder.toString());
        String result = numbers.stream()
                        .map(String::valueOf)               //Map<T, S>의 map이 아니라 ○ -> △ 로 mapping한다라는 의미. 여기서는 String클래스의 valueOf메소드를 사용한다는 의미.
                        .collect(joining(" : "));
        System.out.println(result);

    }
}
