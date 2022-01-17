package test;

import java.util.Random;
import java.util.function.*;

public class Test {
    public static void main(String[] args) {
        Function<Integer,Integer> integerFunction=(input)->input+90;
        Consumer<Integer> integerConsumer=(input)-> System.out.println("=>"+input);
        Supplier<Integer> integerSupplier=()->new Random().nextInt();
        Predicate<Integer> integerPredicate=(input)->input==78;
        BiFunction<Integer,Integer,Integer> integerBiFunction=(a,b)->a+b;
        Integer apply = integerFunction.apply(80);
        System.out.println(apply);
        integerConsumer.accept(90);
        Integer integer = integerSupplier.get();
        System.out.println(integer);
        System.out.println(integerPredicate.test(78));

    }
}
