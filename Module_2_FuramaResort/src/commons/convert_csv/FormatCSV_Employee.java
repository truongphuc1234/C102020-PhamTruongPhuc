package commons.convert_csv;

import models.Employee;

public class FormatCSV_Employee implements FormatCSV<Employee> {
    public static final String HEADER = "id,name,address";
    @Override
    public String getHeader() {
        return HEADER;
    }

    @Override
    public String convertToStringCSV(Employee employee) {
        return employee.getId()+COMMA_DELIMITER+
                employee.getName() + COMMA_DELIMITER +
                employee.getAddress();
    }

    @Override
    public Employee getObjectByStringCSV(String string) {
        String[] stringArray = string.split(",");
        return new Employee(stringArray[0],stringArray[1],stringArray[2]);
    }
}
