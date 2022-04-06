package models;

import java.util.Objects;

public class Person {

    private int id;
    private String pname;
    private String surname;
    private String address;
    private int phone;
    private String dni;
    private PersonType eType;

    public Person(int id, String pname, String surname, String address, int phone, String dni, PersonType eType) {
        this.id = id;
        this.pname = pname;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.dni = dni;
        this.eType = eType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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

    public PersonType geteType() {
        return eType;
    }

    public void seteType(PersonType eType) {
        this.eType = eType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && phone == person.phone && Objects.equals(pname, person.pname) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address) && Objects.equals(dni, person.dni) && eType == person.eType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pname, surname, address, phone, dni, eType);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", dni='" + dni + '\'' +
                ", eType=" + eType +
                '}';
    }
}
