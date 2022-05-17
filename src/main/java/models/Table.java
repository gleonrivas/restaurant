package models;

import java.util.Objects;

public class Table {

    private int id;
    private int location;
    private TableAvailability tAvailability;
    private int capacity;

    public Table(int id, int location, TableAvailability tAvailability, int capacity) {
        this.id = id;
        this.location = location;
        this.tAvailability = tAvailability;
        this.capacity = capacity;
    }

    public Table(int id, int location, int capacity) {
        this.id = id;
        this.location = location;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
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
        return id == table.id && location == table.location && capacity == table.capacity && tAvailability == table.tAvailability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, tAvailability, capacity);
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", location=" + location +
                ", tAvailability=" + tAvailability +
                ", capacity=" + capacity +
                '}';
    }
}

