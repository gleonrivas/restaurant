package models;

import javax.swing.*;
import java.util.Objects;

public class Product {

    private int id;
    private String productType;
    private String description;
    private int code;
    private double price;

    public Product(int id, String productType, String description, int code, double price) {
        this.id = id;
        this.productType = productType;
        this.description = description;
        this.code = code;
        this.price = price;
    }

    public Product(JTextField idField, JComboBox typeCombo, JTextField codeField, JTextField descriptionField, JTextField priceField) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && code == product.code && Double.compare(product.price, price) == 0 && Objects.equals(productType, product.productType) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productType, description, code, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productType='" + productType + '\'' +
                ", description='" + description + '\'' +
                ", code=" + code +
                ", price=" + price +
                '}';
    }
}
