package com.company;

import java.io.*;
import java.util.*;

public class Cage {
    private int numberId;
    private String type;
    ArrayList<Animal> animalInCage = new ArrayList<>();
    public static LinkedList<Animal> LinkedAnimalList10 = new LinkedList<>();
    public static ArrayList<Animal> ArrayAnimalList10 = new ArrayList<>();
    public static LinkedList<Animal> LinkedAnimalList100 = new LinkedList<>();
    public static ArrayList<Animal> ArrayAnimalList100 = new ArrayList<>();
    public static LinkedList<Animal> LinkedAnimalList1000 = new LinkedList<>();
    public static ArrayList<Animal> ArrayAnimalList1000 = new ArrayList<>();
    public static LinkedList<Animal> LinkedAnimalList10000 = new LinkedList<>();
    public static ArrayList<Animal> ArrayAnimalList10000 = new ArrayList<>();
    public static LinkedList<Animal> LinkedAnimalList100000 = new LinkedList<>();
    public static ArrayList<Animal> ArrayAnimalList100000 = new ArrayList<>();

    public static Logger log = new Logger();
    public static long totalTimeAddArray = 0;
    public static long medialTimeAddArray = 0;
    public static long totalTimeRemoveArray = 0;
    public static long medialTimeRemoveArray = 0;
    public static long totalTimeAddLinked = 0;
    public static long medialTimeAddLinked = 0;
    public static long totalTimeRemoveLinked = 0;
    public static long medialTimeRemoveLinked = 0;

    public static File file10 = new File("logger10.txt");
    public static File file100 = new File("logger100.txt");
    public static File file1000 = new File("logger1000.txt");
    public static File file10000 = new File("logger10000.txt");
    public static File file100000 = new File("logger100000.txt");


    public static Random random = new Random();

