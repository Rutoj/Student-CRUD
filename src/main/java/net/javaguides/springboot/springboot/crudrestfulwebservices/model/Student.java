package net.javaguides.springboot.springboot.crudrestfulwebservices.model;

import jakarta.persistence.*;

@Entity
@Table(name= "student")
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
        private long id;

    @Column(name="first_Name")
    private String firstName;
    @Column(name="last_Name")
    private String lastName;
    @Column(name="Email_ id")
        private String emailId;

        public Student(){
            super();
        }

    public Student(long id, String firstName, String lastName, String emailId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
