package com.company;

import java.util.concurrent.locks.*;

public class ReadWriteString {
    private String string="";
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public ReadWriteString(String startString) {string = startString;}

    public void add(String word) {
        Lock writeLock = rwLock.writeLock();
        writeLock.lock();

        try {
            //System.out.println(string);
            string = string + word; //добавляем в конец
        } finally {
            writeLock.unlock();
        }
    }

//    public String getFullString() {
//        Lock readLock = rwLock.readLock();
//        readLock.lock();
//
//        try {
//            return string;
//        } finally {
//            readLock.unlock();
//        }
//    }
    public String get( int indexStart) {
        Lock readLock = rwLock.readLock();
        readLock.lock();

        try {
            //System.out.println(string);
            return string;
        } finally {
            readLock.unlock();
        }
    }

    public int size() {
        Lock readLock = rwLock.readLock();
        readLock.lock();

        try {
            return string.length();
        } finally {
            readLock.unlock();
        }
    }
}
