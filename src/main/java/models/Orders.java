package models;

import java.util.Objects;

public class Orders {
    private int idEmployee;
    private int idTable;
    private int idProduct;
    private int quantity;
    private int state;

    public Orders(int idEmployee, int idTable, int idProduct, int quantity, int state) {
        this.idEmployee = idEmployee;
        this.idTable = idTable;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.state = state;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getState() {
        return state;
    }

    public int setState(int state) {
        this.state = state;
        return state;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return idEmployee == orders.idEmployee && idTable == orders.idTable && idProduct == orders.idProduct && quantity == orders.quantity && state == orders.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployee, idTable, idProduct, quantity, state);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idEmployee=" + idEmployee +
                ", idTable=" + idTable +
                ", idProduct=" + idProduct +
                ", quantity=" + quantity +
                ", state=" + state +
                '}';
    }
}
