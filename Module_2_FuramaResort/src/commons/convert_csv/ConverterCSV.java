package commons.convert_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConverterCSV<E> {
    private static final String NEW_LINE_SEPARATOR = "\n";

    private FormatCSV<E> format;

    public ConverterCSV(FormatCSV<E> format) {
        this.format = format;
    }

    public List<E> readFileToList(String filePath) {
        ArrayList<E> list = new ArrayList<>();
        try {
            File file = new File(filePath);
            if(!file.exists()){
                return list;
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            if ((bufferedReader.readLine()) == null) {
                System.out.println("No data in file!");
                return list;
            }
            String line;
            E element;
            while ((line = bufferedReader.readLine()) != null) {
                element = format.getObjectByStringCSV(line);
                list.add(element);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeListToCSVFile(List<E> list, String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            if (file.length() == 0) {
                fileWriter.write(format.getHeader());
            }
            for (E element : list) {
                fileWriter.write(NEW_LINE_SEPARATOR);
                fileWriter.write(format.convertToStringCSV(element));
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

