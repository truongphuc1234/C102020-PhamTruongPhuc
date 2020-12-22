package models;

import commons.constant.FilePath;
import commons.convert_csv.ConverterCSV;
import commons.convert_csv.FormatCSV_Employee;

import java.util.List;
import java.util.Stack;

public class EmployeeFolder {

    Stack<Employee> stack = new Stack<>();

    public EmployeeFolder() {
        List<Employee> list = new ConverterCSV<>(new FormatCSV_Employee()).readFileToList(FilePath.EMPLOYEE.getFilePath());
        for(Employee employee: list){
            stack.push(employee);
        }
    }

    public Employee searchByID(String id){
        Stack<Employee> tempStack = new Stack<>();
        Employee temp= null;
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(temp.getId().equals(id)){
                return temp;
            }
            tempStack.push(temp);
        }
        return temp;
    }
}
