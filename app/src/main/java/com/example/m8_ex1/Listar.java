package com.example.m8_ex1;

public class Listar {
    private String Id;
    private String nameIn;
    private String spinner;

    public Listar( String Id, String nameIn, String spinner) {
        this.Id = Id;
        this.nameIn = nameIn;
        this.spinner = spinner;
    }

    public void setId(String nameIn) {
        this.Id = Id;
    }

    public String getId() {
        return Id;
    }

    public void setNameIn(String nameIn) {
        this.nameIn = nameIn;
    }

    public String getNameIn() {
        return nameIn;
    }

    public void setSpinner(String spinner) {
        this.spinner = spinner;
    }

    public String getSpinner() {
        return spinner;
    }
}
