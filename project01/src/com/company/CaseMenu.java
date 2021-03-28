package com.company;

import java.io.EOFException;
import java.util.Scanner;
/*
Вариант 6
1. Разработать иерархию из следующих классов, необходимых для реализации
модели зоопарка:
a. Вольеры 4 типов: аквариумы, вольеры покрытые сеткой,
открытые вольеры, вольеры с инфракрасным освещением.
b. Животные 4 типов: водоплавающие, пернатые, копытные, хладнокровные.

2. Для каждого из классов реализовать переопределенный метод Move()
абстрактного класса «Животное» (обладающего общими параметрами: вес,
возраст), который будет расселять животных в соответствующие вольеры.

3. Разработать программу для демонстрации описанных классов.
*/

public class CaseMenu {
    private final Scanner scanner;

    public CaseMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMenu() {
        System.out.println("Выберите пункт меню: ");
        System.out.println("1. Загрузить из файла зоопарк (клетки вместе с их животными)");
        System.out.println("2. Сохранить в файл измениния в зоопарке (только клетки с животными в них)");
        System.out.println("3. Создать новый вольер");
        System.out.println("4. Добавить новое животное");
        System.out.println("5. Поместить животное в вольер");
        System.out.println("6. Добавить новое животное вместе с вольером в зоопарк");
        System.out.println("10. Выход");
    }

    public void printCreateCageMenu() {
        System.out.println("Выберите тип вольера, который хотите создать в зоопарке: ");
        System.out.println("1. Аквариум");
        System.out.println("2. Вольер покрытый сеткой");
        System.out.println("3. Открытый вольер");
        System.out.println("4. Вольер с инфракрасным освещением");
        System.out.println("5. Назад");
    }

    public void printCreateAnimalMenu() {
        System.out.println("Выбирите тип животного, которое хотите добавить в зоопарк: ");
        System.out.println("1. Водоплавающее");
        System.out.println("2. Пернатое");
        System.out.println("3. Копытное");
        System.out.println("4. Хладнокровное");
        System.out.println("5. Назад");
    }

    public void createCageMenu() throws EOFException {
        if (this.scanner != null) {
            int key;
            printCreateCageMenu();
            key = this.scanner.nextInt();
            switch (key) {
                case 1 -> {
                    AquariumCage newAquariumCage = new AquariumCage(2);
                    System.out.println("Новый аквариум создан");
                }
                case 2 -> {
                    MeshCage newMeshCage = new MeshCage(2);
                    System.out.println("Новый вольер покрытый сеткой создан ");
                }
                case 3 -> {
                    OpenCage newOpenCage = new OpenCage(2);
                    System.out.println("Новый открытый вольер создан");
                }
                case 4 -> {
                    InfraRedLightingCage newInfraRedLightingCage = new InfraRedLightingCage(2);
                    System.out.println("Новый вольер с инфракрасным освещением создан");
                }
                case 5 -> start();
            }
            start();
        }
    }
    public void createAnimalMenu() throws EOFException {
        if (this.scanner != null) {
            int key;
            printCreateAnimalMenu();
            key = this.scanner.nextInt();
            switch (key) {
                case 1 -> {
                    System.out.print("Введите вес животного:");
                    int weight = this.scanner.nextInt();
                    System.out.print("Введите возраст животного:");
                    int age = this.scanner.nextInt();
                    Waterfowl newWaterfowl = new Waterfowl(weight, age, "Aquarium");
                    System.out.println("Новое водоплавоющее добавлено. Нужно поместить его в аквариум:");
                    System.out.println("1. Поместить в уже созданный");
                    System.out.println("2. Создать новый");
                    int choice = this.scanner.nextInt();
                    if (choice == 1) {
                        AquariumCage oneAquariumCage =  new AquariumCage(1);
                        boolean statusAquariumCage = oneAquariumCage.getFromFile("zoo.txt");
                        if (statusAquariumCage) {
                            System.out.println("Новое животное добавлено в вольер с водоплавающими");
                        } else {
                            System.out.println("Вольер с Водоплавающими не найден. Создаем новый...");
                            AquariumCage newAquariumCage = new AquariumCage(2);
                            System.out.println("Новый аквариум создан");
                        }

                    } else if (choice == 2) {
                        AquariumCage newAquariumCage = new AquariumCage(2);
                        System.out.println("Новый аквариум создан");
                    } else {
                        System.out.println("Выбран неверный пункт меню. Повторите выбор:");
                    }


                }
                case 2 -> {
                    MeshCage newMeshCage = new MeshCage(2);
                    System.out.println("Новый вольер покрытый сеткой создан ");
                }
                case 3 -> {
                    OpenCage newOpenCage = new OpenCage(2);
                    System.out.println("Новый открытый вольер создан");
                }
                case 4 -> {
                    InfraRedLightingCage newInfraRedLightingCage = new InfraRedLightingCage(2);
                    System.out.println("Новый вольер с инфракрасным освещением создан");
                }
                case 5 -> start();
            }
            start();
        }
    }
    public void start() throws EOFException {
        if (this.scanner != null) {
            int key;
            do {
                printMenu();
                OpenCage oneOpenCage = new OpenCage(1);
                InfraRedLightingCage oneInfraRedLightingCage = new InfraRedLightingCage(1);
                MeshCage oneMeshCage = new MeshCage(1);
                AquariumCage oneAquariumCage = new AquariumCage(1);
                key = this.scanner.nextInt();
                switch (key) {
                    case 1:

                        boolean statusOpenCage = oneOpenCage.getFromFile("zoo.txt");
                        if (statusOpenCage) {
                            System.out.println("Вольер с копытными найден");
                        } else {
                            System.out.println("Вольер с копытными не найден");
                        }

                        boolean statusInfraRedLightingCage = oneInfraRedLightingCage.getFromFile("zoo.txt");
                        if (statusInfraRedLightingCage) {
                            System.out.println("Вольер с хладнокровными найден");
                        } else {
                            System.out.println("Вольер с хладнокровными не найден");
                        }

                        boolean statusMeshCage = oneMeshCage.getFromFile("zoo.txt");
                        if (statusMeshCage) {
                            System.out.println("Вольер с пернатыми найден");
                        } else {
                            System.out.println("Вольер с пернатыми не найден");
                        }

                        boolean statusAquariumCage = oneAquariumCage.getFromFile("zoo.txt");
                        if (statusAquariumCage) {
                            System.out.println("Вольер с Водоплавающими найден");
                        } else {
                            System.out.println("Вольер с Водоплавающими не найден");
                        }
                        break;
                    case 2:
                        oneOpenCage.saveToFile("zoo.txt", true);
                        oneInfraRedLightingCage.saveToFile("zoo.txt", true);
                        oneMeshCage.saveToFile("zoo.txt", true);
                        oneAquariumCage.saveToFile("zoo.txt", true);
                        System.out.println("Изменения зоопарка сохраненны в файл");
                        break;
                    case 3:
                        createCageMenu();
                        break;
                    case 4:
                        createAnimalMenu();
                        break;
                    case 5:
                        break;
                    case 6:

                        break;
                    case 10:
                        System.out.println("Завершение программы...");
                        break;
                    default:
                        System.out.println("Введенно неверное значение менюю..\n");
                }
            } while (key !=10);
        }
    }
}

