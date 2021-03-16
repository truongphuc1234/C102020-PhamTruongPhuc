package spring.furama.model.employee;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "employee_name", nullable = false, length = 45)
    private String employeeName;
    @Column(name = "employee_birthday", nullable = false)
    private String employeeBirthday;
    @Column(name = "employee_id_card", nullable = false, length = 45)
    private String employeeIdCard;
    @Column(name = "employee_salary")
    private double employeeSalary;
    @Column(name = "employee_phone", nullable = false, length = 45)
    private String employeePhone;
    @Column(name = "employee_email")
    private String employeeEmail;
    @Column(name = "employee_address")
    private String employeeAddress;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "position_id", nullable = false)
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_degree", referencedColumnName = "education_degree_id", nullable = false)
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id", nullable = false)
    private Division division;
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private AppUser appUser;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public AppUser getUserAccount() {
        return appUser;
    }

    public void setUserAccount(AppUser appUser) {
        this.appUser = appUser;
    }
}
