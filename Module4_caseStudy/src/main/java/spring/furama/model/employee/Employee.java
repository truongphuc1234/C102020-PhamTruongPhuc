package spring.furama.model.employee;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_name", nullable = false, length = 45)
    @Size(max = 45, message = "Name must not be exceed 45 characters")
    @NotBlank(message = "Name must not be empty")
    private String employeeName;

    @Column(name = "employee_birthday", nullable = false)
    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",message = "Date must be format YYYY-MM-DD")
    @NotNull(message = "Date must be not empty")
    private String employeeBirthday;

    @Column(name = "employee_id_card", nullable = false, length = 45)
    @Pattern(regexp = "^\\d{9,12}$", message = "Id card must be format 'XXXXXXXXX' or 'XXXXXXXXXXXX'(X is number)")
    @NotNull(message = "Id card must be not empty")
    private String employeeIdCard;

    @Column(name = "employee_salary")
    @DecimalMin(value = "0.01", message = "Salary must be positive number")
    @NotNull(message = "Salary must not be empty")
    private Double employeeSalary;

    @Column(name = "employee_phone", nullable = false, length = 45)
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$",message = "Phone number must format 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx")
    @NotNull(message = "Phone number must be not empty")
    private String employeePhone;

    @Column(name = "employee_email")
    @Email(message = "Email must be format abc@xyz.abc")
    private String employeeEmail;

    @Column(name = "employee_address")
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "position_id", nullable = false)
    @NotNull(message = "Position must be not empty")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree", referencedColumnName = "education_degree_id", nullable = false)
    @NotNull(message = "Education degree must be not empty")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id", nullable = false)
    @NotNull(message = "Division must be not empty")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private AppUser appUser;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
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

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
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

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
