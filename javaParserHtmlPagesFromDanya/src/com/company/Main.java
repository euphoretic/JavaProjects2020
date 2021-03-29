package com.company;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.net.URL;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /*Document doc = Jsoup.connect("https://yandex.ru/news").get();
        System.out.println(doc.title());
        String fullHtml = doc.html();
        System.out.println(fullHtml);
        /**
         * код для получения всех ссылок на сайте
         */
        /*
        Elements newsHeadlines = doc.select("a");
        for (Element headline : newsHeadlines) {
            System.out.println(headline.absUrl("href"));
        }
        */
        URL adr = new URL("https://yandex.ru/news");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(adr.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine); in.close();

    }
}
