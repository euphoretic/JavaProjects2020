package com.company;

import java.util.*;

/**
 * Reader.java
 * Этот поток читает случайный элемент в строке, разделенный пробелами
 */
public class Reader extends Thread {
    private ReadWriteString sharedString;

    public Reader(ReadWriteString sharedList) {
        this.sharedString = sharedList;
    }

    public void run() {
        Random random = new Random();
        int indexStart = random.nextInt(sharedString.size())-2;
        // int indexEnd = random.nextInt(sharedList.size()-indexStart)+indexStart;

        //String number = sharedList.get(indexStart, indexEnd);
        String number = sharedString.get(indexStart);

        System.out.println(getName() + " -> get: " + number);
        //System.out.println(sharedString.getFullString());

        try {
            Thread.sleep(10);
        } catch (InterruptedException ie ) { ie.printStackTrace(); }
    }
}
