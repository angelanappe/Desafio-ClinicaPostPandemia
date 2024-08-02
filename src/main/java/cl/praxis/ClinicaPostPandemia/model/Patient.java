package cl.praxis.ClinicaPostPandemia.model;

import java.time.LocalDate;

public class Patient {

    private Long id;
    private String name;
    private String lastName;
    private String rut;
    private LocalDate bornDate;

    public Patient() {
    }

    public Patient(Long id, String name, String lastName, String rut, LocalDate bornDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.rut = rut;
        this.bornDate = bornDate;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rut='" + rut + '\'' +
                ", bornDate=" + bornDate +
                '}';
    }
}
