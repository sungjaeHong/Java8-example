package com.tistory.devhong;

/**
 * Created by devHong on 2016-12-29.
 * https://github.com/sungjaeHong
 */
public class OopAnotherExample {
    public static void main(String[] args){
        /*
        CalculatorService calculatorService = new CalculatorService();
        int additionResult = calculatorService.calculate('+', 1, 1);
        System.out.println(additionResult);

        int subractionResult = calculatorService.calculate('-', 1, 1);
        System.out.println(subractionResult);

        int multiplicationResult = calculatorService.calculate('*', 1, 1);
        System.out.println(multiplicationResult);

        int divisionResult = calculatorService.calculate('/', 8, 4);
        System.out.println(divisionResult);
        */

        //스트레티지 패턴을 사용해 구현한 계산기

        NewCalculatorService newCalculatorService = new NewCalculatorService(new Addition());

        int additionResult = newCalculatorService.calculate(1, 1);
        System.out.println(additionResult);

    }
}

/**
 * Created by devHong on 2016-12-29.
 * https://github.com/sungjaeHong
 * 요구사항이 생기면 모든 if문을 수정해야한다.
 * 따라서 단일책임 원칙에 위배된다.
 */

class CalculatorService{
    public int calculate(char calculation, int num1, int num2){
        if (calculation == '+')    {
            return num1 + num2;
        } else if (calculation == '-') {
            return num1 - num2;
        } else if (calculation == '*') {
            return num1 * num2;
        } else if (calculation == '/') {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("Unknown calculation : " + calculation);
        }
    }
}


/**
 * 위 소스를 아래와 같이 스트레티지 패턴을 사용하여수정하였다.
 */

interface Calculation {
    int calculate(int num1, int num2);
}

class Addition implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}

class Subtraction implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}

class Multiplication implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}

class Division implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 / num2;
    }
}

class NewCalculatorService{
    private Calculation calculation;

    //생성자를 통해 Dependency Injection을 해주었다.
    public NewCalculatorService(Calculation calculation){
        this.calculation = calculation;
    }

    public int calculate(int num1, int num2){
        return calculation.calculate(num1, num2);
    }
}