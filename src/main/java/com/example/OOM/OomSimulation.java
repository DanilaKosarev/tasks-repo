package com.example.OOM;

import java.util.*;

public class OomSimulation {

    static List<byte[]> list = new LinkedList<>();
    static int index = 1;

    private static HashMap<Object, Object> myMap = new HashMap<>();

    public static void main(String[] args){
        heapOverload();

        exceedsVmLimit();

        gcOverhead();
    }

    //1
    public static void heapOverload() {
        while (true) {
            byte[] b = new byte[10 * 1024 * 1024];
            list.add(b);
            Runtime rt = Runtime.getRuntime();
            System.out.printf("[%3s] Available heap memory: %s%n", index++, rt.freeMemory());
        }
    }

    //2
    public static void exceedsVmLimit(){
        long[][] ary = new long[Integer.MAX_VALUE][Integer.MAX_VALUE];
    }

    //3
    public static void gcOverhead() {

        long counter = 0;
        while (true) {

            if (counter % 1000 == 0) {

                System.out.println("Inserted 1000 Records to map");
            }

            myMap.put("key" + counter, "Large stringgggggggggggggggggggggggg" + counter);
            ++counter;
        }
    }
}
