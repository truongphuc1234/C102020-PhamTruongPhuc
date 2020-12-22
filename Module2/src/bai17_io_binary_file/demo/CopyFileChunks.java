package bai17_io_binary_file.demo;

import java.io.*;

public class CopyFileChunks {

    public static final int BUFFER_SIZE = 4096;
    public static void main(String[] args) {
        String inputFile = "D:\\anh.jpg";
        String outputFile = "D:\\anh2.jpg";

        try(InputStream inputStream = new BufferedInputStream(new FileInputStream(inputFile));
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile));
        ){
            byte[] buffer = new byte[BUFFER_SIZE];
            while(inputStream.read(buffer) != -1){
                outputStream.write(buffer);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
