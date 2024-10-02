package com.example.converters;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionsConverter {

    public static <I, O> Collection<O> convert(Collection<I> collectionToConvert, Function<I, O> convertFunction){
        return collectionToConvert.stream().map(convertFunction).collect(Collectors.toList());
    }
}
