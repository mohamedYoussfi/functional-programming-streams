package test.model;

import java.util.Objects;

public class Person {
    private final String name;
    private final Gender gender;
    private final int score;

    public Person(String name, Gender gender, int score) {
        this.name = name;
        this.gender = gender;
        this.score = score;
    }

    public String getName() {
        return name;
    }


    public Gender getGender() {
        return gender;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return score == person.score && Objects.equals(name, person.name) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, score);
    }
}
