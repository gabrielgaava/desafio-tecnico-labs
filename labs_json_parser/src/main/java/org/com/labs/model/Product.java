package org.com.labs.model;

import org.com.labs.utils.FormatUtils;

import java.math.BigDecimal;
import java.util.Formatter;

import static org.com.labs.utils.FormatUtils.tabs;

public class Product {

    private Integer productId;

    private BigDecimal value;

    public Product(){};

    public Product(Integer productId, BigDecimal value){
        this.productId = productId;
        this.value = value;
    }

    public Integer getProductId() { return productId; }

    public void setProductId(Integer productId) { this.productId = productId; }

    public BigDecimal getValue() { return value; }

    public void setValue(BigDecimal value) { this.value = value; }

    /**
     * @return JSON String that represents the Product model
     * **/
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        Formatter formatter = new Formatter(builder);

        formatter.format(tabs(5) + "{%n");
        formatter.format(tabs(6) + "\"product_id\": \"%s\",%n", this.productId);
        formatter.format(tabs(6) + "\"value\": \"%s\"%n", this.value.toString());
        formatter.format(tabs(5) + "}");

        formatter.flush();
        return builder.toString();
    }

}
