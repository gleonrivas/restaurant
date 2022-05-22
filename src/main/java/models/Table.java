package models;

import java.util.Objects;

public class Table {

    private int id;
    private TableAvailability tAvailability;
    private int capacity;

    public Table(int id, TableAvailability tAvailability, int capacity) {
        this.id = id;
        this.tAvailability = tAvailability;
        this.capacity = capacity;
    }

    public Table(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TableAvailability gettAvailability() {
        return tAvailability;
    }

    public void settAvailability(TableAvailability tAvailability) {
        this.tAvailability = tAvailability;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return id == table.id && capacity == table.capacity && tAvailability == table.tAvailability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tAvailability, capacity);
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", tAvailability=" + tAvailability +
                ", capacity=" + capacity +
                '}';
    }
}

