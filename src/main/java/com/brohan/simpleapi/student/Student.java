package com.brohan.simpleapi.student;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity //this indicates that the Student class is correlated with a table in the database.
@Table /* this annotation can specify the details of the table that will
be used to persist the entity int eh database. */
public class Student {
    // defines a primary key generator that ma  y be referenced by name when a
    // generator element is specified for the GeneratedValue annotation
    // @GeneratedValue automatically generates the value of the primary id
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "id")
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient // age won't show up as a column in the database.
    private Integer age;

    public Student(){}

    public Student(Long id, String name,
                   String email, LocalDate dob){
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name,
                   String email,
                   LocalDate dob){
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
