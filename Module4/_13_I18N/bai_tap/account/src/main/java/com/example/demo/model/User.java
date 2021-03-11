package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min =5, max = 45, message ="Sai tên rồi bạn ơi")
    private String firstName;

    @Size(min =5, max = 45, message ="Sai tên rồi bạn ơi")
    private String lastName;

    @Pattern(regexp = "(^$|^0[0-9]{9,10})$", message="Sai số điện thoại rồi kìa")
    private String phoneNumber;

    @Min( value = 18, message="Con nít ra chỗ khác chơi")
    private int age;

    @Email(message="email này không có thực")
    private String email;

    public User() {
    }

    public User(@Min(5) @Max(45) String firstName, @Min(5) @Max(45) String lastName, @Pattern(regexp = "(^$|^0[0-9]{9,10})$") String phoneNumber, @Min(18) int age, @Email String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
