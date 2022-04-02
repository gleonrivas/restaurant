package models;

import java.util.Objects;

public class Employee extends Person{

    public Employee(int id, String name, String surname, String address, int phone, String dni) {
        super(id, name, surname, address, phone, dni);
    }

    private EmployeeType eType;

    public Employee(int id, String name, String surname, String address, int phone, String dni, EmployeeType eType) {
        super(id, name, surname, address, phone, dni);
        this.eType = eType;
    }

    public EmployeeType geteType() {
        return eType;
    }

    public void seteType(EmployeeType eType) {
        this.eType = eType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return eType == employee.eType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eType);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eType=" + eType +
                '}';
    }
}
