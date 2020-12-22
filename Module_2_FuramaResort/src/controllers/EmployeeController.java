package controllers;

import commons.constant.FilePath;
import commons.convert_csv.ConverterCSV;
import commons.convert_csv.FormatCSV_Employee;
import commons.input_object.EmployeeInput;
import models.Employee;
import models.EmployeeFolder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeController {
    public static final Scanner scanner = new Scanner(System.in);
    public static final ConverterCSV<Employee> converter = new ConverterCSV<>(new FormatCSV_Employee());
    private List<Employee> employeeList;

    public void displayEmployeeMenu() {
        int choice;
        do {
            System.out.println("Employee Menu" +
                    "\n1.\tAdd New Employee" +
                    "\n2.\tShow Employee" +
                    "\n3.\tBack to Main Menu" +
                    "\n4.\tExit.");
            System.out.print("Enter your choice:\t");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    showEmployee();
                    break;
                case 3:
                    findEmployee();
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(3);
                default:
                    System.out.println("Incorrect choice. Please choose again.");
            }
        } while (choice != 4);
    }


    public EmployeeController() {
        this.employeeList =  converter.readFileToList(FilePath.EMPLOYEE.getFilePath());
    }

    private void addNewEmployee(){
        Employee employee = new EmployeeInput().create();
        employeeList.add(employee);

        converter.writeListToCSVFile(employeeList,FilePath.EMPLOYEE.getFilePath());
    }

    private void showEmployee(){
        Map<String,Employee> employeeMap = new LinkedHashMap<>();
        for(Employee employee: employeeList){
            employeeMap.put(employee.getId(),employee);
        }

        for(Map.Entry<String,Employee> entry: employeeMap.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    private void findEmployee() {
        System.out.println("Enter id employee");
        String id = scanner.nextLine();
        EmployeeFolder folder = new EmployeeFolder();
        Employee employee = folder.searchByID(id);
        if(employee!=null){
            System.out.println(employee);
        } else{
            System.out.println("No such employee!");
        }

    }
}
