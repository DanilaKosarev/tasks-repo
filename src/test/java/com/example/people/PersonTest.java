package com.example.people;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    private final Person testPerson = new Person(new String("Name"), Date.from(ZonedDateTime.now().minusYears(20).toInstant()), Gender.MALE);
    private final Person testPersonCopy = new Person(new String("Name"), Date.from(ZonedDateTime.now().minusYears(20).toInstant()), Gender.MALE);
    private final Person testPersonDifferentAllFields = new Person(new String("DifferentName"), Date.from(ZonedDateTime.now().minusYears(40).toInstant()), Gender.FEMALE);
    private final Person testPersonDifferentOneField = new Person(new String("Name"), Date.from(ZonedDateTime.now().minusYears(40).toInstant()), Gender.MALE);
    private final String notPersonClass = "objectOfDifferentClass";
    private final Person nullFieldsPerson = new Person(null, null, null);
    private final Person nullPerson = null;

    @Test
    void compareTwoEqualObjectsThenReturnTrue() {
        //when
        //then
        assertThat(testPerson.equals(testPersonCopy)).isEqualTo(true);
    }

    @Test
    void compareObjectWithItselfThenReturnTrue() {
        //when
        //then
        assertThat(testPerson.equals(testPerson)).isEqualTo(true);
    }

    @Test
    void compareTwoFullyUnequalObjectsThenReturnFalse() {
        //when
        //then
        assertThat(testPerson.equals(testPersonDifferentAllFields)).isEqualTo(false);
    }

    @Test
    void compareTwoPartiallyUnequalObjectsThenReturnFalse() {
        //when
        //then
        assertThat(testPerson.equals(testPersonDifferentOneField)).isEqualTo(false);
    }

    @Test
    void compareObjectWithDifferentClassObjectThenReturnFalse() {
        //when
        //then
        assertThat(testPerson.equals(notPersonClass)).isEqualTo(false);
    }

    @Test
    void compareObjectWithNullFieldsObjectThenReturnFalse() {
        //when
        //then
        assertThat(testPerson.equals(nullFieldsPerson)).isEqualTo(false);
    }

    @Test
    void compareObjectWithNullThenReturnFalse() {
        //when
        //then
        assertThat(testPerson.equals(nullPerson)).isEqualTo(false);
    }
}