package com.company;


import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.io.EOFException;


public class Main {
    public static Properties prop;

    public static void main(String[] args)  {
        try {
            prop = new Properties();
            Settings Set = new Settings("config.ini", prop);

            //берем из файла config.ini значения по ключу
            boolean statusLog = Boolean.parseBoolean(prop.getProperty("logger"));
            String login = prop.getProperty("login");
            System.out.println("Статус логов: "+statusLog);

            if (statusLog) { Logger.start(login); }







            /*
             lab 3

             new CaseMenu(new Scanner(System.in)).start();
             */



            File file10 = new File("logger10.txt");
            File file100 = new File("logger100.txt");
            File file1000 = new File("logger1000.txt");
            File file10000 = new File("logger10000.txt");
            File file100000 = new File("logger100000.txt");

            Cage.addSomeAnimalInArray(10);
            long totalTimeAddArray10 =Cage.totalTimeAddArray;
            long medialTimeAddArray10 = Cage.medialTimeAddArray;
            Cage.removeAnimalArray(10);
            long totalTimeRemoveArray10 =Cage.totalTimeRemoveArray;
            long medialTimeRemoveArray10 = Cage.medialTimeRemoveArray;
            Cage.ArrayAnimalList10.clear();
            Cage.totalTimeAddArray = 0;
            Cage.medialTimeAddArray = 0;
            Cage.totalTimeRemoveArray = 0;
            Cage.medialTimeRemoveArray = 0;

            Cage.addSomeAnimalInLinked(10);
            long totalTimeAddLinked10 =Cage.totalTimeAddLinked;
            long medialTimeAddLinked10 = Cage.medialTimeAddLinked;
            Cage.removeAnimalLinked(10);
            long totalTimeRemoveLinked10 =Cage.totalTimeRemoveLinked;
            long medialTimeRemoveLinked10 = Cage.medialTimeRemoveLinked;
            Cage.LinkedAnimalList10.clear();
            Cage.totalTimeAddLinked = 0;
            Cage.medialTimeAddLinked = 0;
            Cage.totalTimeRemoveLinked = 0;
            Cage.medialTimeRemoveLinked = 0;


            Cage.addSomeAnimalInArray(100);
            long totalTimeAddArray100 =Cage.totalTimeAddArray;
            long medialTimeAddArray100 = Cage.medialTimeAddArray;
            Cage.removeAnimalArray(100);
            long totalTimeRemoveArray100 =Cage.totalTimeRemoveArray;
            long medialTimeRemoveArray100 = Cage.medialTimeRemoveArray;
            Cage.ArrayAnimalList100.clear();
            Cage.totalTimeAddArray = 0;
            Cage.medialTimeAddArray = 0;
            Cage.totalTimeRemoveArray = 0;
            Cage.medialTimeRemoveArray = 0;

            Cage.addSomeAnimalInLinked(100);
            long totalTimeAddLinked100 =Cage.totalTimeAddLinked;
            long medialTimeAddLinked100 = Cage.medialTimeAddLinked;
            Cage.removeAnimalLinked(100);
            long totalTimeRemoveLinked100 =Cage.totalTimeRemoveLinked;
            long medialTimeRemoveLinked100 = Cage.medialTimeRemoveLinked;
            Cage.LinkedAnimalList100.clear();
            Cage.totalTimeAddLinked = 0;
            Cage.medialTimeAddLinked = 0;
            Cage.totalTimeRemoveLinked = 0;
            Cage.medialTimeRemoveLinked = 0;


            Cage.addSomeAnimalInArray(1000);
            long totalTimeAddArray1000 =Cage.totalTimeAddArray;
            long medialTimeAddArray1000 = Cage.medialTimeAddArray;
            Cage.removeAnimalArray(1000);
            long totalTimeRemoveArray1000 =Cage.totalTimeRemoveArray;
            long medialTimeRemoveArray1000 = Cage.medialTimeRemoveArray;
            Cage.ArrayAnimalList1000.clear();
            Cage.totalTimeAddLinked = 0;
            Cage.medialTimeAddLinked = 0;
            Cage.totalTimeRemoveLinked = 0;
            Cage.medialTimeRemoveLinked = 0;


            Cage.addSomeAnimalInLinked(1000);
            long totalTimeAddLinked1000 =Cage.totalTimeAddLinked;
            long medialTimeAddLinked1000 = Cage.medialTimeAddLinked;
            Cage.removeAnimalLinked(1000);
            long totalTimeRemoveLinked1000 =Cage.totalTimeRemoveLinked;
            long medialTimeRemoveLinked1000 = Cage.medialTimeRemoveLinked;
            Cage.LinkedAnimalList1000.clear();
            Cage.totalTimeAddLinked = 0;
            Cage.medialTimeAddLinked = 0;
            Cage.totalTimeRemoveLinked = 0;
            Cage.medialTimeRemoveLinked = 0;

            Cage.addSomeAnimalInArray(10000);
            long totalTimeAddArray10000 =Cage.totalTimeAddArray;
            long medialTimeAddArray10000 = Cage.medialTimeAddArray;
            Cage.removeAnimalArray(10000);
            long totalTimeRemoveArray10000 =Cage.totalTimeRemoveArray;
            long medialTimeRemoveArray10000 = Cage.medialTimeRemoveArray;
            Cage.ArrayAnimalList10000.clear();
            Cage.totalTimeAddLinked = 0;
            Cage.medialTimeAddLinked = 0;
            Cage.totalTimeRemoveLinked = 0;
            Cage.medialTimeRemoveLinked = 0;

            Cage.addSomeAnimalInLinked(10000);
            long totalTimeAddLinked10000 =Cage.totalTimeAddLinked;
            long medialTimeAddLinked10000 = Cage.medialTimeAddLinked;
            Cage.removeAnimalLinked(10000);
            long totalTimeRemoveLinked10000 =Cage.totalTimeRemoveLinked;
            long medialTimeRemoveLinked10000 = Cage.medialTimeRemoveLinked;
            Cage.LinkedAnimalList10000.clear();
            Cage.totalTimeAddLinked = 0;
            Cage.medialTimeAddLinked = 0;
            Cage.totalTimeRemoveLinked = 0;
            Cage.medialTimeRemoveLinked = 0;

            Cage.addSomeAnimalInArray(100000);
            long totalTimeAddArray100000 =Cage.totalTimeAddArray;
            long medialTimeAddArray100000 = Cage.medialTimeAddArray;
            Cage.removeAnimalArray(100000);
            long totalTimeRemoveArray100000 =Cage.totalTimeRemoveArray;
            long medialTimeRemoveArray100000 = Cage.medialTimeRemoveArray;
            Cage.ArrayAnimalList100000.clear();
            Cage.totalTimeAddLinked = 0;
            Cage.medialTimeAddLinked = 0;
            Cage.totalTimeRemoveLinked = 0;
            Cage.medialTimeRemoveLinked = 0;

            Cage.addSomeAnimalInLinked(100000);
            long totalTimeAddLinked100000 =Cage.totalTimeAddLinked;
            long medialTimeAddLinked100000 = Cage.medialTimeAddLinked;
            Cage.removeAnimalLinked(100000);
            long totalTimeRemoveLinked100000 =Cage.totalTimeRemoveLinked;
            long medialTimeRemoveLinked100000 = Cage.medialTimeRemoveLinked;
            Cage.LinkedAnimalList10000.clear();
            Cage.totalTimeAddLinked = 0;
            Cage.medialTimeAddLinked = 0;
            Cage.totalTimeRemoveLinked = 0;
            Cage.medialTimeRemoveLinked = 0;

            Logger.post("10", "Для 10 элементов:", file10);
            Logger.info("total add в Array", totalTimeAddArray10, file10);
            Logger.info("total add в Linked", totalTimeAddLinked10, file10);
            Logger.info("medial add в Array", medialTimeAddArray10, file10);
            Logger.info("medial add в Linked", medialTimeAddLinked10, file10);
            Logger.info("total remove в Array", totalTimeRemoveArray10, file10);
            Logger.info("total remove в Linked", totalTimeRemoveLinked10, file10);
            Logger.info("medial remove в Array", medialTimeRemoveArray10, file10);
            Logger.info("medial remove в Linked", medialTimeRemoveLinked10, file10);

            Logger.post("100", "Для 100 элементов:", file100);
            Logger.info("total add в Array", totalTimeAddArray100, file100);
            Logger.info("total add в Linked", totalTimeAddLinked100, file100);
            Logger.info("medial add в Array", medialTimeAddArray100, file100);
            Logger.info("medial add в Linked", medialTimeAddLinked100, file100);
            Logger.info("total remove в Array", totalTimeRemoveArray100, file100);
            Logger.info("total remove в Linked", totalTimeRemoveLinked100, file100);
            Logger.info("medial remove в Array", medialTimeRemoveArray100, file100);
            Logger.info("medial remove в Linked", medialTimeRemoveLinked100, file100);

            Logger.post("1000", "Для 1000 элементов:", file1000);
            Logger.info("total add в Array", totalTimeAddArray1000, file1000);
            Logger.info("total add в Linked", totalTimeAddLinked1000, file1000);
            Logger.info("medial add в Array", medialTimeAddArray1000, file1000);
            Logger.info("medial add в Linked", medialTimeAddLinked1000, file1000);
            Logger.info("total remove в Array", totalTimeRemoveArray1000, file1000);
            Logger.info("total remove в Linked", totalTimeRemoveLinked1000, file1000);
            Logger.info("medial remove в Array", medialTimeRemoveArray1000, file1000);
            Logger.info("medial remove в Linked", medialTimeRemoveLinked1000, file1000);

            Logger.post("10000", "Для 10000 элементов:", file10000);
            Logger.info("total add в Array", totalTimeAddArray10000, file10000);
            Logger.info("total add в Linked", totalTimeAddLinked10000, file10000);
            Logger.info("medial add в Array", medialTimeAddArray10000, file10000);
            Logger.info("medial add в Linked", medialTimeAddLinked10000, file10000);
            Logger.info("total remove в Array", totalTimeRemoveArray10000, file10000);
            Logger.info("total remove в Linked", totalTimeRemoveLinked10000, file10000);
            Logger.info("medial remove в Array", medialTimeRemoveArray10000, file10000);
            Logger.info("medial remove в Linked", medialTimeRemoveLinked10000, file10000);

            Logger.post("100000", "Для 100000 элементов:", file100000);
            Logger.info("total add в Array", totalTimeAddArray100000, file100000);
            Logger.info("total add в Linked", totalTimeAddLinked100000, file100000);
            Logger.info("medial add в Array", medialTimeAddArray100000, file100000);
            Logger.info("medial add в Linked", medialTimeAddLinked100000, file100000);
            Logger.info("total remove в Array", totalTimeRemoveArray100000, file100000);
            Logger.info("total remove в Linked", totalTimeRemoveLinked100000, file100000);
            Logger.info("medial remove в Array", medialTimeRemoveArray100000, file100000);
            Logger.info("medial remove в Linked", medialTimeRemoveLinked100000, file100000);


            if (statusLog){ Logger.finish(login); }

        } catch (Exception e) {
            System.err.println("Ошибка - "+e.getMessage());
        }

    }

    }
