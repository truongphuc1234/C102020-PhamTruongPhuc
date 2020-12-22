package bai17_io_binary_file.bai_tap.ex_2_copy_file_nhi_phan;

import bai16_io_text_file.bai_tap.ex_1_copy_file_text.FileIsExist;

import java.io.*;

public class CopyFile {
    private static final String SOURCE_PATH = "product.data";
    private static final String DEST_PATH = "product2.data";

    public static void main(String[] args) {
        copyFile(SOURCE_PATH,DEST_PATH);
    }
    private static void copyFile(String sourcePath, String destinationPath){
        try{
            File sourceFile = new File(sourcePath);
            File destinationFile = new File(destinationPath);
            if(destinationFile.exists()){
                throw new FileIsExist();
            }
            InputStream inputStream = new FileInputStream(sourceFile);
            OutputStream outputStream = new FileOutputStream(destinationFile);
            byte[] buffer = new byte[1];
            int count=0;
            while(inputStream.read(buffer) > 0){
                outputStream.write(buffer);
                count++;
            }
            System.out.println(count);
        }
        catch (FileNotFoundException e) {
            System.err.println("Source file is not found! ");
        }
        catch (FileIsExist e){
            System.err.println("Destination file is exist!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
