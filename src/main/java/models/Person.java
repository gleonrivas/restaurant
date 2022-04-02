package models;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private String surname;
    private String address;
    private int phone;
    private String dni;

    public Person(int id, String name, String surname, String address, int phone, String dni) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && phone == person.phone && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address) && Objects.equals(dni, person.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, address, phone, dni);
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", dni='" + dni + '\'' +
                '}';
    }
}
