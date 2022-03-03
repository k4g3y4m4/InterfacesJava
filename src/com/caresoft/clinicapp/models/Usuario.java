package com.caresoft.clinicapp.models;

public class Usuario {
    protected Integer id;
    protected int pin;

    //constructor
    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, int pin) {
        this.id = id;
        this.pin = pin;
    }

    //getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

}
