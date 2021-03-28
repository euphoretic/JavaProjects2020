package com.company;

public class CoolBlood extends Animal {
    public CoolBlood(int weight, int age, String cage) {
        super(weight, age, cage, "CoolBlood");
        // Logger.post("INFO","В зоопарк добавлено новое хладнокровное животное");
    }

    @Override
    public void move(String cage) {
        super.move(cage);
    }
}
