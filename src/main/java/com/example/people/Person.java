package com.example.people;

import java.util.Date;
import java.util.Objects;

public class Person {

    private String name;

    private Date dateOfBirth;

    private Gender gender;

    public Person() {
    }

    public Person(String name, Date dateOfBirth, Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;

        return getName().equals(person.getName()) && getDateOfBirth().equals(person.getDateOfBirth()) && getGender().equals(person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, gender);
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + '}';
    }
}
