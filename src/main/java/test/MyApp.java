package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import test.model.Gender;
import test.model.Operator;
import test.model.Person;

import java.util.*;
import java.util.stream.Collectors;
public class MyApp {
    public static void main(String[] args) {
        // Objet d'une classe anonyme
        Operator operator = new Operator() {
            @Override
            public double apply(double a, double b) {
                return a + b;
            }
        };
        // Lambda Expression Syntax
        Operator operator2 = (a, b) -> (a + b);

        System.out.println(operator.apply(9,8));
        System.out.println(operator2.apply(7,8));
        // Liste d'objets
        List<Person> personList = Arrays.asList(
                new Person("Mohamed", Gender.MALE, 50),
                new Person("Hanane", Gender.FEMALE, 22),
                new Person("Ines", Gender.FEMALE, 70),
                new Person("Malak", Gender.FEMALE, 45)
        );
        // API Streams
        personList
                .stream()
                .forEach(System.out::println);
        System.out.println("=================================");
        // Opérateur filter
        personList
                .stream()
                .filter(p->p.getGender().equals(Gender.FEMALE))
                .forEach(System.out::println);
        // MapToDouble => average
        System.out.println("=================================");
        OptionalDouble average = personList.stream()
                .mapToDouble(p -> p.getScore())
                .average();
        System.out.println(average.getAsDouble());
        // Opérateur map
        System.out.println("=================================");
        List<List<Person>> duplicatePersonList = personList.stream()
                .map(p -> Arrays.asList(p,new Person(p.getName(),p.getGender(),p.getScore())))
                .collect(Collectors.toList());
        System.out.println(duplicatePersonList);
        // Opérateur flatMap
        System.out.println("================================");
        List<Person> personListFlated = duplicatePersonList
                .stream()
                .flatMap(people -> people.stream())
                .collect(Collectors.toList());
        System.out.println(personListFlated);

        // Opérateur distinct
        System.out.println("=============================");
        List<Person> distinctPersonList = personListFlated.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctPersonList);
        // Group By
        System.out.println("===============================");
        Map<Gender, List<Person>> groupBy = personList.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        System.out.println(groupBy);
        // Group By + Averaging
        System.out.println("===========================");
        Map<Gender, Double> groupBySum = personList.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.averagingDouble(Person::getScore)));
        System.out.println(groupBySum);

    }


}
