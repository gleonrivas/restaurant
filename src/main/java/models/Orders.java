package models;

import java.util.Objects;

public class Orders {
    private int idEmployee;
    private int id_order;
    private int idTable;
    private int idProduct;
    private int quantity;
    private int state;

    public Orders(int idEmployee, int id_order, int idTable, int idProduct, int quantity, int state) {
        this.idEmployee = idEmployee;
        this.id_order = id_order;
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

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
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
        return idEmployee == orders.idEmployee && id_order == orders.id_order && idTable == orders.idTable && idProduct == orders.idProduct && quantity == orders.quantity && state == orders.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployee, id_order, idTable, idProduct, quantity, state);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idEmployee=" + idEmployee +
                ", id_order=" + id_order +
                ", idTable=" + idTable +
                ", idProduct=" + idProduct +
                ", quantity=" + quantity +
                ", state=" + state +
                '}';
    }
}
