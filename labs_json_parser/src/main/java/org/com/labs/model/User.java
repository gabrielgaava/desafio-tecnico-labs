package org.com.labs.model;

import java.util.HashMap;

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


}
