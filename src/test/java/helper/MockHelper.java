package helper;

import org.com.labs.model.Order;
import org.com.labs.model.Product;
import org.com.labs.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class MockHelper {

    public static HashMap<Integer, User> getUserHashMap() {
        HashMap<Integer, User> map = new HashMap<>();
        map.put(70, getBasicUser());
        return map;
    }

    public static HashMap<Integer, User> getUserHashMapWith2Users() {
        HashMap<Integer, User> map = new HashMap<>();
        map.put(70, getBasicUser());
        map.put(75, getBasicUser());
        return map;
    }

    public static User getBasicUser() {
        User user = new User(70, "Palmer Prosacco");
        HashMap<Integer, Order> oderMaps = new HashMap<>();
        Order order = getBasicOder();
        oderMaps.put(order.getOrderId(), order);
        user.setOrders(oderMaps);

        return user;
    }

    public static Order getBasicOder() {
        Order order = new Order(753, "2021-03-08");
        List<Product> products = new ArrayList<>();
        products.add(getBasicProduct());
        order.setProducts(products);
        order.setTotal(getBasicProduct().getValue());
        return order;
    }

    public static Product getBasicProduct() {
        return new Product(1, new BigDecimal("1836.74"));
    }

    public static String getJsonString() {
        return "[\n" +
                "\t{\n" +
                "\t\t\"user_id\": \"70\",\n" +
                "\t\t\"name\": \"Palmer Prosacco\",\n" +
                "\t\t\"orders\": [\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"order_id\": \"753\",\n" +
                "\t\t\t\t\"total\": \"1836.74\",\n" +
                "\t\t\t\t\"date\": \"2021-03-08\",\n" +
                "\t\t\t\t\"products\": [\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"product_id\": \"1\",\n" +
                "\t\t\t\t\t\t\"value\": \"1836.74\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t]\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"user_id\": \"70\",\n" +
                "\t\t\"name\": \"Palmer Prosacco\",\n" +
                "\t\t\"orders\": [\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"order_id\": \"753\",\n" +
                "\t\t\t\t\"total\": \"1836.74\",\n" +
                "\t\t\t\t\"date\": \"2021-03-08\",\n" +
                "\t\t\t\t\"products\": [\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"product_id\": \"1\",\n" +
                "\t\t\t\t\t\t\"value\": \"1836.74\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t]\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t}\n" +
                "]";
    }

    public static String getOrderJson() {
        return "{\n" +
                "\t\t\t\t\"order_id\": \"753\",\n" +
                "\t\t\t\t\"total\": \"1836.74\",\n" +
                "\t\t\t\t\"date\": \"2021-03-08\",\n" +
                "\t\t\t\t\"products\": [\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"product_id\": \"1\",\n" +
                "\t\t\t\t\t\t\"value\": \"1836.74\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t]\n" +
                "\t\t\t}";
    }

    public static String getProductJson() {
        return "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"product_id\": \"1\",\n" +
                "\t\t\t\t\t\t\"value\": \"1836.74\"\n" +
                "\t\t\t\t\t}";
    }

    public static String getUserJson() {
        return "{\n" +
                "\t\t\"user_id\": \"70\",\n" +
                "\t\t\"name\": \"Palmer Prosacco\",\n" +
                "\t\t\"orders\": [\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"order_id\": \"753\",\n" +
                "\t\t\t\t\"total\": \"1836.74\",\n" +
                "\t\t\t\t\"date\": \"2021-03-08\",\n" +
                "\t\t\t\t\"products\": [\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"product_id\": \"1\",\n" +
                "\t\t\t\t\t\t\"value\": \"1836.74\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t]\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t}";
    }

}
