package com.company;

public class Feathery extends Animal {
    public Feathery(int weight, int age, String cage) {
        super(weight, age, cage, "Feathery");
        // Logger.post("INFO","В зоопарк добавлено новое пернатое животное");
    }

    @Override
    public void move(String cage) {
        super.move(cage);
    }
}
