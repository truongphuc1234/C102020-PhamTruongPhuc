package model.bean.employee;

public class EmployeeView extends Employee {
    private String positionName;
    private String educationDegreeName;
    private String divisionName;

    public EmployeeView() {
    }

    public EmployeeView(int employeeId, String employeeName, String employeeBirthday, String employeeIdCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, int positionId, int educationDegreeId, int divisionId, String username, String positionName, String educationDegreeName, String divisionName) {
        super(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, username);
        this.positionName = positionName;
        this.educationDegreeName = educationDegreeName;
        this.divisionName = divisionName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
