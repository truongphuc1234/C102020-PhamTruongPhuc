package bai17_io_binary_file.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CopyNewIO {
    public static void main(String[] args) {
        String inputFile = "D:/anh.jpg";
        String outputFile = "D:/anh2.jpg";

        try{
            byte[] allBytes = Files.readAllBytes(Paths.get(inputFile));
            Files.write(Paths.get(outputFile),allBytes);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
