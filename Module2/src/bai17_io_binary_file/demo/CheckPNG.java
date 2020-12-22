package bai17_io_binary_file.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CheckPNG {
    private static int[] pngSignature = {137, 80, 78, 71, 13, 10, 26, 10};

    public static void main(String[] args) {
        String inputFile = "D:\\anh.jpg";

        try (InputStream inputStream = new FileInputStream(inputFile);
        ) {
            int[] headerBytes = new int[8];
            boolean isPNG = true;
            for(int i = 0; i < 8; i++){
                headerBytes[i] = inputStream.read();
                if(headerBytes[i] != pngSignature[i]){
                    isPNG = false;
                    break;
                }
            }
            System.out.println("Is PNG file ? "+ isPNG);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
