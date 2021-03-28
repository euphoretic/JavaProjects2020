package com.company;

public abstract class Animal {
    private int weight;
    private int age;
    private String cage;
    private String type;


    public Animal(int weight, int age, String cage, String type){
        this.weight = weight;
        this.age = age;
        this.cage = cage;
        this.type = type;
    }

    public String  getType(){ return  type; }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getCage() {
        return cage;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void move(String cage) {
                this.cage = cage;
    }

    public void setAge(int age) {
        this.age = age;
    }


}


