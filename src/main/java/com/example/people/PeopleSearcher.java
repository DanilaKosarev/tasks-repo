package com.example.people;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Stream;

public class PeopleSearcher {

    public static Collection<Person> search(Collection<Person> people, String name, int minAge, Gender gender, SortParam sortParam) {
        Stream<Person> result = people.stream().filter(p -> p.getName().contains(name)).filter(p -> p.getDateOfBirth().before(Date.from(ZonedDateTime.now().minusYears(minAge).toInstant()))).filter(p -> p.getGender().equals(gender));

        if(sortParam.equals(SortParam.NAME))
            return result.sorted(Comparator.comparing(Person::getName)).toList();
        else if(sortParam.equals(SortParam.AGE))
            return result.sorted(Comparator.comparing(Person::getDateOfBirth)).toList();
        return result.toList();
    }

    public static Collection<Person> search(Collection<Person> people, String name, int minAge, SortParam sortParam){
        Stream<Person> result =  people.stream().filter(p -> p.getName().contains(name)).filter(p -> p.getDateOfBirth().before(Date.from(ZonedDateTime.now().minusYears(minAge).toInstant())));

        if(sortParam.equals(SortParam.NAME))
            return result.sorted(Comparator.comparing(Person::getName)).toList();
        else if(sortParam.equals(SortParam.AGE))
            return result.sorted(Comparator.comparing(Person::getDateOfBirth)).toList();
        return result.toList();
    }

    public static Collection<Person> search(Collection<Person> people, String name, Gender gender, SortParam sortParam){
        Stream<Person> result =  people.stream().filter(p -> p.getName().contains(name)).filter(p -> p.getGender().equals(gender));

        if(sortParam.equals(SortParam.NAME))
            return result.sorted(Comparator.comparing(Person::getName)).toList();
        else if(sortParam.equals(SortParam.AGE))
            return result.sorted(Comparator.comparing(Person::getDateOfBirth)).toList();
        return result.toList();
    }

    public static Collection<Person> search(Collection<Person> people, int minAge, Gender gender, SortParam sortParam){
        Stream<Person> result =  people.stream().filter(p -> p.getDateOfBirth().before(Date.from(ZonedDateTime.now().minusYears(minAge).toInstant()))).filter(p -> p.getGender().equals(gender));

        if(sortParam.equals(SortParam.NAME))
            return result.sorted(Comparator.comparing(Person::getName)).toList();
        else if(sortParam.equals(SortParam.AGE))
            return result.sorted(Comparator.comparing(Person::getDateOfBirth)).toList();
        return result.toList();
    }

    public static Collection<Person> search(Collection<Person> people, String name, SortParam sortParam){
        Stream<Person> result =  people.stream().filter(p -> p.getName().contains(name));

        if(sortParam.equals(SortParam.NAME))
            return result.sorted(Comparator.comparing(Person::getName)).toList();
        else if(sortParam.equals(SortParam.AGE))
            return result.sorted(Comparator.comparing(Person::getDateOfBirth)).toList();
        return result.toList();
    }

    public static Collection<Person> search(Collection<Person> people, Gender gender, SortParam sortParam){
        Stream<Person> result =  people.stream().filter(p -> p.getGender().equals(gender));

        if(sortParam.equals(SortParam.NAME))
            return result.sorted(Comparator.comparing(Person::getName)).toList();
        else if(sortParam.equals(SortParam.AGE))
            return result.sorted(Comparator.comparing(Person::getDateOfBirth)).toList();
        return result.toList();
    }

    public static Collection<Person> search(Collection<Person> people, int minAge, SortParam sortParam){
        Stream<Person> result =  people.stream().filter(p -> p.getDateOfBirth().before(Date.from(ZonedDateTime.now().minusYears(minAge).toInstant())));

        if(sortParam.equals(SortParam.NAME))
            return result.sorted(Comparator.comparing(Person::getName)).toList();
        else if(sortParam.equals(SortParam.AGE))
            return result.sorted(Comparator.comparing(Person::getDateOfBirth)).toList();
        return result.toList();
    }
}
