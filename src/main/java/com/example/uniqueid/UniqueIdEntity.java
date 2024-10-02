package com.example.uniqueid;

public class UniqueIdEntity {

    private static int idSeq;

    private final int id;

    public UniqueIdEntity(){
        this.id = idSeq++;
    }

    public int getId() {
        return id;
    }
}
