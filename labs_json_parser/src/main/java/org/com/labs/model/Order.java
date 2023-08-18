package org.com.labs.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Integer orderId;

    private BigDecimal total;

    private String date;

    List<Product> products;

    public Order() {};

    public Order(Integer orderId, String date) {
        this.orderId = orderId;
        this.date = date;
    };

    public Integer getOrderId() { return orderId; }

    public void setOrderId(Integer orderId) { this.orderId = orderId; }

    public BigDecimal getTotal() { return total; }

    public void setTotal(BigDecimal total) { this.total = total; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public List<Product> getProducts() { return products; }

    public void setProducts(List<Product> products) { this.products = products; }

    public void addProduct(Product product) {
        List<Product> productList = new ArrayList<>();
        BigDecimal total = product.getValue();

        if(this.products != null && !this.products.isEmpty()) {
            productList = this.products;
            productList.add(product);
            total = this.total.add(product.getValue());
        }

        else {
            productList.add(product);
        }

        this.products = productList;
        this.total = total;
    }
}
