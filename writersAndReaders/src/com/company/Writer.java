package com.company;

import java.util.Random;
/**
 * Writer.java
 * Этот поток записыает случайное число в общую строку данных
 */
public class Writer extends Thread {
    private ReadWriteString sharedString;

    public Writer(ReadWriteString sharedString){ this.sharedString = sharedString; }

    public void run(){
        Random random = new Random();
        int number = random.nextInt(20);

        //System.out.println(sharedString.getFullString());
        sharedString.add(number + " ");


        try {
            Thread.sleep(1);
            System.out.println(getName() + " add: " + number);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
