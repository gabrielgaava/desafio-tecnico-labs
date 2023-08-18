package org.com.labs.model;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;

import static org.com.labs.utils.FormatUtils.tabs;

public class User {

    private Integer userId;

    private String name;

    private HashMap<Integer, Order> orders;

    public User(){};

    public User(Integer userId, String name){
        this.userId = userId;
        this.name = name;
    };

    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public HashMap<Integer, Order> getOrders() { return orders; }

    public List<Order> getOrdersAsList() {
        return new ArrayList<>(this.orders.values());
    }

    public void setOrders(HashMap<Integer, Order> orders) { this.orders = orders; }

    public void addOrUpdateOder(Order order, Product product) {

        order.addProduct(product);

        if (this.orders == null || this.orders.isEmpty()) {
            HashMap<Integer, Order> newOrders = new HashMap<>();
            newOrders.put(order.getOrderId(), order);
            this.orders = newOrders;
            return;
        }

        HashMap<Integer, Order> newOrders = this.orders;

        if (newOrders.get(order.getOrderId()) != null) {
            Order thisOrder = newOrders.get(order.getOrderId());
            thisOrder.addProduct(product);
            newOrders.put(thisOrder.getOrderId(), thisOrder);
            this.orders = newOrders;
            return;
        }

        newOrders.put(order.getOrderId(), order);
        this.orders = newOrders;
        return;
    }

    /**
     * @return JSON String that represents the User model
     * **/
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        Formatter formatter = new Formatter(builder);

        formatter.format(tabs(1) + "{%n");
        formatter.format(tabs(2) + "\"user_id\": \"%s\",%n", this.userId);
        formatter.format(tabs(2) + "\"name\": \"%s\",%n", this.name);

        if(this.getOrdersAsList() != null && this.getOrdersAsList().size() > 0) {
            List<Order> orders = this.getOrdersAsList();
            formatter.format(tabs(2) + "\"orders\": [%n");

            for(int i = 0; i < orders.size(); i++) {
                formatter.format("%s", orders.get(i).toJson());
                if(i + 1 == orders.size()) {
                    formatter.format("%n");
                } else {
                    formatter.format(",%n");
                }
            }

            formatter.format(tabs(2) + "]%n");
        }

        formatter.format(tabs(1) + "}");

        formatter.flush();
        return builder.toString();
    }


}
