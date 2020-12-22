package bai16_io_text_file.bai_tap.ex_2_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Country {
    public static void read(String filePath) {
        try {
            File file = new File(filePath);
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = null;
            String country = null;
            String[] lineArray;
            while ((line = bufferedReader.readLine()) != null) {
                lineArray = line.split(",");
                if(lineArray.length >0) {
                    country = lineArray[lineArray.length - 1];
                } else{
                    country = line;
                }
                System.out.println(country);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        read("D:\\contries.csv");
    }
}
