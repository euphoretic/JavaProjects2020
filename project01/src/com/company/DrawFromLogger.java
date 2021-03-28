package com.company;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;


public class DrawFromLogger {
    public static ArrayList<Long> ArrayTime10 = new ArrayList<>();
    public static ArrayList<Long> ArrayTime100 = new ArrayList<>();
    public static ArrayList<Long> ArrayTime1000 = new ArrayList<>();
    public static ArrayList<Long> ArrayTime10000 = new ArrayList<>();
    public static ArrayList<Long> ArrayTime100000 = new ArrayList<>();

    public static ArrayList<String> ArrayTitleGraph = new ArrayList<>();

    public static ArrayList<Double> TAA = new ArrayList<>();
    public static ArrayList<Double> TAL = new ArrayList<>();
    public static ArrayList<Double> MAA = new ArrayList<>();
    public static ArrayList<Double> MAL = new ArrayList<>();
    public static ArrayList<Double> TRA = new ArrayList<>();
    public static ArrayList<Double> TRL = new ArrayList<>();
    public static ArrayList<Double> MRA = new ArrayList<>();
    public static ArrayList<Double> MRL = new ArrayList<>();

    public static void SetArrayTitleGraph(){
        ArrayTitleGraph.add("Общее время операции add");
        ArrayTitleGraph.add("Среднее время операции add");
        ArrayTitleGraph.add("Общее время операции remove");
        ArrayTitleGraph.add("Среднее время операции remove");
    }

    public static File file10 = new File("logger10.txt");
    public static File file100 = new File("logger100.txt");
    public static File file1000 = new File("logger1000.txt");
    public static File file10000 = new File("logger10000.txt");
    public static File file100000 = new File("logger100000.txt");

