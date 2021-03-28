package com.company;

import java.io.*;
import java.util.Properties;

public class Settings {
    public String name;
    public String statusLog;


    public Settings(String FileName, Properties props) throws IOException, Exception{
        getConfigFile(FileName, props);
        Settings.class.getResource("config.ini");
    }
    private static void getConfigFile(String FileName, Properties props) throws FileNotFoundException, IOException, Exception {
        InputStream fs;
        try {
            File f =new File(FileName);
            System.out.println(f.canRead()+" "+f.canWrite()+" "+f.getAbsolutePath());
            if (f.exists()){
                fs = new FileInputStream(f);
            } else {
                fs = Settings.class.getResourceAsStream(FileName);
            }
            props.load(fs);
            System.out.println("С возвращением," + props.getProperty("login"));
            fs.close();
        } catch (FileNotFoundException e) {
            System.err.println("Конфигурационный файл не найден. Ошибка - "+e.getMessage());
        } catch (IOException e){
            System.err.println("Конфигурационный файл не читается. Ошибка - "+e.getMessage());
        } catch (Exception e) {
            throw new Exception("Ошибка загрузки конфигурационного файла. Ошибка - "+e.getMessage());
        }
    }
}
