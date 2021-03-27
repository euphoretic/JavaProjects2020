package com.company;
/*
Реализовать «синхронные» методы чтения/записи для переменной типа String.
Правила обращения следующие:
a.
Записывать в одно время может только один поток, любой следующий
«писатель» должен ждать (блокироваться).
b.
Если один поток выполняет запись, то любой читатель должен ждать
завершения этой записи.
c.
Пока происходит чтение, запись невозможна.
d.
Однако требуется избежать такой ситуации, когда запись невозможна из-
за сменяющих друг друга операций чтения.
e.
Любое количество читающих потоков могут читать одновременно
 */


public class Main {
    static final int READER_SIZE = 10;
    static final int WRITER_SIZE = 10;

    public static void main(String[] args) {
        String startString = "89 43 45 12 99 ";
        ReadWriteString sharedString = new ReadWriteString(startString);

        for (int i=0; i<WRITER_SIZE; i++){
            new Writer(sharedString).start();

        }
        for (int i=0; i<READER_SIZE; i++){
            new Reader(sharedString).start();
        }
    }
}
