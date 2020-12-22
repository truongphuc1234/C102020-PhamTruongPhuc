package bai16_io_text_file.bai_tap.ex_1_copy_file_text;

import java.io.*;
import java.util.Scanner;

public class FileCopy {
    public static void copyfile(String sourcePath, String destinationPath){
        try {
            File sourceFile = new File(sourcePath);
            if(!sourceFile.exists()){
                throw new FileNotFoundException();
            }

            File destinationFile = new File(destinationPath);
            if(destinationFile.exists()){
                throw new FileIsExist();
            }

            FileReader fileReader = new FileReader(sourceFile);
            FileWriter fileWriter = new FileWriter(destinationFile);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int charInt = 0;
            int count = 0;
            while((charInt =bufferedReader.read()) != -1){
                count++;
                fileWriter.append((char) charInt);
            }
            fileReader.close();
            fileWriter.close();

            System.out.println(count);
        } catch (FileNotFoundException e) {
            System.err.println("Tập tin nguồn không tồn tại");
        } catch (FileIsExist e){
            System.err.println("Tập tin đích đã tồn tại");
        } catch(IOException e){
            System.err.println("Tập tin bị lỗi");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter source file:");
        String sourcePath = scanner.nextLine();
        System.out.println("Enter destination file:");
        String destinationPath = scanner.nextLine();

        copyfile(sourcePath,destinationPath);

    }
}
