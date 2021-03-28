package com.company;

public class Ungulate extends Animal {
    public Ungulate(int weight, int age, String cage){
        super(weight, age, cage, "Ungulate");
        // Logger.post("INFO","В зоопарк добавлено новое копытное животное");
    }

    @Override
    public void move(String cage) {
        super.move(cage);
    }
}
