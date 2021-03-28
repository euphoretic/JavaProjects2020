package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class InfraRedLightingCage extends Cage {
    public InfraRedLightingCage(int numberId){
        super(numberId,"InfraRedLightingCage");
        // Logger.post("INFO","Создан новый вольер с инфракрасным освещением");
    }

    @Override
    public void putAnimal(Animal animal) {
        if (animal.getCage() == "InfraRedLightingCage") {
            super.putAnimal(animal);
            // Logger.post("INFO","В вольер с инфракрасным освещением добавлено новое хладнокровное животное");
        } else {
            // Logger.post("ERROR","Попытка пометсить животное в неподходящий для него вольер");
        }
    }

    @Override
    public boolean getFromFile(String FileName) {
        boolean Result = false;
        String temp = "";
        String key = "";
        String value = "";
        boolean start = false;

        try{
            FileReader fr = new FileReader(FileName);
            char a =(char) fr.read(); // Читаем один символ
            //Читаем
            BufferedReader br = new BufferedReader(new FileReader(FileName));

            while ((temp = br.readLine()) != "" & temp != null) {
                if (temp.contains(this.getType()+"::")) {
                    //Устанавливаем признак начала разбора строк
                    start = true;
                }
                else if (temp.length() == 0) {
                    start = false;
                }
                if(start) {
                    key = temp.substring(0, temp.indexOf(':'));
                    value = temp.substring(temp.indexOf(':')+2, temp.length()-1);
                    if (!key.isEmpty() && !value.isEmpty()) {
                        switch (key) {
                            case "Number" -> this.setNumberId(Integer.parseInt(value));
                            case "Animal" -> {
                                String[] strArrParam = value.split(" ");
                                String[] numArr = Arrays.copyOfRange(strArrParam, 0, 2);
                                int[] numArrParam = Arrays.stream(numArr).mapToInt(Integer::parseInt).toArray();
                                //Конструктор TypeAnimal(int weight, int age, String cage)
                                //this.putAnimal(TypeAnimal(numArrParam[0], numArrParam[1], strArrParam[2]));
                                this.putAnimal(new CoolBlood(numArrParam[0], numArrParam[1], this.getType()));
                                Result = true;
                            }
                        }
                    }
                }
            }
            br.close();
        }
        catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
        return Result;
    }
}
