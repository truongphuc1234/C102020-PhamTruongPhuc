package controllers;


import commons.constant.FilePath;
import commons.convert_csv.*;
import commons.input_object.HouseInput;
import commons.input_object.RoomInput;
import commons.input_object.ServiceInput;
import commons.input_object.VillaInput;
import models.Services;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ServiceController {

    private Scanner scanner = new Scanner(System.in);

    public void addNewService() {
        int choice;
        do {
            System.out.println("Menu: Add New Service" +
                    "\n1.\tAdd New Villa" +
                    "\n2.\tAdd New House" +
                    "\n3.\tAdd New Room" +
                    "\n4.\tBack to menu" +
                    "\n5.\tExit.");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewService(FilePath.VILLA.getFilePath(), new FormatCSV_Villa(), new VillaInput());
                    break;
                case 2:
                    addNewService(FilePath.HOUSE.getFilePath(), new FormatCSV_House(), new HouseInput());
                    break;
                case 3:
                    addNewService(FilePath.ROOM.getFilePath(), new FormatCSV_Room(), new RoomInput());
                    break;
                case 4:
                    System.out.println("------------------------------------------");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter your choice again!");
                    break;
            }
        } while (choice != 4);
    }

    public void showServices() {
        int choice;
        do {
            System.out.println("Menu: Show Services" +
                    "\n1.\tShow All Villa" +
                    "\n2.\tShow All House" +
                    "\n3.\tShow All Room" +
                    "\n4.\tShow All Name Villa Not Duplicated" +
                    "\n5.\tShow All Name House Not Duplicated" +
                    "\n6.\tShow All Name Room Not Duplicated" +
                    "\n7.\tBack To Menu" +
                    "\n8.\tExit.");
            System.out.print("Enter your choice:\t");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayService(FilePath.VILLA.getFilePath(),new FormatCSV_Villa());
                    break;
                case 2:
                    displayService(FilePath.HOUSE.getFilePath(),new FormatCSV_House());
                    break;
                case 3:
                    displayService(FilePath.ROOM.getFilePath(),new FormatCSV_Room());
                    break;
                case 4:
                    displayNotDuplicateName(FilePath.VILLA.getFilePath(),new FormatCSV_Villa());
                    break;
                case 5:
                    displayNotDuplicateName(FilePath.HOUSE.getFilePath(),new FormatCSV_House());
                    break;
                case 6:
                    displayNotDuplicateName(FilePath.ROOM.getFilePath(),new FormatCSV_Room());
                    break;
                case 7:
                    System.out.println("------------------------------------------");
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter your choice again!");
                    break;
            }
        } while (choice != 7);
    }

    private <E extends Services> void addNewService(String filePath, FormatCSV<E> formatCSV, ServiceInput<E> serviceInput) {
        ConverterCSV<E> convert = new ConverterCSV<>(formatCSV);

        List<E> list = convert.readFileToList(filePath);
        E service = serviceInput.create();
        list.add(service);

        convert.writeListToCSVFile(list, filePath);
    }

    private <E extends Services> void displayService(String filePath, FormatCSV<E> formatCSV){
        ConverterCSV<E> convert = new ConverterCSV<>(formatCSV);

        List<E> list = convert.readFileToList(filePath);
        for(E element: list){
            element.showInfor();
        }
    }

    private <E extends Services> void displayNotDuplicateName(String filePath, FormatCSV<E> formatCSV){
        ConverterCSV<E> convert = new ConverterCSV<>(formatCSV);

        Set<String> listNamesNotDuplicated = new TreeSet<>();
        List<E> list = convert.readFileToList(filePath);

        for (E element : list) {
            listNamesNotDuplicated.add(element.getName());
        }

        for(String element: listNamesNotDuplicated){
            System.out.println(element);
        }

    }
}
