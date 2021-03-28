package com.company;


import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Logger {
    public static void info(String info, long timeMass, File file) {
        LocalTime time = LocalTime.now();
        time.format(DateTimeFormatter.ofPattern("H:mm:ss"));

        try{
            if (file.createNewFile()) {System.out.println("Файл создан");}
            FileOutputStream fis = new FileOutputStream(file, true);
            OutputStreamWriter in = new OutputStreamWriter(fis);
            BufferedWriter input = new BufferedWriter(in);
            String lines = info + " = " + timeMass + "\n";
            input.write(lines);
            input.flush();
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void start(String login) {
        LocalTime time = LocalTime.now();
        time.format(DateTimeFormatter.ofPattern("H:mm:ss"));
        File file = new File("logger.txt");
        try {
            if (file.createNewFile()) {System.out.println("Файл создан!"); }
            FileOutputStream fis = new FileOutputStream(file, true);
            OutputStreamWriter in = new OutputStreamWriter(fis);
            BufferedWriter input = new BufferedWriter(in);
            String lines = "Запуск программы пользователем "+login+"\n";
            input.write(lines);
            input.flush();
            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void finish(String login) {
        LocalTime time = LocalTime.now();
        time.format(DateTimeFormatter.ofPattern("H:mm:ss"));
        File file = new File("logger.txt");
        try {
            if (file.createNewFile()) {System.out.println("Файл создан!"); }
            FileOutputStream fis = new FileOutputStream(file, true);
            OutputStreamWriter in = new OutputStreamWriter(fis);
            BufferedWriter input = new BufferedWriter(in);
            String lines = "Завершение программы пользователем "+login+"\n";
            input.write(lines);
            input.flush();
            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void post(String level, String message, File file) {
        LocalTime time = LocalTime.now();
        time.format(DateTimeFormatter.ofPattern("H:mm:ss"));
        try {
            if (file.createNewFile()) {System.out.println("Файл создан!"); }
            FileOutputStream fis = new FileOutputStream(file, true);
            OutputStreamWriter in = new OutputStreamWriter(fis);
            BufferedWriter input = new BufferedWriter(in);
            // String lines ="["+level+"]"+"["+time.getHour()+":"+time.getMinute()+":"+time.getSecond()+"]"+" message: "+message+"\n";
            String lines =message+"\n";
            input.write(lines);
            input.flush();
            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
