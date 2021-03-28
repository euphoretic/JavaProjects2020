package com.company;

public class Waterfowl extends Animal {

    public Waterfowl(int weight, int age, String cage) {
        super(weight, age, cage, "Waterfowl");
        // Logger.post("INFO", "В зоопарк добавлено новое водоплавающее животное");
    }

    @Override
    public void move(String cage) {
        super.move(cage);
    }
}
