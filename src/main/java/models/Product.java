package models;

import java.util.Objects;

public class Product {

    private int id;
    private ProductType productType;
    private String name;
    private int code;
    private double price;


    public Product(int idData, String typeData, int codeData, String nameData, double priceData) {
    }

    public Product(int id, ProductType productType, String name, int code, double price) {
        this.id = id;
        this.productType = productType;
        this.name = name;
        this.code = code;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return id == product.id && code == product.code && Double.compare(product.price, price) == 0 && productType == product.productType && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productType, name, code, price);
    }

    @Override
    public String
    toString() {
        return "Product{" +
                "id=" + id +
                ", productType=" + productType +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", price=" + price +
                '}';
    }
}