    public static ArrayList<Long> getArrayFromFile(File FileName){
        ArrayList<Long> Result = new ArrayList<>();
        String temp = "";
        String value = "";
        boolean start = false;

        try{
            FileReader fr = new FileReader(FileName);
            char a =(char) fr.read(); // Читаем один символ
            //Читаем
            BufferedReader br = new BufferedReader(new FileReader(FileName));

            while ((temp = br.readLine()) != "" & temp != null ) {
                if (temp.contains("total add в Array")) {
                    //Устанавливаем признак начала разбора строк
                    start = true;
                }
                else if (temp.length() == 0) {
                    start = false;
                }
                if(start) {
                    value = temp.substring(temp.indexOf('=')+2);
                    if (!value.isEmpty()) {
                        Result.add((Long.parseLong(value)));
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

    public static void SortArray() {
        TAA.add((double)ArrayTime10.get(0)/100.0);
        TAA.add((double)ArrayTime100.get(0)/100.0);
        TAA.add((double)ArrayTime1000.get(0)/100.0);
        TAA.add((double)ArrayTime10000.get(0)/100.0);
        TAA.add((double)ArrayTime100000.get(0)/100.0);

        TAL.add((double)ArrayTime10.get(1)/100.0);
        TAL.add((double)ArrayTime100.get(1)/100.0);
        TAL.add((double)ArrayTime1000.get(1)/100.0);
        TAL.add((double)ArrayTime10000.get(1)/100.0);
        TAL.add((double)ArrayTime100000.get(1)/100.0);

        MAA.add((double)ArrayTime10.get(2)/100.0);
        MAA.add((double)ArrayTime100.get(2)/100.0);
        MAA.add((double)ArrayTime1000.get(2)/100.0);
        MAA.add((double)ArrayTime10000.get(2)/100.0);
        MAA.add((double)ArrayTime100000.get(2)/100.0);

        MAL.add((double)ArrayTime10.get(3)/100.0);
        MAL.add((double)ArrayTime100.get(3)/100.0);
        MAL.add((double)ArrayTime1000.get(3)/100.0);
        MAL.add((double)ArrayTime10000.get(3)/100.0);
        MAL.add((double)ArrayTime100000.get(3)/100.0);

        TRA.add((double)ArrayTime10.get(4)/100.0);
        TRA.add((double)ArrayTime100.get(4)/100.0);
        TRA.add((double)ArrayTime1000.get(4)/100.0);
        TRA.add((double)ArrayTime10000.get(4)/100.0);
        TRA.add((double)ArrayTime100000.get(4)/100.0);

        TRL.add((double)ArrayTime10.get(5)/100.0);
        TRL.add((double)ArrayTime100.get(5)/100.0);
        TRL.add((double)ArrayTime1000.get(5)/100.0);
        TRL.add((double)ArrayTime10000.get(5)/100.0);
        TRL.add((double)ArrayTime100000.get(5)/100.0);

        MRA.add((double)ArrayTime10.get(6)/100.0);
        MRA.add((double)ArrayTime100.get(6)/100.0);
        MRA.add((double)ArrayTime1000.get(6)/100.0);
        MRA.add((double)ArrayTime10000.get(6)/100.0);
        MRA.add((double)ArrayTime100000.get(6)/100.0);

        MRL.add((double)ArrayTime10.get(7)/100.0);
        MRL.add((double)ArrayTime100.get(7)/100.0);
        MRL.add((double)ArrayTime1000.get(7)/100.0);
        MRL.add((double)ArrayTime10000.get(7)/100.0);
        MRL.add((double)ArrayTime100000.get(7)/100.0);
    }

    public static void main(String[] args) {
        SetArrayTitleGraph();
        ArrayTime10 = getArrayFromFile(file10);
        ArrayTime100 = getArrayFromFile(file100);
        ArrayTime1000 = getArrayFromFile(file1000);
        ArrayTime10000 = getArrayFromFile(file10000);
        ArrayTime100000 = getArrayFromFile(file100000);
        SortArray();

        EventQueue.invokeLater(() -> {
            GraphFrame frame = new GraphFrame(TAA, TAL);
            frame.setTitle(ArrayTitleGraph.get(0));
            //Определяем заголовок фрейма
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Определяем, что программа завершит работу при закрытии фрейма
            frame.setVisible(true);
            //Делаем фрейм видимым
        });
        EventQueue.invokeLater(() -> {
            GraphFrame frame = new GraphFrame(MAA, MAL);
            frame.setTitle(ArrayTitleGraph.get(1));
            //Определяем заголовок фрейма
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Определяем, что программа завершит работу при закрытии фрейма
            frame.setVisible(true);
            //Делаем фрейм видимым
        });
        EventQueue.invokeLater(() -> {
            GraphFrame frame = new GraphFrame(TRA, TRL);
            frame.setTitle(ArrayTitleGraph.get(2));
            //Определяем заголовок фрейма
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Определяем, что программа завершит работу при закрытии фрейма
            frame.setVisible(true);
            //Делаем фрейм видимым
        });
        EventQueue.invokeLater(() -> {
            GraphFrame frame = new GraphFrame(MRA, MRL);
            frame.setTitle(ArrayTitleGraph.get(3));
            //Определяем заголовок фрейма
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Определяем, что программа завершит работу при закрытии фрейма
            frame.setVisible(true);
            //Делаем фрейм видимым
        });
    }
}

class GraphFrame extends JFrame {
    public GraphFrame(ArrayList<Double>  DataArrayList, ArrayList<Double> DataLinkedList) {
        add(new GraphComponent(DataArrayList, DataLinkedList));
        pack(); //Устанавливаем размеры фрейма по размерам компонента(ов)
    }
}

class GraphComponent extends JComponent {
    private static final int W = 700;
    private static final int H = 500;
    ArrayList<Double> DataArrayList, DataLinkedList;
    double max = 0;

    public GraphComponent(ArrayList<Double> DataArrayList, ArrayList<Double> DataLinkedList){
        this.DataArrayList = DataArrayList;
        this.DataLinkedList = DataLinkedList;
    }
    public static double SetMaxInDataArrays(ArrayList<Double> DataArrayList, ArrayList<Double> DataLinkedList){
        double max = DataArrayList.get(0);
        if (DataArrayList.size() == DataLinkedList.size()) {
            for (Double aDouble : DataArrayList) {
                if (aDouble > max) {
                    max = aDouble;
                }
            }
            for (Double aDouble : DataLinkedList) {
                if (aDouble > max) {
                    max = aDouble;
                }
            }
        }
        return max;
    }

    public void paintComponent(Graphics g) {
        max = SetMaxInDataArrays(DataArrayList, DataLinkedList);
        int xStart = 20;
        int yStart = 20;
        int Width = 660;
        int Height = 450;
        int xNumberSteak = 5;
        int yNumberSteak = 11;
        int xCoordinateSteak = xStart*2;
        int yCoordinateSteak = Height+yStart;
        int xCoordinateString = 10;
        int yCoordinateString = 100;
        double prevYDataArrayList = 0;
        double prevYDataLinkedList = 0;

        double yMax;
        if (max>1) {
            yMax = (int) Math.ceil(max);
        } else {
            yMax = max;
        }

        // Создаем объект g2 для двумерного рисования из объекта g
        Graphics2D g2 = (Graphics2D) g;
        //Устанавливаем цвет, который будет применяться
        //для всего содержимого компонента: линий, текстов, заливки фигур
        g2.setColor(Color.BLACK);
        g2.drawString("На графике представлен пропорциональный масштаб по оси абсцисс 2^x:10^x", xStart+80,yStart);
        g2.drawLine(xStart, yStart, xStart, yStart+Height);
        g2.drawLine(xStart, yStart+Height, Width, yStart+Height);
        g2.drawString("Y", 5, 20);
        g2.drawString("X", Width, 470);
        for (int i=0; i<xNumberSteak; i++){
            g.drawLine(xCoordinateSteak, yStart+Height-5,xCoordinateSteak,yStart+Height);
            g.drawString(String.valueOf(xCoordinateString), xCoordinateSteak, yStart+Height+20) ;
            xCoordinateSteak *= 2;
            xCoordinateString *= 10;
        }
        xCoordinateSteak = xStart;
        for (int i=0; i<yNumberSteak; i++){
            g.drawLine(xStart, yCoordinateSteak,xStart+5,yCoordinateSteak);
            g.drawString(String.valueOf(yCoordinateString), 30,yCoordinateSteak ) ;
            yCoordinateSteak -= Math.round(Height / (yNumberSteak - 1));
            yCoordinateString += yMax / (yNumberSteak - 1);
        }
        for (int i=0; i<DataArrayList.size(); i++){
            g2.setColor(Color.GREEN);
            g.drawLine(xCoordinateSteak,
                    yStart+Height-(int)Math.round(prevYDataArrayList/(yMax /Height)),
                    xCoordinateSteak*2,
                    yStart+Height-(int)Math.round(DataArrayList.get(i)/(yMax/Height)));
            g2.setColor(Color.RED);
            g.drawLine(xCoordinateSteak,
                    yStart+Height-(int)Math.round(prevYDataLinkedList/(yMax/Height)),
                    xCoordinateSteak*2,
                    yStart+Height-(int)Math.round(DataLinkedList.get(i)/(yMax/Height)));
            prevYDataArrayList = DataArrayList.get(i);
            prevYDataLinkedList = DataLinkedList.get(i);
            xCoordinateSteak *= 2;
        }
    }
    public Dimension getPreferredSize() {
        return new Dimension(W, H);
    }

}





