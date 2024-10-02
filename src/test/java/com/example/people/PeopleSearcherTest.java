package com.example.people;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import static com.example.people.PeopleSearcher.search;
import static org.assertj.core.api.Assertions.assertThat;

class PeopleSearcherTest {

    private final List<Person> people = List.of(
            new Person("Name1", Date.from(ZonedDateTime.now().minusYears(10).toInstant()), Gender.MALE),
            new Person("Name2", Date.from(ZonedDateTime.now().minusYears(20).toInstant()), Gender.MALE),
            new Person("Name3", Date.from(ZonedDateTime.now().minusYears(30).toInstant()), Gender.FEMALE),
            new Person("Name4", Date.from(ZonedDateTime.now().minusYears(40).toInstant()), Gender.FEMALE)
    );

    @Test
    void searchByAllFieldsThenGetOneResult() {
        //given
        String testName = "Name4";
        int testMinAge = 35;
        Gender testGender = Gender.FEMALE;

        //when
        List<Person> result = (List<Person>) search(people, testName, testMinAge, testGender, SortParam.DEFAULT);

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo(testName);
        assertThat(result.get(0).getDateOfBirth().toInstant()).isBefore(ZonedDateTime.now().minusYears(testMinAge).toInstant());
        assertThat(result.get(0).getGender()).isEqualTo(testGender);
    }

    @Test
    void searchByNameAndAgeThenGetOneResult() {
        //given
        String testName = "Name4";
        int testMinAge = 35;

        //when
        List<Person> result = (List<Person>) search(people, testName, testMinAge, SortParam.DEFAULT);

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo(testName);
        assertThat(result.get(0).getDateOfBirth().toInstant()).isBefore(ZonedDateTime.now().minusYears(testMinAge).toInstant());
    }

    @Test
    void searchByNameAndGenderThenGetOneResult() {
        //given
        String testName = "Name4";
        Gender testGender = Gender.FEMALE;

        //when
        List<Person> result = (List<Person>) search(people, testName, testGender, SortParam.DEFAULT);

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo(testName);
        assertThat(result.get(0).getGender()).isEqualTo(testGender);
    }

    @Test
    void searchByAgeAndGenderThenGetOneResult() {
        //given
        int testMinAge = 35;
        Gender testGender = Gender.FEMALE;

        //when
        List<Person> result = (List<Person>) search(people, testMinAge, testGender, SortParam.DEFAULT);

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getDateOfBirth().toInstant()).isBefore(ZonedDateTime.now().minusYears(testMinAge).toInstant());
        assertThat(result.get(0).getGender()).isEqualTo(testGender);
    }

    @Test
    void searchByNameThenGetOneResult() {
        //given
        String testName = "Name4";

        //when
        List<Person> result = (List<Person>) search(people, testName, SortParam.DEFAULT);

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo(testName);
    }

    @Test
    void searchByGenderThenGetTwoResults() {
        //given
        Gender testGender = Gender.MALE;

        //when
        List<Person> result = (List<Person>) search(people, testGender, SortParam.DEFAULT);

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getGender()).isEqualTo(testGender);
        assertThat(result.get(1).getGender()).isEqualTo(testGender);
    }

    @Test
    void searchByAgeThenGetThreeResults() {
        //given
        int testMinAge = 15;

        //when
        List<Person> result = (List<Person>) search(people, testMinAge, SortParam.DEFAULT);

        //then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0).getDateOfBirth().toInstant()).isBefore(ZonedDateTime.now().minusYears(testMinAge).toInstant());
        assertThat(result.get(1).getDateOfBirth().toInstant()).isBefore(ZonedDateTime.now().minusYears(testMinAge).toInstant());
        assertThat(result.get(2).getDateOfBirth().toInstant()).isBefore(ZonedDateTime.now().minusYears(testMinAge).toInstant());
    }
}