    public Cage(int numberId, String type){
        this.numberId = numberId;
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() { return type; }

    public void setNumberId(int numberId){
        this.numberId = numberId;
    }

    public int getNumberId(){
        return numberId;
    }

    public int getCageAmount() {
        return this.animalInCage.size();
    }

    public void putAnimal(Animal animal) {
        this.animalInCage.add(animal);
    }

    public void printAnimal(){
        for(Animal name : animalInCage){
            System.out.println(name.getWeight()+" "+name.getAge()+" "+name.getCage()+" "+name.getType());
        }

    }

    public boolean saveToFile(String FileName, boolean Update) throws
            java.io.EOFException {
        boolean Result = false;
        FileWriter dataOut = null;

        try{
            dataOut = new FileWriter(FileName, Update);
            dataOut.append(this.toString());
            Result = true;
        }
        catch (IOException exc) {
            System.err.println(exc.getMessage());
        }
        finally {
            try {
                dataOut.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return Result;
    }

    public boolean getFromFile(String FileName) {
        return true;
    }

    public String toString(){
        String Result = this.getType()+"::;\r\n";
        Result += "Number: "+this.getNumberId()+";\r\n";
        Result += "Animals amount:"+this.getCageAmount()+";\r\n";
        for (Animal element : this.animalInCage) {
            Result += "Animal: "+element.getWeight()+" "+element.getAge()+" "+element.getType()+";\r\n";
        }
        return Result;
    }

    public static void addSomeAnimalInArray(int count){
        switch (count) {
            case 10 -> {log.post("INFO", "array add:", file10);}
            case 100 -> {log.post("INFO", "array add:", file100);}
            case 1000 -> {log.post("INFO", "array add:", file1000);}
            case 10000 -> {log.post("INFO", "array add:", file10000);}
            case 100000 -> {log.post("INFO", "array add:", file100000);}
        }
        for (int i=0; i<count; i++){
            int key = random.nextInt(4);
            Animal newAnimal;
            long timeBefore = System.nanoTime();
            long timeAfter = System.nanoTime();
            switch (key) {
                case 0 -> {
                    int weight = random.nextInt(10) + 1;
                    int age = random.nextInt(13) + 1;
                    newAnimal = new CoolBlood(weight, age, "InfraRedLightingCage");
                }
                case 1 -> {
                    int weight = random.nextInt(400) + 1;
                    int age = random.nextInt(20) + 1;
                    newAnimal = new Ungulate(weight, age, "OpenCage");
                }
                case 2 -> {
                    int weight = random.nextInt(7) + 1;
                    int age = random.nextInt(30) + 1;
                    newAnimal = new Feathery(weight, age, "MeshCage");
                }
                case 3 -> {
                    int weight = random.nextInt(10) + 1;
                    int age = random.nextInt(13) + 1;
                    newAnimal = new Waterfowl(weight, age, "AquariumCage");
                }
                default -> throw new IllegalStateException("Unexpected value: " + key);
            }
            switch (count){
                case 10 -> {
                    timeBefore = System.nanoTime();
                    ArrayAnimalList10.add(newAnimal);
                    timeAfter = System.nanoTime();
                    String message = "id: "+i+" Array time add:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file10);
                }
                case 100 -> {
                    timeBefore = System.nanoTime();
                    ArrayAnimalList100.add(newAnimal);
                    timeAfter = System.nanoTime();
                    String message = "id: "+i+" Array time add:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file100);
                }
                case 1000 -> {
                    timeBefore = System.nanoTime();
                    ArrayAnimalList1000.add(newAnimal);
                    timeAfter = System.nanoTime();
                    String message = "id: "+i+" Array time add:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file1000);
                }
                case  10000 -> {
                    timeBefore = System.nanoTime();
                    ArrayAnimalList10000.add(newAnimal);
                    timeAfter = System.nanoTime();
                    String message = "id: "+i+" Array time add:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file10000);
                }
                case  100000 -> {
                    timeBefore = System.nanoTime();
                    ArrayAnimalList100000.add(newAnimal);
                    timeAfter = System.nanoTime();
                    String message = "id: "+i+" Array time add:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file100000);
                }
                default -> throw new IllegalStateException("Unexpected value: " + key);
            }
                totalTimeAddArray += timeAfter -timeBefore;
        }
        medialTimeAddArray = totalTimeAddArray/count;
    }

    public static void removeAnimalArray(int count){
        int numDeleted = 0;
        switch (count) {
            case 10 -> {log.post("INFO", "array remove:", file10);}
            case 100 -> {log.post("INFO", "array remove:", file100);}
            case 1000 -> {log.post("INFO", "array remove:", file1000);}
            case 10000 -> {log.post("INFO", "array remove:", file10000);}
            case 100000 -> {log.post("INFO", "array remove:", file100000);}
        }
        int period = count / 10;
        for (int i=0; i<period; i++) {
            long timeBefore = System.nanoTime();
            long timeAfter = System.nanoTime();
            int key = random.nextInt(count-numDeleted);
            switch (count){
                case 10 -> {
                    timeBefore = System.nanoTime();
                    ArrayAnimalList10.remove(key);
                    timeAfter = System.nanoTime();
                    String message = "id: "+key+" Array time remove:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file10);
                    numDeleted+=1;
                }
                case 100 -> {
                    timeBefore = System.nanoTime();
                    ArrayAnimalList100.remove(key);
                    timeAfter = System.nanoTime();
                    String message = "id: "+key+" Array time remove:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file100);
                    numDeleted+=1;
                }
                case 1000 -> {
                    timeBefore = System.nanoTime();
                    ArrayAnimalList1000.remove(key);
                    timeAfter = System.nanoTime();
                    String message = "id: "+key+" Array time remove:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file1000);
                    numDeleted+=1;
                }
                case  10000 -> {
                    timeBefore = System.nanoTime();
                    ArrayAnimalList10000.remove(key);
                    timeAfter = System.nanoTime();
                    String message = "id: "+key+" Array time remove:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file10000);
                    numDeleted+=1;
                }
                case  100000 -> {
                    timeBefore = System.nanoTime();
                    ArrayAnimalList100000.remove(key);
                    timeAfter = System.nanoTime();
                    String message = "id: "+key+" Array time remove:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file100000);
                    numDeleted+=1;
                }
                default -> throw new IllegalStateException("Unexpected value: " + key);
            }
            totalTimeRemoveArray += timeAfter -timeBefore;
        }
        medialTimeRemoveArray = totalTimeRemoveArray/period;
    }

    public static void addSomeAnimalInLinked(int count){
        switch (count) {
            case 10 -> {log.post("INFO", "linked add:", file10);}
            case 100 -> {log.post("INFO", "linked add:", file100);}
            case 1000 -> {log.post("INFO", "linked add:", file1000);}
            case 10000 -> {log.post("INFO", "linked add:", file10000);}
            case 100000 -> {log.post("INFO", "linked add:", file100000);}
        }
        for (int i=0; i<count; i++){
            int key = random.nextInt(4);
            Animal newAnimal;
            long timeBefore = System.nanoTime();
            long timeAfter = System.nanoTime();
            switch (key) {
                case 0 -> {
                    int weight = random.nextInt(10) + 1;
                    int age = random.nextInt(13) + 1;
                    newAnimal = new CoolBlood(weight, age, "InfraRedLightingCage");
                }
                case 1 -> {
                    int weight = random.nextInt(400) + 1;
                    int age = random.nextInt(20) + 1;
                    newAnimal = new Ungulate(weight, age, "OpenCage");
                }
                case 2 -> {
                    int weight = random.nextInt(7) + 1;
                    int age = random.nextInt(30) + 1;
                    newAnimal = new Feathery(weight, age, "MeshCage");
                }
                case 3 -> {
                    int weight = random.nextInt(10) + 1;
                    int age = random.nextInt(13) + 1;
                    newAnimal = new Waterfowl(weight, age, "AquariumCage");
                }
                default -> throw new IllegalStateException("Unexpected value: " + key);
            }
            switch (count){
                case 10 -> {
                    timeBefore = System.nanoTime();
                    LinkedAnimalList10.add(newAnimal);
                    timeAfter = System.nanoTime();
                    String message = "id: "+i+" Linked time add:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file10);
                }
                case 100 -> {
                    timeBefore = System.nanoTime();
                    LinkedAnimalList100.add(newAnimal);
                    timeAfter = System.nanoTime();
                    String message = "id: "+i+" Linked time add:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file100);
                }
                case 1000 -> {
                    timeBefore = System.nanoTime();
                    LinkedAnimalList1000.add(newAnimal);
                    timeAfter = System.nanoTime();
                    String message = "id: "+i+" Linked time add:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file1000);
                }
                case  10000 -> {
                    timeBefore = System.nanoTime();
                    LinkedAnimalList10000.add(newAnimal);
                    timeAfter = System.nanoTime();
                    String message = "id: "+i+" Linked time add:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file10000);
                }
                case  100000 -> {
                    timeBefore = System.nanoTime();
                    LinkedAnimalList100000.add(newAnimal);
                    timeAfter = System.nanoTime();
                    String message = "id: "+i+" Linked time add:" + (timeAfter - timeBefore);
                    log.post("INFO", message, file100000);
                }
                default -> throw new IllegalStateException("Unexpected value: " + key);
            }
            totalTimeAddLinked += timeAfter -timeBefore;
        }
        medialTimeAddLinked = totalTimeAddLinked/count;
    }

    public static void removeAnimalLinked(int count){
        int numDeleted = 0;
        switch (count) {
            case 10 -> {log.post("INFO", "linked remove:", file10);}
            case 100 -> {log.post("INFO", "linked remove:", file100);}
            case 1000 -> {log.post("INFO", "linked remove:", file1000);}
            case 10000 -> {log.post("INFO", "linked remove:", file10000);}
            case 100000 -> {log.post("INFO", "linked remove:", file100000);}
        }
        int period = count / 10;
        for (int i=0; i<period; i++) {
            int key = random.nextInt(count-numDeleted) ;
            long timeBefore;
            long timeAfter;
            switch (count){
                case 10 -> {
                    timeBefore = System.nanoTime();
                    LinkedAnimalList10.remove(key);
                    timeAfter = System.nanoTime();
                    String message = "id: "+key+" Linked time remove:"+(timeAfter - timeBefore);
                    log.post("INFO", message, file10);
                    numDeleted+=1;
                }
                case 100 -> {
                    timeBefore = System.nanoTime();
                    LinkedAnimalList100.remove(key);
                    timeAfter = System.nanoTime();
                    String message = "id: "+key+" Linked time remove:"+(timeAfter - timeBefore);
                    log.post("INFO", message, file100);
                    numDeleted+=1;
                }
                case 1000 -> {
                    timeBefore = System.nanoTime();
                    LinkedAnimalList1000.remove(key);
                    timeAfter = System.nanoTime();
                    String message = "id: "+key+" Linked time remove:"+(timeAfter - timeBefore);
                    log.post("INFO", message, file1000);
                    numDeleted+=1;
                }
                case  10000 -> {
                    timeBefore = System.nanoTime();
                    LinkedAnimalList10000.remove(key);
                    timeAfter = System.nanoTime();
                    String message = "id: "+key+" Linked time remove:"+(timeAfter - timeBefore);
                    log.post("INFO", message, file10000);
                    numDeleted+=1;
                }
                case  100000 -> {
                    timeBefore = System.nanoTime();
                    LinkedAnimalList100000.remove(key);
                    timeAfter = System.nanoTime();
                    String message = "id: "+key+" Linked time remove:"+(timeAfter - timeBefore);
                    log.post("INFO", message, file100000);
                    numDeleted+=1;
                }
                default -> throw new IllegalStateException("Unexpected value: " + key);
            }
            totalTimeRemoveLinked += timeAfter -timeBefore;
        }
        medialTimeRemoveLinked = totalTimeRemoveLinked/period;
    }

}

