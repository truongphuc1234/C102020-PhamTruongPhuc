package bai17_io_binary_file.demo;

import java.io.*;

public class CopyFilesOne {
    public static void main(String[] args) {
        String inputFile = "D:/anh.jpg";
        String outputFile = "D:/anh2.jpg";

        try(InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);
            ){
            long fileSize = new File(inputFile).length();
            byte[] allByte = new byte[(int) fileSize];
            inputStream.read(allByte);
            outputStream.write(allByte);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
