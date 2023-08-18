package org.com.labs.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import static org.com.labs.utils.FormatUtils.tabs;

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

    /**
     * @return JSON String that represents the Order model
     * **/
    public String toJson() {
        StringBuilder string = new StringBuilder();
        Formatter formatter = new Formatter(string);

        formatter.format(tabs(3) + "{%n");

        if(this.orderId != null)
            formatter.format(tabs(4) + "\"order_id\": \"%s\",%n", this.orderId);

        if(this.total != null)
            formatter.format(tabs(4) + "\"total\": \"%s\",%n", this.total.toString());

        if(this.date != null)
            formatter.format(tabs(4) + "\"date\": \"%s\",%n", this.date);

        if(this.products != null && this.products.size() > 0) {
            formatter.format(tabs(4) + "\"products\": [%n");

            /* For each product in the list, we build the JSON that represents the model */
            for(int i = 0; i < this.products.size(); i++) {

                formatter.format("%s", this.products.get(i).toJson());

                // Last product of the list (no comma)
                if(i + 1 == this.products.size()) {
                    formatter.format("%n");
                } else {
                    formatter.format(",%n");
                }
            }

            formatter.format(tabs(4) + "]%n");
        }

        formatter.format(tabs(3) + "}");
        formatter.flush();
        return string.toString();
    }
}
